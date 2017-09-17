package testClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import basicClass.BasicClassMethods;

public class RegisterationPage {
	
	public static WebDriver driver;
	//Initialization of WebElements
	@FindBy(linkText = "REGISTER")
	WebElement RegisterationLink;
	@FindBy(name = "firstName")
	WebElement FirstName;
	@FindBy(name = "lastName")
	WebElement LastName;
	@FindBy(name = "phone")
	WebElement PhoneNumber;
	@FindBy(id = "userName")
	WebElement Email;
	@FindBy(name = "address1")
	WebElement AddressLine1;
	@FindBy(name = "address2")
	WebElement AddressLine2;
	@FindBy(name = "city")
	WebElement City;
	@FindBy(name = "state")
	WebElement State;
	@FindBy(name = "postalCode")
	WebElement PostalCode;
	@FindBy(name = "country")
	WebElement Country;
	@FindBy(name = "email")
	WebElement UserName;
	@FindBy(name = "password")
	WebElement Password;
	@FindBy(name = "confirmPassword")
	WebElement ConfirmPassword;
	@FindBy(name = "register")
	WebElement Submit;
	
//PageFactory initialization is Mandate
	public RegisterationPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	public void ClickRegisteration()
	{
		BasicClassMethods.WaitExplicit(driver, 25, RegisterationLink);
		RegisterationLink.click();
	}
	public void ClickSubmit()
	{
		BasicClassMethods.WaitExplicit(driver, 25, Submit);
		Submit.click();
	}
	public void Set_UserName(String UserNameValue)
	{
		BasicClassMethods.WaitExplicit(driver, 25, UserName);
		UserName.sendKeys(UserNameValue);
	}
	public void ImplicitWait()
	{
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	}
	public void Set_Password(String PasswordValue)
	{
		BasicClassMethods.WaitExplicit(driver, 25, Password);
		Password.sendKeys(PasswordValue);
	}
	public void Set_ConfirmPassword(String ConfirmPasswordValue)
	{
		BasicClassMethods.WaitExplicit(driver, 25, ConfirmPassword);
		ConfirmPassword.sendKeys(ConfirmPasswordValue);
	}
	public void Set_FirstName(String FirstNameval)
	{
		BasicClassMethods.WaitExplicit(driver, 25, FirstName);
		FirstName.sendKeys(FirstNameval);
	}
	public void Set_LastName(String LastNameval)
	{
		BasicClassMethods.WaitExplicit(driver, 25, LastName);
		LastName.sendKeys(LastNameval);
	}
	public void Set_Phone(String Phoneval)
	{
		BasicClassMethods.WaitExplicit(driver, 25, PhoneNumber);
		PhoneNumber.sendKeys(Phoneval);
	}
	public void Set_Email(String Emailval)
	{
		BasicClassMethods.WaitExplicit(driver, 25, Email);
		Email.sendKeys(Emailval);
	}
	public void Set_Address1(String Address1val)
	{
		BasicClassMethods.WaitExplicit(driver, 25, AddressLine1);
		AddressLine1.sendKeys(Address1val);
	}
	public void Set_Address2(String Address2val)
	{
		BasicClassMethods.WaitExplicit(driver, 25, AddressLine2);
		AddressLine2.sendKeys(Address2val);
	}
	public void Set_City(String Cityvalue)
	{
		BasicClassMethods.WaitExplicit(driver, 25, City);
		City.sendKeys(Cityvalue);
	}
	public void Set_State(String Statevalue)
	{
		BasicClassMethods.WaitExplicit(driver, 25, State);
		State.sendKeys(Statevalue);
	}
	public void Set_PostalCode(String PostalCodeValue)
	{
		BasicClassMethods.WaitExplicit(driver, 25, PostalCode);
		PostalCode.sendKeys(PostalCodeValue);
	}
	public void Set_Country(String Countryvalues)
	{
		BasicClassMethods.WaitExplicit(driver, 25, Country);
		Select CountrySel = new Select(Country);
		CountrySel.selectByVisibleText(Countryvalues);
	}


}
