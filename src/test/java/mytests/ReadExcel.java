package mytests;
import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
public class ReadExcel {
    @Test

    public void readExcelTest(){
//        workbook > worksheet > row > cell
//        Store the path of the  file in a string
        String path = "resources/Capitals.xlsx";
//        Open the file
        try {
//        Open the workbook using fileinputstream
            FileInputStream fileInputStream = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(fileInputStream);
//        Open the first worksheet
            Sheet sheet1 = workbook.getSheetAt(0);//get first sheet by index. index starts at 0
//            workbook.getSheet("Sheet1");//get first sheet by name
//        Go to first row
            Row row1 = sheet1.getRow(0);//index stars at 0
//        Go to first cell on that first row and print
            Cell r1c1 = row1.getCell(0);//index starts at 0
            System.out.println(r1c1);
//        Go to second cell on that first row and print
//            Cell r1c2 = row1.getCell(1);
            String r1c2 = row1.getCell(1).toString();
            System.out.println(r1c2);
            Assertions.assertTrue(r1c2.equals("CAPITAL"));
//        Go to 2nd row first cell  and assert if the data equal to USA
            String r2c1 = sheet1.getRow(1).getCell(0).toString();
            System.out.println(r2c1);
//        Go to 3rd row 2nd cell-chain the row and cell
            String r3c2 = sheet1.getRow(2).getCell(1).toString();
            System.out.println(r3c2);
//        Find the number of row
            int totalRowNum = sheet1.getLastRowNum()+1;//index starts at 0
            System.out.println(totalRowNum);
//        Find the number of used row
            int totalUsedRowNum = sheet1.getPhysicalNumberOfRows();//index starts at 1
            System.out.println(totalUsedRowNum);
      /*
       HOMEWORK : Print country, capitol key value pairs as map object()
        create a map
        then use a loop to add key value pains in the map
        use the pattern of indexes
        String countries = sheet1.getRow(row number).getCell(0).toString
        String capitals = sheet1.getRow(row number).getCell(1).toString
        add this to the map
        then print
        {greece = athens, Canada= Ottowa,...}
         */

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}