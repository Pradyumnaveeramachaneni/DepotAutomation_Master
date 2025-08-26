package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports createInstance() {
    	
    	String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("test-output/extent-report.html" + " " + timestamp);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Test Execution Report");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Tester", "Pradyumna");
        return extent;
    }
}
