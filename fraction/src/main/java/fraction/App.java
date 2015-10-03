package fraction;

import fraction.core.Fraction;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

public class App {

    private static Settings settings = new Settings();
    private static CmdLineParser parser = new CmdLineParser(settings);

    public static void main(String[] args) {
        try {
            parser.parseArgument(args);
            Fraction fraction = new Fraction();
            System.out.println("Fraction is : " + fraction.fractionRepresentation(Settings.getA(),
                    Settings.getB(), Settings.getBase()));
        } catch (CmdLineException e) {
            System.out.println(e.getMessage());
            parser.printUsage(System.out);
        }
    }
}
