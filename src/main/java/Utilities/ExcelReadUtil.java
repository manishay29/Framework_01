package Utilities;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadUtil {
	public List<String> scriptnameList;
	public List<String> stepKeywordList;
	public Map<String, List<String>> data;
	public List<String> DataHeader;
	public Map<Integer, Map<String, String>> executionmap;
	public Map<String, String> Datamap;
	public List<String> flagdata;
	
	
	Commonmethods CM = new Commonmethods();
	FileInputStream fis;

	public Map<String, List<String>> readStepKeyword(String sheetname) throws Exception {
		Commonmethods CM = new Commonmethods();

		Properties Dataprop = CM.readConfig("C:\\Users\\manis\\automation-New\\Framework_01\\src\\test\\java\\DataFiles\\config.properties");

		String datafilepath = Dataprop.getProperty("DatafilePath");

		fis = new FileInputStream(datafilepath);

		XSSFWorkbook book = new XSSFWorkbook(fis);

		Sheet Sheet = book.getSheet(sheetname);

		int rowcount = Sheet.getLastRowNum();

		int colCount = Sheet.getRow(0).getLastCellNum();

		scriptnameList = new ArrayList<>();
		stepKeywordList = new ArrayList<>();

		data = new LinkedHashMap<String, List<String>>();

		// loop for read data from excel

		for (int i = 0; i < colCount; i++) {
			String cellkey = "";
			String cellvalue = "";
			for (int j = 0; j < rowcount; j++) {

				cellkey = Sheet.getRow(0).getCell(i).getStringCellValue();
				cellvalue = Sheet.getRow(j + 1).getCell(i).getStringCellValue();

				if (cellkey.equalsIgnoreCase("AutomationScriptName")) {
					scriptnameList.add(cellvalue);
				} else if (cellkey.equalsIgnoreCase("StepKeyword")) {
					stepKeywordList.add(cellvalue);
				}

				if (cellkey.equalsIgnoreCase("AutomationScriptName")) {
					data.put(cellkey, scriptnameList);
				}

				else if (cellkey.equalsIgnoreCase("StepKeyword")) {
					data.put(cellkey, stepKeywordList);
				}

			}

		}

		return data;

	}

	public void ReadDatasheet() throws Exception {
		Properties dataprop = CM.readConfig("C:\\Users\\manis\\automation-New\\Framework_01\\src\\test\\java\\DataFiles\\config.properties");
		String datafilepath = dataprop.getProperty("DatafilePath");
		//String datafilepath = "C:\\Users\\manis\\Documents\\OrangeHRMData.xlsx";
		fis = new FileInputStream(datafilepath);

		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		Sheet Sheet = workbook.getSheet("Datasheet");
		
		int rows = Sheet.getLastRowNum();
		int cols = Sheet.getRow(0).getLastCellNum();

		DataHeader = new ArrayList<String>();

		for (int j = 0; j < cols; j++) {

			String header = Sheet.getRow(0).getCell(j).getStringCellValue();
			DataHeader.add(header);

		}

		System.out.println(DataHeader);

	}
	
	public Map<Integer, Map<String, String>> readDatafromExcel() throws Exception {
		Properties dataprop = CM.readConfig("C:\\Users\\manis\\automation-New\\Framework_01\\src\\test\\java\\DataFiles\\config.properties");
		String datafilepath = dataprop.getProperty("DatafilePath");
		fis = new FileInputStream(datafilepath);

		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		Sheet Sheet = workbook.getSheet("Datasheet");
		
		int rows = Sheet.getLastRowNum();
		int cols = Sheet.getRow(0).getLastCellNum();
		
		flagdata =new ArrayList<String>();
		
		
		
		for (int i = 0; i < rows; i++) {
			
			 for (int j = 0; j < cols; j++) {
				 
			String Flagvalue =	 Sheet.getRow(i).getCell(j).getStringCellValue(); 
				 
				 if (Flagvalue.equalsIgnoreCase("Execuationflag")) // when j loop is on col no 4 executionflag
				 {
					for (int k = 1; k <=rows; k++) {
						
						flagdata.add(Sheet.getRow(k).getCell(j).getStringCellValue()); // it will save YES /NO/YES from execution col
						
					}
					 
					 
				 }
				 
				 
				
			}
			
		}
		
		
		
		 System.out.println(flagdata);
		 
		 executionmap= new HashMap<Integer, Map<String,String>>();
		 
		 int datacount=0;
		 for (int i = 0; i <flagdata.size(); i++)
		 
		 {
			 Datamap= new HashMap<String, String>();
			 
			for (int j = 0; j < cols ; j++) {
				
				if (flagdata.get(i).equalsIgnoreCase("YES")) {
					
					String key= Sheet.getRow(0).getCell(j).getStringCellValue();
					String Value = Sheet.getRow(i+1).getCell(j).getStringCellValue();
					Datamap.put(key, Value);
				}
				
			}
				if (Datamap != null && !Datamap.isEmpty() ) {
					
					executionmap.put(datacount, Datamap);
					datacount++;
				} 
			
				
			
			
		  }
		
		 System.out.println(executionmap);
		 return executionmap;
		
		
		
		
	}
	

	public static void main(String[] args) throws Exception {
		ExcelReadUtil excel = new ExcelReadUtil();
		excel.ReadDatasheet();
		excel.readDatafromExcel();
		
		
		
	}

}
