package testClass;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import basicClass.BasicClassMethods;
public class DataDriverTest {
	public static WebDriver driver;
	public BasicClassMethods Basic = new BasicClassMethods();
@DataProvider
public Object[][] getData() throws IOException
{
	return Basic.ReadDataExcel("DataDriven.xlsx", "Registeration");
}
@BeforeTest
public void  BeforeTest()
{
	driver = Basic.launch_Browser("chrome", "http://newtours.demoaut.com/");
}
@Test(dataProvider = "getData")
public void Resgisterationtest(String FirstName,String LastName,String Phone,String Email,String Address1,String Address2,String City,String Province,String PostalCode,String Country,String UserName,String Password,String ConfirmPassword)
{
	
	RegisterationPage Reg = new RegisterationPage(driver);
	Reg.ClickRegisteration();
	Reg.Set_FirstName(FirstName);
	Reg.Set_LastName(LastName);
	Reg.Set_Phone(Phone);
	Reg.Set_Email(Email);
	Reg.Set_Address1(Address1);
	Reg.Set_Address2(Address2);
	Reg.Set_City(City);
	Reg.Set_State(Province);
	Reg.Set_PostalCode(PostalCode);
	Reg.Set_Country(Country);
	Reg.Set_UserName(UserName);
	Reg.Set_Password(Password);
	Reg.Set_ConfirmPassword(ConfirmPassword);
	Reg.ClickSubmit();
	Reg.ImplicitWait();
	String Expected = "sign-in";
	String ActualValues = driver.findElement(By.partialLinkText("sign-in")).getText();
	Assert.assertEquals(ActualValues, Expected);
}
@AfterTest
public void  AfterTest()
{
	driver.close();
}
}
