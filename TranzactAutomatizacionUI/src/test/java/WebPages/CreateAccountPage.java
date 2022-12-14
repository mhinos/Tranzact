package WebPages;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage {

	protected WebDriver driver;

	public CreateAccountPage(WebDriver driver){
		this.driver = driver;
	}
	 
	private By FirstName = By.id("customer_firstname");
	private By LastName = By.id("customer_lastname");
	private By Password = By.id("passwd");
	private By Address = By.id("address1");
	private By City =By.id("city"); 
	private By PostCode = By.id("postcode");
	private By PhoneNumber = By.id("phone");
	private By RegisterButton = By.id("submitAccount");
	
	public String enterFirstName() {
		//Fill email address
		String name = RandomStringUtils.randomAlphabetic(6); 
		driver.findElement(FirstName).sendKeys(name);
		return name;
	}

	
	public String enterLastName() {
		//Input Last name
		String lastName = RandomStringUtils.randomAlphabetic(6); 
		driver.findElement(LastName).sendKeys(lastName);
		return lastName;
	}
	public void selectState() {
		//Select State - Arizona
		WebElement state = driver.findElement(By.id("id_state"));
		Select selectObject = new Select(state);
		selectObject.selectByVisibleText("Arizona");
	}
	public void enterPassword() {
		//Input Password
		String password = RandomStringUtils.randomAlphanumeric(8);
		driver.findElement(Password).sendKeys(password);
	}
	public void enterAddress() {
		//Input Address
		String addressText = RandomStringUtils.randomAlphanumeric(9);
		String addressNumber = RandomStringUtils.randomNumeric(3);
		driver.findElement(Address).sendKeys(addressText + ' ' + addressNumber);
	}
	public void enterCity() {
		//Input City
		String city = RandomStringUtils.randomAlphabetic(7); 
		driver.findElement(City).sendKeys(city);
		
	}
	public void enterPostCode() {
		//Input PostCode
		String postCode = RandomStringUtils.randomNumeric(5);
		driver.findElement(PostCode).sendKeys(postCode);
		
	}
	public void enterPhoneNumber() {
		//Input PhoneNumber
		String phoneNumber = RandomStringUtils.randomNumeric(9);
		driver.findElement(PhoneNumber).sendKeys(phoneNumber);
	}
	public void clickRegisterButton() {
		//Click *Register* button
		driver.findElement(RegisterButton).click();
	}	
}
