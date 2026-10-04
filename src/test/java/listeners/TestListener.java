package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.FileWriter;
import java.io.PrintWriter;

public class TestListener
        implements ITestListener {

    @Override
    public void onTestFailure(
            ITestResult result) {

        try {

            PrintWriter writer =
                    new PrintWriter(
                            new FileWriter(
                                    "logs/failed-tests.log",
                                    true));

            writer.println(
                    "FAILED : "
                            + result.getName());

            if(result.getThrowable() != null) {

                writer.println(
                        result.getThrowable()
                                .getMessage());
            }

            writer.println(
                    "================================================");

            writer.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}