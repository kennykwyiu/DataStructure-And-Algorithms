package org.kenny.algorithms.strings;
import org.junit.Test;
import static org.junit.Assert.*;
public class TimeConversionSimpleDataFormatTest {
    @Test
    public void testAMConversion() {
        assertEquals("00:00:00", TimeConversionSimpleDataFormat.timeConversion("12:00:00AM"));
        assertEquals("09:05:45", TimeConversionSimpleDataFormat.timeConversion("09:05:45AM"));
    }

    @Test
    public void testPMConversion() {
        assertEquals("12:00:00", TimeConversionSimpleDataFormat.timeConversion("12:00:00PM"));
        assertEquals("17:30:15", TimeConversionSimpleDataFormat.timeConversion("05:30:15PM"));
    }

    @Test
    public void testInvalidInput() {
        // Test invalid input format
        assertEquals("", TimeConversionSimpleDataFormat.timeConversion("12:00:00")); // Missing AM/PM
        assertEquals("", TimeConversionSimpleDataFormat.timeConversion("12:00:00XM")); // Invalid AM/PM indicator
        assertEquals("", TimeConversionSimpleDataFormat.timeConversion("24:00:00AM")); // Invalid hour

        // Test invalid time values
        assertEquals("", TimeConversionSimpleDataFormat.timeConversion("13:60:00PM")); // Invalid minutes
        assertEquals("", TimeConversionSimpleDataFormat.timeConversion("12:00:60PM")); // Invalid seconds
    }
}
