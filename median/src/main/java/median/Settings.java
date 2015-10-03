package median;

import median.args4j.DoubleArrayOptionHandler;
import org.kohsuke.args4j.Option;

import java.util.ArrayList;

public class Settings {
    @Option(name = "-first", handler = DoubleArrayOptionHandler.class, required = true)
    private static ArrayList<Double> firstArray;
    @Option(name = "-second", handler = DoubleArrayOptionHandler.class, required = true)
    private static ArrayList<Double> secondArray;

    public Settings() {

    }

    public static ArrayList<Double> getFirstArray() {
        return firstArray;
    }

    public static ArrayList<Double> getSecondArray() {
        return secondArray;
    }
}
