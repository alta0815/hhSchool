package fraction.core;

import java.util.HashMap;
import java.util.Map;

public class Fraction {

    public Fraction() {

    }

    public String fractionRepresentation(int a, int b, int base) {

        if (base < 2) {
            throw new RuntimeException("Base must be greater or equal 2");
        }

        if (b == 0) {
            throw new ArithmeticException("b must be not equal 0");
        }

        boolean fractionSign = getFractionSign(a, b);
        String fraction = fractionSign ? "" : "-";

        a = Math.abs(a);
        b = Math.abs(b);

        fraction += getIntegerPart(a / b, base);
        a %= b;
        if (a != 0) {
            fraction += "." + getFractionalPart(a, b, base);
        }
        return fraction;
    }


    private boolean getFractionSign(int a, int b) {
        return !((a < 0 && b > 0) || (a > 0 && b < 0));
    }

    private String getIntegerPart(int num, int base) {
        if (num == 0) return "0";
        String integerPart = "";
        while (num != 0) {
            int aux = num % base;
            integerPart += (char) (aux < 10 ? '0' + aux : 'A' + aux - 10);
            num /= base;
        }
        integerPart = new StringBuilder(integerPart).reverse().toString();
        return integerPart;
    }

    private String getFractionalPart(int num, int den, int base) {
        StringBuilder fractionalPart = new StringBuilder();

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; num != 0 && !map.containsKey(num); ++i) {
            map.put(num, i);
            num *= base;
            int aux = num / den;
            fractionalPart.append((char) (aux < 10 ? '0' + aux : 'A' + aux - 10));
            num %= den;
        }

        if (num != 0) {
            String predPeriod = fractionalPart.substring(0, map.get(num));
            String period = fractionalPart.substring(map.get(num), fractionalPart.length());
            return predPeriod + "(" + period + ")";
        }

        return fractionalPart.toString();
    }

}
