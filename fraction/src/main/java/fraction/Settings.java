package fraction;

import org.kohsuke.args4j.Option;

public class Settings {

    @Option(name = "-a", required = true)
    private static int a;

    @Option(name = "-b", required = true)
    private static int b;

    @Option(name = "-k", required = true)
    private static int base;

    public Settings() {

    }

    public static int getA() {
        return a;
    }

    public static int getB() {
        return b;
    }

    public static int getBase() {
        return base;
    }
}
