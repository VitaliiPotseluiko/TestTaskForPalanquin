package org.sorter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Test;

class StringSorterTest {
    private final StringSorter stringSorter = new StringSorter();

    @Test
    void sortStringsWithPrefixA_ok() {
        List<String> unsortedStrings = List.of("apple", "banana", "grape", "avocado", "cherry");
        List<String> expected = List.of("banana", "cherry", "grape", "avocado", "apple");
        List<String> actual = stringSorter.sortStrings(unsortedStrings, "a");
        assertEquals(expected, actual);
    }

    @Test
    void sortStringsWithPrefixC_ok() {
        List<String> unsortedStrings = List.of("cabbage", "apple", "carrot", "banana","cucumber",
                "grape", "corn", "avocado", "cherry");
        List<String> expected = List.of("apple", "avocado", "banana", "grape", "cucumber", "corn",
                "cherry", "carrot", "cabbage");
        List<String> actual = stringSorter.sortStrings(unsortedStrings, "c");
        assertEquals(expected, actual);
    }

    @Test
    void sortStringsWithPrefixDis_ok() {
        List<String> unsortedStrings = List.of("like", "dislike", "disagree", "work", "agree",
                "go", "disconnect", "come", "dismiss");
        List<String> expected = List.of("agree", "come", "go", "like", "work", "dismiss", "dislike",
                "disconnect", "disagree");
        List<String> actual = stringSorter.sortStrings(unsortedStrings, "dis");
        assertEquals(expected, actual);
    }

    @Test
    void sortStringsWhenSecondParameterIsNull_notOk() {
        List<String> unsortedStrings = List.of("apple", "banana", "grape", "avocado", "cherry");
        assertThrows(RuntimeException.class, () -> stringSorter.sortStrings(unsortedStrings, null),
                "Method should throw " + RuntimeException.class.getName()
                        + " is the second parameter is null");
    }

    @Test
    void sortStringsWhenFirstParameterIsNull_notOk() {
        assertThrows(RuntimeException.class, () -> stringSorter.sortStrings(null, "f"),
                "Method should throw " + RuntimeException.class.getName()
                        + " is the first parameter is null");
    }
}