package Main;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import WebPages.CreateAccountPage;
import WebPages.HomePage;
import WebPages.SignInPage;
import WebPages.MyAccountPage;

import org.openqa.selenium.support.ui.ExpectedConditions;
public class Main {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/mfhv/Documents/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		//Open Home Page
		driver.get("http://automationpractice.com/");
		//Maximizar pantalla
		driver.manage().window().maximize();
		
		//WebDriverWait wait = new WebDriverWait(driver,30);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Creating object of Home page
		HomePage home = new HomePage(driver);
		home.clickSignInButton();
		//Creating object of SignInPage
		SignInPage signIn = new SignInPage(driver);
		signIn.enterEmailAddress();
		signIn.clickSubmitButton();
		//Creating object of CreateAccount page
		CreateAccountPage createAccount = new CreateAccountPage(driver);
		
		//Fill all fields with correct data
		//Thread.sleep(4000);
		wait.until(ExpectedConditions.presenceOfElementLocated (By.xpath("//input[contains(@id, 'customer_firstname')]")));
		String Name = createAccount.enterFirstName();
		String LastName = createAccount.enterLastName();
		Thread.sleep(2000);
		//wait.until(ExpectedConditions.presenceOfElementLocated (By.id("id_state")));
		createAccount.selectState();
		createAccount.enterPassword();
		createAccount.enterAddress();
		createAccount.enterCity();
		createAccount.enterPostCode();
		createAccount.enterPhoneNumber();
		createAccount.clickRegisterButton();
		
		//Creating object of MyAccount page
		MyAccountPage myAccount = new MyAccountPage(driver);
		String ActualTitle = driver.getTitle();
		myAccount.verifyTitle(ActualTitle);
		myAccount.verifyUserName(Name, LastName);
		System.out.println("Script termino satisfactoriamente ");
		driver.quit();
	}
}
