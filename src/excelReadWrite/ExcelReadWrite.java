package excelReadWrite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadWrite {
	
	public String[][] readData(String ExcelLOcation,String SheetName) throws IOException
	{
		String data[][] = null;
		FileInputStream file = new FileInputStream(new File(ExcelLOcation));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet Sheet1 = workbook.getSheet(SheetName);
		int lastRowNo = Sheet1.getLastRowNum()+1;
		int LastColumnNo = Sheet1.getRow(0).getLastCellNum();
		data = new String [lastRowNo-1][LastColumnNo];
		Iterator<Row> rowIerator = Sheet1.iterator();
			int k =0;
			int l =0;
			while(rowIerator.hasNext())
			{
				Row row = rowIerator.next();
					if(k++!=0)
					{
						int n = l;
						l++;
							Iterator<Cell> cellIterator = row.cellIterator();
								int m=0;
								 while(cellIterator.hasNext())
								 {
									 Cell cell = cellIterator.next();
									 	switch(cell.getCellType())
									 	{
									 	case Cell.CELL_TYPE_NUMERIC:
									 		
									 		data[n][m++]=cell.getStringCellValue();
									 		
									 		break;
									 	case Cell.CELL_TYPE_STRING:
									 		
									 		data[n][m++]=cell.getStringCellValue();
									 		
									 		break;
									 	case Cell.CELL_TYPE_BOOLEAN:
									 		
									 		data[n][m++]=cell.getStringCellValue();
									 		
									 		break;
									 	case Cell.CELL_TYPE_FORMULA:
									 		
									 		data[n][m++]=cell.getStringCellValue();
									 		
									 		break;
									 		}
								 }
								 System.out.println(" ");
					}
			}
			
	file.close();
	return data;
	
	}

}
