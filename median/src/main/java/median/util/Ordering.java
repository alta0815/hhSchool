package median.util;

import java.util.List;

public class Ordering {
    public static <T extends Comparable<? super T>> boolean isListSorted(List<T> list) {

        if (list == null || list.isEmpty()) {
            return false;
        }

        if (list.size() == 1) {
            return true;
        }

        T previous = null;
        for (T el : list) {
            if (previous != null && el.compareTo(previous) < 0) {
                return false;
            }
            previous = el;
        }
        return true;
    }
}
