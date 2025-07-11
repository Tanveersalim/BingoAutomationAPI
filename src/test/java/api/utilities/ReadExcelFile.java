package api.utilities;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class ReadExcelFile {

    public static FileInputStream inputStream;
    public static XSSFWorkbook workBook;
    public static XSSFSheet excelSheet;

    public static String getCellValue(String fileName, String sheetName, int rowNo, int cellNo) {
        String value = "";
        try {
            inputStream = new FileInputStream(fileName);
            workBook = new XSSFWorkbook(inputStream);
            excelSheet = workBook.getSheet(sheetName);
            Cell cell = excelSheet.getRow(rowNo).getCell(cellNo);

            if (cell != null) {
                switch (cell.getCellType()) {
                    case STRING:
                        value = cell.getStringCellValue();
                        break;
                    case NUMERIC:
                        if (DateUtil.isCellDateFormatted(cell)) {
                            value = cell.getDateCellValue().toString();
                        } else {
                            value = String.valueOf(cell.getNumericCellValue());
                        }
                        break;
                    case BOOLEAN:
                        value = String.valueOf(cell.getBooleanCellValue());
                        break;
                    case FORMULA:
                        // Evaluate the formula result
                        FormulaEvaluator evaluator = workBook.getCreationHelper().createFormulaEvaluator();
                        CellValue cellValue = evaluator.evaluate(cell);
                        switch (cellValue.getCellType()) {
                            case STRING:
                                value = cellValue.getStringValue();
                                break;
                            case NUMERIC:
                                value = String.valueOf(cellValue.getNumberValue());
                                break;
                            case BOOLEAN:
                                value = String.valueOf(cellValue.getBooleanValue());
                                break;
                            default:
                                value = "";
                        }
                        break;
                    case BLANK:
                        value = "";
                        break;
                    default:
                        value = "";
                }
            }

            workBook.close();
        } catch (Exception e) {
            value = "";
        }
        return value;
    }

    public static int getRowCount(String fileName, String sheetName) {
        try {
            inputStream = new FileInputStream(fileName);
            workBook = new XSSFWorkbook(inputStream);
            excelSheet = workBook.getSheet(sheetName);
            int ttlRows = excelSheet.getLastRowNum() + 1;
            workBook.close();
            return ttlRows;
        } catch (Exception e) {
            return 0;
        }
    }

    public static int getColCount(String fileName, String sheetName) {
        try {
            inputStream = new FileInputStream(fileName);
            workBook = new XSSFWorkbook(inputStream);
            excelSheet = workBook.getSheet(sheetName);
            int ttlCells = excelSheet.getRow(0).getLastCellNum();
            workBook.close();
            return ttlCells;
        } catch (Exception e) {
            return 0;
        }
    }
}

