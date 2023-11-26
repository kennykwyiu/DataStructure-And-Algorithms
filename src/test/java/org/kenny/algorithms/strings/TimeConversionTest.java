package org.kenny.algorithms.strings;

import org.junit.Test;
import static org.junit.Assert.*;

public class TimeConversionTest {

    @Test
    public void testAMConversion() {
        assertEquals("00:00:00", TimeConversion.timeConversion("12:00:00AM"));
        assertEquals("09:05:45", TimeConversion.timeConversion("09:05:45AM"));
    }

    @Test
    public void testPMConversion() {
        assertEquals("12:00:00", TimeConversion.timeConversion("12:00:00PM"));
        assertEquals("17:30:15", TimeConversion.timeConversion("05:30:15PM"));
    }

    @Test
    public void testInvalidInput() {
        // Test invalid input format
        assertEquals("", TimeConversion.timeConversion("12:00:00")); // Missing AM/PM
        assertEquals("", TimeConversion.timeConversion("12:00:00XM")); // Invalid AM/PM indicator
        assertEquals("", TimeConversion.timeConversion("24:00:00AM")); // Invalid hour

        // Test invalid time values
        assertEquals("", TimeConversion.timeConversion("13:60:00PM")); // Invalid minutes
        assertEquals("", TimeConversion.timeConversion("12:00:60PM")); // Invalid seconds
    }
}
