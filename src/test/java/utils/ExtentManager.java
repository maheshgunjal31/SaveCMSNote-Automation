package utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if(extent == null) {

            extent = new ExtentReports();

            ExtentSparkReporter reporter =
               new ExtentSparkReporter(
                       "reports/APIReport.html");

            extent.attachReporter(reporter);
        }

        return extent;
    }
}