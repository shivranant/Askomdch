package utils_Layer;


import Base_layer.Base_Class;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileReader_Utils extends Base_Class {

    private static final String EXCEL_FILE_PATH = "src/test/resources/testdata.xlsx";
    private static final String PROPERTIES_FILE_PATH = "src/test/resources/config.properties";

    public static String getPropertyValue(String key) {
        String value = null;
        try (FileInputStream fis = new FileInputStream(PROPERTIES_FILE_PATH)) {
            Properties prop = new Properties();
            prop.load(fis);
            value = prop.getProperty(key);
        } catch (IOException e) {
            System.out.println("Error reading properties file: " + e.getMessage());
        }
        return value;
    }

    public static String getExcelData(String sheetName, int rowNum, int colNum) {
        String data = null;
        try (FileInputStream fis = new FileInputStream(EXCEL_FILE_PATH);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            Row row = sheet.getRow(rowNum);
            Cell cell = row.getCell(colNum);
            DataFormatter formatter = new DataFormatter();
            data = formatter.formatCellValue(cell);

        } catch (IOException e) {
            System.out.println("Error reading Excel file: " + e.getMessage());
        }
        return data;
    }

    public static int getRowCount(String sheetName) {
        int rowCount = 0;
        try (FileInputStream fis = new FileInputStream(EXCEL_FILE_PATH);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            rowCount = sheet.getPhysicalNumberOfRows();

        } catch (IOException e) {
            System.out.println("Error getting row count: " + e.getMessage());
        }
        return rowCount;
    }

    public static int getColumnCount(String sheetName, int rowIndex) {
        int colCount = 0;
        try (FileInputStream fis = new FileInputStream(EXCEL_FILE_PATH);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            Row row = sheet.getRow(rowIndex);
            colCount = row.getPhysicalNumberOfCells();

        } catch (IOException e) {
            System.out.println("Error getting column count: " + e.getMessage());
        }
        return colCount;
    }
}
