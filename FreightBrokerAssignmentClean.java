import java.util.*;
import java.util.stream.Collectors;

public class FreightBrokerAssignment {

    static class Location {
        String city, state; double lat, lon;
        Location(String city, String state, double lat, double lon) {
            this.city=city; this.state=state; this.lat=lat; this.lon=lon;
        }
        public String toString(){ return city + ", " + state; }
    }
    static class Load {
        String id;
        Location pickup, dropoff;
        double weightLbs;
        String equipmentRequired;
        boolean hazmat;
        boolean reefer;
        double hoursUntilPickupEnd;
        Load(String id, Location p, Location d, double w, String eq, boolean hz, boolean rf, double hrsToPickupEnd){
            this.id=id; this.pickup=p; this.dropoff=d; this.weightLbs=w;
            this.equipmentRequired=eq; this.hazmat=hz; this.reefer=rf;
            this.hoursUntilPickupEnd=hrsToPickupEnd;
        }
    }
    static class Carrier {
        String id, name;
        Location currentLocation;
        Set<String> equipment;
        double maxWeightLbs;
        boolean hazmat, reefer;
        double reliability;
        double costPerMileBase;
        Carrier(String id, String name, Location loc, Set<String> eq, double maxW,
                boolean hz, boolean rf, double rel, double cpm){
            this.id=id; this.name=name; this.currentLocation=loc; this.equipment=eq;
            this.maxWeightLbs=maxW; this.hazmat=hz; this.reefer=rf;
            this.reliability=rel; this.costPerMileBase=cpm;
        }
    }
    static class Quote {
        double total, miles, rpm;
        Quote(double total, double miles, double rpm){
            this.total=total; this.miles=miles; this.rpm=rpm;
        }
    }
    static class AssignmentResult {
        Load load; Carrier carrier; Quote quote;
        double deadheadMiles, tripMiles, score; boolean feasible;
        AssignmentResult(Load l, Carrier c, Quote q, double dh, double tm, double sc, boolean feasible){
            this.load=l; this.carrier=c; this.quote=q; this.deadheadMiles=dh; this.tripMiles=tm;
            this.score=sc; this.feasible=feasible;
        }
    }

    static double miles(Location a, Location b){
        return miles(a.lat, a.lon, b.lat, b.lon);
    }
    static double miles(double lat1, double lon1, double lat2, double lon2){
        double R = 3958.7613;
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double sa = Math.sin(dLat/2), sb = Math.sin(dLon/2);
        double h = sa*sa + Math.cos(Math.toRadians(lat1))*Math.cos(Math.toRadians(lat2))*sb*sb;
        return 2 * R * Math.atan2(Math.sqrt(h), Math.sqrt(1-h));
    }

    static class Market {
        List<Carrier> carriers; List<Load> loads;
        Market(List<Carrier> carriers, List<Load> loads){ this.carriers=carriers; this.loads=loads; }
        double marketFactor(Location pickup){
            int supply=0, demand=0;
            for (Carrier c: carriers) if (miles(pickup, c.currentLocation)<=100) supply++;
            for (Load l: loads)       if (miles(pickup, l.pickup)<=100) demand++;
            if (supply==0) supply=1;
            double ratio = (double)demand/supply;
            double factor = 1.0 + 0.25*(ratio-1.0);
            return Math.max(0.85, Math.min(1.35, factor));
        }
    }

    static class Pricing {
        static final double FUEL_SURCHARGE = 0.15;
        static final double AVG_SPEED_MPH = 55.0;

        static Quote price(Load load, Carrier carrier, Market market){
            double deadhead = miles(carrier.currentLocation, load.pickup);
            double trip     = miles(load.pickup, load.dropoff);
            double cpm = carrier.costPerMileBase;
            if ("REEFER".equalsIgnoreCase(load.equipmentRequired)) cpm += 0.25;
            if ("FLATBED".equalsIgnoreCase(load.equipmentRequired)) cpm += 0.15;
            if (load.hazmat) cpm += 0.30;
            double base = (deadhead + trip) * cpm;
            double fuel = base * FUEL_SURCHARGE;
            double total = (base + fuel) * market.marketFactor(load.pickup);
            double rpm = (trip <= 1e-9) ? 0.0 : total / trip;
            return new Quote(total, trip, rpm);
        }

        static double score(Load load, Carrier c, Quote q){
            double deadhead = miles(c.currentLocation, load.pickup);
            double timeBonus = timeBonus(load, deadhead);
            return c.reliability * 100.0 - (q.total / 12.0) - (deadhead * 0.4) + timeBonus;
        }

        static double timeBonus(Load load, double deadheadMiles){
            double hoursNeeded = Math.ceil(deadheadMiles / AVG_SPEED_MPH);
            double slack = load.hoursUntilPickupEnd - hoursNeeded;
            double bonus = slack * 0.5;
            return Math.max(-30.0, Math.min(30.0, bonus));
        }

        static boolean feasible(Load l, Carrier c){
            if (c.equipment==null || !c.equipment.contains(l.equipmentRequired)) return false;
            if (l.weightLbs > c.maxWeightLbs) return false;
            if (l.hazmat && !c.hazmat) return false;
            if ("REEFER".equalsIgnoreCase(l.equipmentRequired) && !c.reefer) return false;
            double dh = miles(c.currentLocation, l.pickup);
            double hoursNeeded = Math.ceil(dh / AVG_SPEED_MPH);
            return hoursNeeded <= l.hoursUntilPickupEnd + 2;
        }
    }

    static class Hungarian {
        static int[] solve(double[][] cost) {
            int n = cost.length;
            int m = cost[0].length;
            int dim = Math.max(n, m);
            double[][] a = new double[dim][dim];
            for (int i=0;i<dim;i++)
                for (int j=0;j<dim;j++)
                    a[i][j] = (i<n && j<m) ? cost[i][j] : 0.0;
            double[] u = new double[dim+1];
            double[] v = new double[dim+1];
            int[] p = new int[dim+1];
            int[] way = new int[dim+1];
            for (int i=1;i<=dim;i++){
                p[0] = i;
                int j0 = 0;
                double[] minv = new double[dim+1];
                boolean[] used = new boolean[dim+1];
                Arrays.fill(minv, Double.POSITIVE_INFINITY);
                do {
                    used[j0] = true;
                    int i0 = p[j0];
                    double delta = Double.POSITIVE_INFINITY;
                    int j1 = 0;
                    for (int j=1;j<=dim;j++){
                        if (used[j]) continue;
                        double cur = a[i0-1][j-1] - u[i0] - v[j];
                        if (cur < minv[j]) { minv[j] = cur; way[j] = j0; }
                        if (minv[j] < delta){ delta = minv[j]; j1 = j; }
                    }
                    for (int j=0;j<=dim;j++){
                        if (used[j]) { u[p[j]] += delta; v[j] -= delta; }
                        else { minv[j] -= delta; }
                    }
                    j0 = j1;
                } while (p[j0] != 0);
                do {
                    int j1 = way[j0];
                    p[j0] = p[j1];
                    j0 = j1;
                } while (j0 != 0);
            }
            int[] assignment = new int[dim];
            Arrays.fill(assignment, -1);
            for (int j=1;j<=dim;j++){
                if (p[j] != 0) assignment[p[j]-1] = j-1;
            }
            return assignment;
        }
    }

    static List<AssignmentResult> optimize(List<Load> loads, List<Carrier> carriers){
        Market market = new Market(carriers, loads);
        int n = loads.size(), m = carriers.size();
        double[][] cost = new double[n][m];
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                Load l = loads.get(i);
                Carrier c = carriers.get(j);
                if (!Pricing.feasible(l,c)) {
                    cost[i][j] = 1e9;
                } else {
                    Quote q = Pricing.price(l, c, market);
                    double s = Pricing.score(l, c, q);
                    cost[i][j] = -s;
                }
            }
        }
        int[] match = Hungarian.solve(costPad(cost));
        List<AssignmentResult> out = new ArrayList<>();
        for (int i=0;i<match.length && i<n;i++){
            int j = match[i];
            if (j>=0 && j<m && cost[i][j] < 5e8){
                Load l = loads.get(i);
                Carrier c = carriers.get(j);
                Quote q = Pricing.price(l, c, market);
                double s = Pricing.score(l, c, q);
                double dh = miles(c.currentLocation, l.pickup);
                boolean feasible = Pricing.feasible(l, c);
                out.add(new AssignmentResult(l, c, q, dh, q.miles, s, feasible));
            }
        }
        out.sort((a,b)-> Double.compare(b.score, a.score));
        return out;
    }

    private static double[][] costPad(double[][] c){
        int n=c.length, m=c[0].length, dim=Math.max(n,m);
        double[][] a = new double[dim][dim];
        for (int i=0;i<dim;i++)
            for (int j=0;j<dim;j++)
                a[i][j] = (i<n && j<m) ? c[i][j] : 0.0;
        return a;
    }

    public static void main(String[] args){
        var c1 = new Carrier("C1","Sunshine Logistics",
                new Location("Tampa","FL",27.9506,-82.4572),
                set("VAN","REEFER"), 44000, false, true, 0.92, 1.85);
        var c2 = new Carrier("C2","Bay Area Carriers",
                new Location("San Francisco","CA",37.7749,-122.4194),
                set("VAN","FLATBED"), 48000, true, false, 0.87, 2.05);
        var c3 = new Carrier("C3","Windy City Freight",
                new Location("Chicago","IL",41.8781,-87.6298),
                set("VAN"), 45000, false, false, 0.95, 1.75);
        var c4 = new Carrier("C4","Peach State Haul",
                new Location("Atlanta","GA",33.7490,-84.3880),
                set("VAN","REEFER","FLATBED"), 48000, true, true, 0.89, 1.95);

        var l1 = new Load("L101",
                new Location("Tampa","FL",27.9506,-82.4572),
                new Location("Atlanta","GA",33.7490,-84.3880),
                40000,"VAN",false,false,20.0);
        var l2 = new Load("L102",
                new Location("Orlando","FL",28.5383,-81.3792),
                new Location("Miami","FL",25.7617,-80.1918),
                38000,"REEFER",false,true,15.0);
        var l3 = new Load("L103",
                new Location("Chicago","IL",41.8781,-87.6298),
                new Location("Detroit","MI",42.3314,-83.0458),
                42000,"VAN",false,false,10.0);
        var l4 = new Load("L104",
                new Location("Los Angeles","CA",34.0522,-118.2437),
                new Location("Sacramento","CA",38.5816,-121.4944),
                46000,"FLATBED",true,false,30.0);

        List<Carrier> carriers = List.of(c1,c2,c3,c4);
        List<Load> loads = List.of(l1,l2,l3,l4);

        List<AssignmentResult> result = optimize(loads, carriers);
        for (AssignmentResult ar: result){
            System.out.printf(Locale.US,
                "Load %-5s -> Carrier %-12s | Quote $%.0f | RPM $%.2f | Deadhead %.0f mi | Trip %.0f mi | Score %.1f | %s%n",
                ar.load.id, ar.carrier.name, ar.quote.total, ar.quote.rpm,
                ar.deadheadMiles, ar.tripMiles, ar.score,
                ar.feasible ? "OK" : "TIME-RISK");
        }
    }

    static Set<String> set(String... s){ return Arrays.stream(s).collect(Collectors.toSet()); }
}
