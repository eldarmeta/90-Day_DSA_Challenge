
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

public class CompoundInterestPro {

    // ====== Быстрые double-версии (универсальные формулы) ======

    public static double futureValue(double P, double apr, int n, double tYears) {
        double i = apr / n;
        double N = n * tYears;
        return P * Math.pow(1 + i, N);
    }

    public static double futureValueContinuous(double P, double apr, double tYears) {
        return P * Math.exp(apr * tYears);
    }

    public static double futureValueWithContrib(double P, double apr, int n, double tYears,
                                                double paymentPerPeriod, boolean contributeAtBeginning) {
        double i = apr / n;
        double N = n * tYears;
        double grow = Math.pow(1 + i, N);
        double adj = contributeAtBeginning ? (1 + i) : 1.0;
        double fvAnnuity = (i == 0.0) ? (paymentPerPeriod * N) : (paymentPerPeriod * (grow - 1) / i * adj);
        return P * grow + fvAnnuity;
    }

    public static double apyFromApr(double apr, int n) {
        return Math.pow(1 + apr / n, n) - 1;
    }

    // ====== Финансовая точность BigDecimal (целочисленные периоды) ======

    private static final MathContext MC = new MathContext(20, RoundingMode.HALF_UP);
    private static final BigDecimal ONE = BigDecimal.ONE;

    public static BigDecimal futureValueBD(BigDecimal P, BigDecimal apr, int n, int periods) {
        BigDecimal i = apr.divide(BigDecimal.valueOf(n), MC);
        BigDecimal grow = ONE.add(i).pow(periods, MC);
        return P.multiply(grow, MC);
    }

    public static BigDecimal futureValueWithContribBD(BigDecimal P, BigDecimal apr, int n, int periods,
                                                      BigDecimal paymentPerPeriod, boolean contributeAtBeginning) {
        BigDecimal i = apr.divide(BigDecimal.valueOf(n), MC);
        BigDecimal base = ONE.add(i);
        BigDecimal grow = base.pow(periods, MC);

        BigDecimal fvPrincipal = P.multiply(grow, MC);
        BigDecimal fvAnnuity;
        if (i.compareTo(BigDecimal.ZERO) == 0) {
            fvAnnuity = paymentPerPeriod.multiply(BigDecimal.valueOf(periods), MC);
        } else {
            fvAnnuity = paymentPerPeriod
                    .multiply(grow.subtract(ONE, MC), MC)
                    .divide(i, MC);
            if (contributeAtBeginning) {
                fvAnnuity = fvAnnuity.multiply(base, MC);
            }
        }
        return fvPrincipal.add(fvAnnuity, MC);
    }

    // ====== Демонстрация ======
    public static void main(String[] args) {
        double P = 1000.0;      // начальная сумма
        double apr = 0.10;      // 10% годовых
        int n = 12;             // 12 начислений в год (ежемесячно)
        double years = 3.0;     // 3 года
        double pmt = 200.0;     // ежемесячный взнос
        boolean atBegin = false;

        double fvLump = futureValue(P, apr, n, years);
        double fvCont = futureValueContinuous(P, apr, years);
        double fvWithPMT = futureValueWithContrib(P, apr, n, years, pmt, atBegin);
        double apy = apyFromApr(apr, n);

        System.out.println("=== DOUBLE (FAST) ===");
        System.out.printf("FV (no contrib): %.2f%n", fvLump);
        System.out.printf("FV (continuous): %.2f%n", fvCont);
        System.out.printf("FV (with contrib %s): %.2f%n", (atBegin ? "BEGIN" : "END"), fvWithPMT);
        System.out.printf("APY from APR=%.2f%% @ n=%d => %.4f%%%n", apr*100, n, apy*100);

        BigDecimal Pbd = BigDecimal.valueOf(P);
        BigDecimal aprBD = BigDecimal.valueOf(apr);
        BigDecimal pmtBD = BigDecimal.valueOf(pmt);
        int periods = (int) Math.round(n * years);

        BigDecimal fvBD_noContrib = futureValueBD(Pbd, aprBD, n, periods);
        BigDecimal fvBD_withContrib = futureValueWithContribBD(Pbd, aprBD, n, periods, pmtBD, atBegin);

        NumberFormat money = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println("\n=== BIGDECIMAL (PRECISE) ===");
        System.out.println("FV (no contrib): " + money.format(fvBD_noContrib.setScale(2, RoundingMode.HALF_UP)));
        System.out.println("FV (with contrib): " + money.format(fvBD_withContrib.setScale(2, RoundingMode.HALF_UP)));
    }
}
