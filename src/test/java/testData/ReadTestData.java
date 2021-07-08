package testData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import bsh.ParseException;

public class ReadTestData {

public static String Test_DataSheet_Path =	"src/test/resources/testData.xlsx";

public static String PropertyFilePath = "src/test/resources/testConfig.properties" ;

public static String JasonTestDataPath = "src/test/resources/TestData.json";

private Properties	prop;
private static String url;

public static String configFileReader() throws IOException {

   // BufferedReader reader = new BufferedReader(new FileReader(PropertyFilePath));
    Properties prop = new Properties();
    FileInputStream ip= new FileInputStream(PropertyFilePath);
     prop.load(ip);
     url = prop.getProperty("url");
     System.out.println(url);
  //   reader.close();
     String url = prop.getProperty("url");
	 if(url != null) return url;
	 else throw new RuntimeException("url not specified in the Configuration.properties file.");
}

     public String getApplicationUrl()
     {
	 String url = prop.getProperty("url");
	 if(url != null) return url;
	 else throw new RuntimeException("url not specified in the Configuration.properties file.");
	 }

     //#############################################Read Excel sheet data#########################################
     
		public static Object[][] getExcelData(String SheetName) throws IOException
		{
		
		
		File file= new File(Test_DataSheet_Path);
		
		FileInputStream f=new FileInputStream(file);
		
		XSSFWorkbook wb= new XSSFWorkbook(f);
		
		XSSFSheet sheet=wb.getSheet(SheetName);
		
		
		System.out.println(sheet.getLastRowNum());
		System.out.println(sheet.getRow(0).getLastCellNum());
		
	Object [][] data	=new Object  [sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
	for(int i=0;i<sheet.getLastRowNum();i++) //row
	{
		for(int k=0;k<sheet.getRow(0).getLastCellNum();k++)//col
		{
			data[i][k]=sheet.getRow(i+1).getCell(k).toString();
		}
	}
	return data;
		}
		


//****************************************************Read Jason************************************************************************
public static void readWriteJSON() throws InterruptedException, IOException, ParseException, org.json.simple.parser.ParseException {
JSONParser jsonParser = new JSONParser();
FileReader reader = new FileReader(JasonTestDataPath);
//Read JSON file
Object obj = jsonParser.parse(reader);

JSONArray usersList = (JSONArray) obj;
System.out.println(usersList); //This prints the entire json file

for(int i=0;i<usersList.size();i++) 
{
JSONObject users = (JSONObject) usersList.get(i);
System.out.println(users);//This prints every block - one json object
JSONObject user = (JSONObject) users.get("users");
System.out.println(user); //This prints each data in the block

String url = (String) user.get("url");
String username = (String) user.get("username");
String password = (String) user.get("password1");
System.out.println("The url in JSON is -> "+url);
System.out.println("The username in JSON is -> "+username);
System.out.println("The password in JSON is -> "+password);

}

}
}
