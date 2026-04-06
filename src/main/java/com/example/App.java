package com.example;

public class App {

    public static class AttendanceResult {
        public double percentage;
        public boolean isEligible;
        public String status;

        public AttendanceResult(double percentage, boolean isEligible, String status) {
            this.percentage = percentage;
            this.isEligible = isEligible;
            this.status = status;
        }
    }

    public AttendanceResult analyze(int attended, int total) {
        if (total <= 0) {
            return new AttendanceResult(0.0, false, "Invalid Total Classes");
        }
        
        double pct = (double) attended / total * 100;
        boolean eligible = pct >= 75.0;
        String warning = eligible ? "Eligible" : "WARNING: Attendance below 75%";
        
        double roundedPct = Math.round(pct * 100.0) / 100.0;
        return new AttendanceResult(roundedPct, eligible, warning);
    }

    public static void main(String[] args) {
        App app = new App();
        AttendanceResult res = app.analyze(48, 60);
        System.out.println("Attendance: " + res.percentage + "% - " + res.status);
        System.out.println("Program finished");
    }
}