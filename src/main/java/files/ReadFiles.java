package files;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadFiles {

	
	public String readexcel(String path, String Sheetname, int rows, int columns ) throws EncryptedDocumentException, IOException
	{
		FileInputStream FIS = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(FIS);
		Sheet sheet = wb.getSheet(Sheetname);
		Row row = sheet.getRow(rows);
		Cell cel = row.getCell(columns);
		DataFormatter df = new DataFormatter();
		String cell = df.formatCellValue(cel);
		FIS.close();
		wb.close();
		return cell;
	}
	public String config(String Path, String key) throws IOException
	{ 
		FileInputStream FIS = new FileInputStream(Path);
		Properties prop = new Properties();
		prop.load(FIS);
		String value = prop.getProperty(key);
		return value;
	}
	public String writeExcel(String path, String sheetname, int row, int column, String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream FIS = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(FIS);
		Sheet sheet = wb.getSheet(sheetname);
		Row row1 = sheet.getRow(row);
		Cell cell = row1.getCell(column);
		cell.setCellValue(data);

		FileOutputStream fos = new FileOutputStream(path);
		wb.write(fos);
	    FIS.close();
		fos.close();
		wb.close();
		return data;
	}

	public int getlastrow(String path, String sheetname, int row) throws EncryptedDocumentException, IOException
    {
        FileInputStream FIS = new FileInputStream(path);
        Workbook wb = WorkbookFactory.create(FIS);
        Sheet sheet = wb.getSheet(sheetname);
        return sheet.getLastRowNum();
    }
	
	public int getlastcell(String path, String sheetname, int cell) throws EncryptedDocumentException, IOException
    {
        FileInputStream FIS = new FileInputStream(path);
        Workbook wb = WorkbookFactory.create(FIS);
        Sheet sheet = wb.getSheet(sheetname);
        Row cells = sheet.getRow(cell);
        return cells.getLastCellNum(); 
    }
}
