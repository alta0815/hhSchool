package fraction.core;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FractionTest {

    private Fraction fraction;

    @Before
    public void setUp() {
        fraction = new Fraction();
    }

    @Test
    public void fractionWithOnlyIntegerPartTest() {
        assertEquals(fraction.fractionRepresentation(4, 2, 10), "2");
    }

    @Test
    public void simpleFractionTest() {
        assertEquals(fraction.fractionRepresentation(5, 2, 10), "2.5");
    }

    @Test
    public void fractionWithoutIntegerPartTest() {
        assertEquals(fraction.fractionRepresentation(1, 20, 10), "0.05");
    }

    @Test
    public void fractionWithShortPeriodTest() {
        assertEquals(fraction.fractionRepresentation(1, 3, 10), "0.(3)");
    }

    @Test
    public void fractionWithLongPeriodTest() {
        assertEquals(fraction.fractionRepresentation(25, 101, 10), "0.(2475)");
    }

    @Test
    public void periodFractionWithPredPeriodTest() {
        assertEquals(fraction.fractionRepresentation(7, 12, 10), "0.58(3)");
    }

    @Test
    public void fractionInBinBaseTest() {
        assertEquals(fraction.fractionRepresentation(1, 2, 2), "0.1");
    }

    @Test
    public void fractionInOctBase() {
        assertEquals(fraction.fractionRepresentation(1, 5, 8), "0.(1463)");
    }

    @Test
    public void fractionInHexBaseTest() {
        assertEquals(fraction.fractionRepresentation(1, 25, 16), "0.(0A3D7)");
    }

    @Test(expected = RuntimeException.class)
    public void fractionInBaseLessThanTwoTest() {
        fraction.fractionRepresentation(1, 2, 0);
    }

    @Test(expected = ArithmeticException.class)
    public void fractionWithBEqualZero() {
        fraction.fractionRepresentation(1, 0, 21);
    }

    @Test
    public void fractionSignMinusTest() {
        assertEquals(fraction.fractionRepresentation(-1, 2, 10), "-0.5");
        assertEquals(fraction.fractionRepresentation(1, -2, 10), "-0.5");
    }

}

