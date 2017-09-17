package basicClass;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import excelReadWrite.ExcelReadWrite;

public class BasicClassMethods {
	public static WebDriver driver;
	public WebDriver launch_Browser(String BrowserName,String BrowserURL)
	{
		if(BrowserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(BrowserURL);
		}
		else if(BrowserName.equalsIgnoreCase("IE"))
		{
			File file = new File( System.getProperty("user.dir")+"\\Driver\\IEDriverServer1.exe");
			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
			driver = new InternetExplorerDriver();
			driver.get(BrowserURL);
		}
		else if(BrowserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.firefox.marionette", System.getProperty("user.dir")+"\\Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get(BrowserURL);
		}
		return driver;
	}

	public String[][] ReadDataExcel(String ExcelName,String SheetName) throws IOException
	{
		String ExcelLocation = System.getProperty("user.dir")+"\\src\\dataExcel\\"+ExcelName;
		ExcelReadWrite Excel = new  ExcelReadWrite();
		return Excel.readData(ExcelLocation, SheetName);
		
	}
	public static  WebElement WaitExplicit(WebDriver driver,long Time,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Time);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
}


