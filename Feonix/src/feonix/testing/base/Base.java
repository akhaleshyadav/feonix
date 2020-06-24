package feonix.testing.base;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.automationtesting.excelreport.Xl;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Base {
	public ChromeDriver driver;
	public Properties pr;
	@BeforeMethod
	public void BrowserLaunch() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","D:\\Tools\\CompleteSeleniumSetUp_win64bit\\ChromeDrivers\\83\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://stg.feonixride.aarp.org/");
		
		driver.wait(5000);
		String st=driver.getTitle();
		System.out.println("Browser title:-"+st);
		System.out.println("browser launched");
		
	}
	@AfterMethod
	public void BrowserClose()
	{
		
		driver.close();
	}
	 @DataProvider
     public Object[][] LoginData() throws BiffException, IOException
     {
   	 File f=new File("D:\\SeleniumProjects\\feonix\\feonix_LoginInputData.xls");
   	Workbook wk=Workbook.getWorkbook(f);
   	Sheet st=wk.getSheet("Login");
   	int Row=st.getRows();
   	int Col=st.getColumns();
   	System.out.println("rows & Columns "+Row +" "+Col);
   	Object[][] ob =new Object[Row][Col];
   	for ( int i=0; i<Row; i++)
   	{
   		for (int j=0; j<Col; j++)
   		{
   			Cell C1= st.getCell(j,i);
   			ob[i][j]=C1.getContents();
   		    					
   		}
   	}
   	return ob;
     }
     @AfterSuite
     public void ExcelReport() throws Exception
     {
   	Xl.generateReport("../TestReport1.xlsx");  
     } 
}
