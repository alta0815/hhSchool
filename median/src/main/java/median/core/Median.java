package median.core;

import java.util.List;

public class Median {

    public Median() {
    }

    public Double getMedian(List<Double> firstArray, List<Double> secondArray, int length) {
        Double firstMedian;
        Double secondMedian;

        if (length <= 0) {
            throw new RuntimeException("Array size must be greater than zero");
        }

        if (length == 1) {
            return (firstArray.get(0) + secondArray.get(0)) / 2.0;
        }

        if (length == 2) {
            return (Math.max(firstArray.get(0), secondArray.get(0)) + Math.min(firstArray.get(1), secondArray.get(1))) / 2.0;
        }

        firstMedian = median(firstArray, length);
        secondMedian = median(secondArray, length);

        if (firstMedian.equals(secondMedian)) {
            return firstMedian;
        }

        if (firstMedian < secondMedian) {
            if (length % 2 == 0) {
                return getMedian(firstArray.subList(length / 2 - 1, length), secondArray, length - length / 2 - 1);
            } else {
                return getMedian(firstArray.subList(length / 2, length), secondArray, length - length / 2);
            }
        } else {
            if (length % 2 == 0) {
                return getMedian(secondArray.subList(length / 2 - 1, length), firstArray, length - length / 2 - 1);
            } else {
                return getMedian(secondArray.subList(length / 2, length), firstArray, length - length / 2);
            }
        }
    }

    private double median(List<Double> array, int length) {
        if (length % 2 == 0) {
            return (array.get(length / 2) + array.get(length / 2 - 1)) / 2;
        } else {
            return array.get(length / 2);
        }
    }
}
