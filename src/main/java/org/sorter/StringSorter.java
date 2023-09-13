package org.sorter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StringSorter {
    public List<String> sortStrings(List<String> unsortedStrings, String exceptionChar) {
        if (exceptionChar == null) {
            throw new RuntimeException("Can't sort strings. Second parameter is null!");
        }
        if (unsortedStrings == null) {
            throw new RuntimeException("Can't sort strings. String list is null!");
        }
        // created list without words which have specific prefix, sorted them in natural order
        List<String> result = new ArrayList<>(unsortedStrings.stream()
                .filter(w -> w != null && !w.startsWith(exceptionChar))
                .sorted()
                .toList());
        // created list with words which have specific prefix, sorted them in reverse order
        List<String> withSpecPrefixList = unsortedStrings.stream()
                .filter(w -> w != null && w.startsWith(exceptionChar))
                .sorted(Comparator.reverseOrder())
                .toList();
        // join both lists and return result
        result.addAll(withSpecPrefixList);
        return result;
    }
}