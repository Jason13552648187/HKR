package cn.com.hkr.utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

/**
 * @author jason
 * @date 2022/4/15-15:28
 */
public class ExcelHnadler {

    public static void main(String[] args) throws IOException {

        readExcel();

    }


    public static void readExcel() throws IOException {
        File file = new File("C:\\Users\\jason\\Downloads\\入场名单.xlsx");
        File outputFile = new File("C:\\Users\\jason\\Downloads\\入场名单.txt");
        FileOutputStream outputStream=  new FileOutputStream(outputFile);
        XSSFWorkbook wk = new XSSFWorkbook(new FileInputStream(file));

        Sheet sheet = wk.getSheetAt(1);

        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()){
            Row row = rowIterator.next();
            for(int r = 0;r <= 8;r++){
                outputStream.write((row.getCell(r) == null?"  ":row.getCell(r).toString() + "  ").getBytes(StandardCharsets.UTF_8));
            }
            outputStream.write("\n".getBytes(StandardCharsets.UTF_8));
        }
        outputStream.flush();
        outputStream.close();
        wk.close();

    }


}
