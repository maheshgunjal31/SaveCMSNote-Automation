package utils;

import java.io.File;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReportManager {

    private static Workbook workbook;
    private static Sheet sheet;
    private static int rowNum = 1;

    static {

        workbook = new XSSFWorkbook();

        sheet =
                workbook.createSheet(
                        "Execution Report");

        Row header =
                sheet.createRow(0);

        header.createCell(0)
                .setCellValue("TC ID");

        header.createCell(1)
                .setCellValue("Request Payload");

        header.createCell(2)
                .setCellValue("HTTP Status");

        header.createCell(3)
                .setCellValue("API Status");

        header.createCell(4)
                .setCellValue("Expected Result");

        header.createCell(5)
                .setCellValue("Actual Result");

        header.createCell(6)
                .setCellValue("PASS/FAIL");

        header.createCell(7)
                .setCellValue("Execution Time");

        header.createCell(8)
                .setCellValue("Error Message");
    }

    public static void writeResult(

            String tcId,
            String requestPayload,
            String httpStatus,
            String apiStatus,
            String expectedResult,
            String actualResult,
            String responseBody,
            String passFail,
            String executionTime,
            String errorMessage) {

        Row row =
                sheet.createRow(rowNum++);

        row.createCell(0)
                .setCellValue(tcId);

        row.createCell(1)
                .setCellValue(requestPayload);

        row.createCell(2)
                .setCellValue(httpStatus);

        row.createCell(3)
                .setCellValue(apiStatus);

        row.createCell(4)
                .setCellValue(expectedResult);

        row.createCell(5)
                .setCellValue(actualResult);

        row.createCell(6)
                .setCellValue(responseBody);

        Cell statusCell =
                row.createCell(7);

        statusCell.setCellValue(passFail);

        CellStyle passStyle =
                workbook.createCellStyle();

        passStyle.setFillForegroundColor(
                IndexedColors.LIGHT_GREEN.getIndex());

        passStyle.setFillPattern(
                FillPatternType.SOLID_FOREGROUND);

        CellStyle failStyle =
                workbook.createCellStyle();

        failStyle.setFillForegroundColor(
                IndexedColors.RED.getIndex());

        failStyle.setFillPattern(
                FillPatternType.SOLID_FOREGROUND);

        if ("PASS".equalsIgnoreCase(passFail)) {

            statusCell.setCellStyle(
                    passStyle);

        } else {

            statusCell.setCellStyle(
                    failStyle);
        }

        row.createCell(8)
                .setCellValue(executionTime);

        row.createCell(9)
                .setCellValue(errorMessage);
    }

    public static void saveReport() {

        try {

            File reportDir =
                    new File("reports");

            if (!reportDir.exists()) {

                reportDir.mkdirs();
            }

            for (int i = 0; i <= 9; i++) {

                sheet.autoSizeColumn(i);
            }

            FileOutputStream fos =
                    new FileOutputStream(
                            "reports/ExecutionReport.xlsx");

            workbook.write(fos);

            fos.close();

            workbook.close();

            System.out.println(
                    "Excel Report Generated Successfully");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}