package UtilFunctions;

import Tests.baseTest;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.net.URL;

public class readExcel {

    /*public readExcel()
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
    }*/

    public String[][] readFromExcel(String filePath)
    {
        String[][] excelData = null;
        try {
            File file = new File(filePath);

            FileInputStream readStream = new FileInputStream(file);

            XSSFWorkbook readWB = new XSSFWorkbook(readStream);

            XSSFSheet readSheet = readWB.getSheet("Output");
            XSSFRow row = readSheet.getRow(0);

            int rcount = readSheet.getLastRowNum() + 1;

            System.out.println(rcount);
            int ccount = row.getLastCellNum();
            System.out.println(ccount);

            excelData = new String[rcount][ccount];

            for(int i=1;i<rcount;i++)
            {
                for(int j=0; j<ccount;j++)
                {
                    excelData[i-1][j]=readSheet.getRow(i).getCell(j).getStringCellValue();

                }

            }

           /* for(int i=0;i< rcount;i++) {
                System.out.print(" | ");
                for (int j = 0; j < ccount; j++) {
                    System.out.print(excelData[i][j]);
                    System.out.print(" | ");
                }
                System.out.println();
            }*/

        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return excelData;

    }
}
