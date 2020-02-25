package UtilFunctions;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class writeToExcel {

    public writeToExcel()
    {
        ClassLoader classloader =
                org.apache.poi.poifs.filesystem.POIFSFileSystem.class.getClassLoader();
        URL res = classloader.getResource(
                "org/apache/poi/poifs/filesystem/POIFSFileSystem.class");
        String path = res.getPath();
        System.out.println("POI Core came from " + path);

        classloader = org.apache.poi.ooxml.POIXMLDocument.class.getClassLoader();
        res = classloader.getResource("org/apache/poi/POIXMLDocument.class");
        path = res.getPath();
        System.out.println("POI OOXML came from " + path);

        classloader = org.apache.poi.hslf.usermodel.HSLFSlideShow.class.getClassLoader();
        res = classloader.getResource("org/apache/poi/hslf/usermodel/HSLFSlideShow.class");
        path = res.getPath();
        System.out.println("POI Scratchpad came from " + path);

    }

    public static void writeExcel(String filePath, String fileName, String sheetName, List<WebElement> dataToWrite) throws IOException{
        //create an object of File Class to open xlsx file
        File file = new File(filePath+"\\"+fileName);

        //Create an object of FileInputStream class to read excel File
        FileInputStream inputStream = new FileInputStream(file);

        XSSFWorkbook wb = new XSSFWorkbook(inputStream);

        //find the file extension by splitting file name in substring and getting only extension name

        //Read excel sheet by sheet name
        XSSFSheet sheet = wb.getSheet(sheetName);

        //Get the Current COunt of rows in excel file
        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

        //Row row = sheet.getRow(0);

        sheet.createRow(rowCount).createCell(0).setCellValue("Menu");

        for(WebElement e : dataToWrite)
        {
            rowCount++;
            sheet.createRow(rowCount).createCell(0).setCellValue(e.getText());
        }

        inputStream.close();

        FileOutputStream outputStream = new FileOutputStream(file);

        wb.write(outputStream);

        outputStream.close();
    }

}
