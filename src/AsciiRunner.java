public class AsciiRunner {
    public static void main(String[] args) throws InterruptedException {
        String[] frames = {
                "🏃       ",
                "  🏃     ",
                "    🏃   ",
                "      🏃 ",
                "        🏃",
                "      🏃 ",
                "    🏃   ",
                "  🏃     ",
                "🏃       "
        };

        for (int i = 0; i < 3; i++) {
            for (String frame : frames) {
                System.out.print("\r" + frame);
                Thread.sleep(150);
            }
        }
        System.out.println("\n🎯 Финиш!");
    }
}
