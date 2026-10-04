package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utils.ExcelReportManager;
import utils.TestContext;

public class ExcelReportListener implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {

        ExcelReportManager.writeResult(

                TestContext.tcId.get(),

                TestContext.requestPayload.get(),

                TestContext.httpStatus.get(),

                TestContext.apiStatus.get(),

                TestContext.expectedResult.get(),

                TestContext.actualResult.get(),

                TestContext.responseBody.get(),

                "PASS",

                (result.getEndMillis()
                        - result.getStartMillis())
                        + " ms",

                "");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        String errorMessage = "";

        if (result.getThrowable() != null) {

            errorMessage =
                    result.getThrowable()
                            .getMessage();
        }

        ExcelReportManager.writeResult(

                TestContext.tcId.get(),

                TestContext.requestPayload.get(),

                TestContext.httpStatus.get(),

                TestContext.apiStatus.get(),

                TestContext.expectedResult.get(),

                TestContext.actualResult.get(),

                TestContext.responseBody.get(),

                "FAIL",

                (result.getEndMillis()
                        - result.getStartMillis())
                        + " ms",

                errorMessage);
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        ExcelReportManager.writeResult(

                TestContext.tcId.get(),

                TestContext.requestPayload.get(),

                TestContext.httpStatus.get(),

                TestContext.apiStatus.get(),

                TestContext.expectedResult.get(),

                TestContext.actualResult.get(),

                TestContext.responseBody.get(),

                "SKIPPED",

                (result.getEndMillis()
                        - result.getStartMillis())
                        + " ms",

                "Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {

        System.out.println(
                "========================================");

        System.out.println(
                "Excel Report Generation Started");

        ExcelReportManager.saveReport();

        System.out.println(
                "Excel Report Generation Completed");

        System.out.println(
                "Location : reports/ExecutionReport.xlsx");

        System.out.println(
                "========================================");
    }
}