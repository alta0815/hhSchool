package median.core;

import median.Settings;
import median.util.Ordering;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

import java.util.List;

public class MedianFinder {

    private static Settings settings = new Settings();
    private static CmdLineParser parser = new CmdLineParser(settings);

    public static void init(String[] args) {
        try {
            parser.parseArgument(args);
            checkConditionsAndGetMedian(Settings.getFirstArray(), Settings.getSecondArray());
        } catch (CmdLineException e) {
            System.out.println(e.getMessage());
            parser.printUsage(System.out);
        }
    }

    private static void checkConditionsAndGetMedian(List<Double> firstArray, List<Double> secondArray) {

        if (firstArray.size() != secondArray.size()) {
            throw new RuntimeException("Doesn't work for array of unequal size");
        }

        if (!Ordering.isListSorted(firstArray) || !Ordering.isListSorted(secondArray)) {
            throw new RuntimeException("Arrays must be sorted");
        }

        System.out.println("Median is " + new Median().getMedian(firstArray, secondArray, firstArray.size()));

    }
}
