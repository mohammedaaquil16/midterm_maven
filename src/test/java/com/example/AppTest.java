package com.example;

import static org.junit.Assert.*;
import org.junit.Test;

public class AppTest {

    @Test
    public void testEligibleAttendance() {
        App app = new App();
        App.AttendanceResult result = app.analyze(80, 100);
        assertEquals(80.0, result.percentage, 0.01);
        assertTrue(result.isEligible);
        assertEquals("Eligible", result.status);
    }

    @Test
    public void testWarningStatus() {
        App app = new App();
        App.AttendanceResult result = app.analyze(50, 100);
        assertFalse(result.isEligible);
        assertTrue(result.status.contains("WARNING"));
    }

    @Test
    public void testBoundaryCondition() {
        App app = new App();
        // Exactly 75% should be eligible
        App.AttendanceResult result = app.analyze(75, 100);
        assertTrue(result.isEligible);
    }
}