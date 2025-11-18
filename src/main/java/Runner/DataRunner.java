package Runner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.TestNG;
import org.testng.collections.Lists;

import Utilities.ExcelReadUtil;

public class DataRunner {
	public static Map<Integer, Map<String, String>>  newExecutionMap ;
		
	public static Map<String, String> newdatamap = new HashMap<String, String>();

	
	
	

	public static void main(String[] args) throws Exception {
		
		ExcelReadUtil excel = new ExcelReadUtil();
		
		newExecutionMap =	excel.readDatafromExcel();
		
		TestNG testng = new TestNG();
	
		List<String> suites  =Lists.newArrayList();
	
		suites.add("C:\\Users\\manis\\automation-New\\Framework_01\\testng.xml");
	
		testng.setTestSuites(suites);
	
		for (int i = 0; i < newExecutionMap.size(); i++)
		{
		newdatamap=	newExecutionMap.get(i);
		testng.run();
		}
	
	
	
	}
	
	

}
