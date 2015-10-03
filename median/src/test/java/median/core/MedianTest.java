package median.core;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MedianTest {
    private Median median;

    @Before
    public void setUp() {
        median = new Median();
    }

    @Test(expected = RuntimeException.class)
    public void getMedianWithListLengthLessZeroTest() {
        List<Double> arr1 = new ArrayList<>();
        arr1.add(1.0);
        List<Double> arr2 = new ArrayList<>();
        arr2.add(2.0);
        median.getMedian(arr1, arr2, 0);
    }

    @Test
    public void getMedianWithListLengthOneTest() {
        List<Double> arr1 = new ArrayList<>();
        arr1.add(1.0);
        List<Double> arr2 = new ArrayList<>();
        arr2.add(2.0);
        Assert.assertEquals(median.getMedian(arr1, arr2, arr1.size()), Double.valueOf(1.5));
    }

    @Test
    public void getMedianWithListLengthTwoTest() {
        List<Double> arr1 = new ArrayList<>(Arrays.asList(new Double[]{-1.0, 2.0}));
        List<Double> arr2 = new ArrayList<>(Arrays.asList(new Double[]{3.0, 4.0}));
        Assert.assertEquals(median.getMedian(arr1, arr2, arr1.size()), Double.valueOf(2.5));
    }

    @Test
    public void getMedianTest() {
        List<Double> arr1 = new ArrayList<>(Arrays.asList(new Double[]{1.0, 12.0, 15.0, 26.0, 38.0}));
        List<Double> arr2 = new ArrayList<>(Arrays.asList(new Double[]{2.0, 13.0, 17.0, 30.0, 45.0}));
        Assert.assertEquals(median.getMedian(arr1, arr2, arr1.size()), Double.valueOf(16));
    }


}
