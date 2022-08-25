package WebPages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {
	protected WebDriver driver;

	public MyAccountPage(WebDriver driver){
    this.driver = driver;
    }

	private By HeaderUserInfo = By.xpath("//div[contains(@class, 'header_user_info')]/a/span");
	private By LogOutDiv = By.xpath("//div[contains(@class, 'header_user_info')]/a/span");
	
	
	public void verifyTitle(String ActualTitle) {
		//Assert Title Page
		String ExpectedTitle = "My account - My Store";
		Assert.assertEquals(ActualTitle,ExpectedTitle);  
	}
	public void verifyUserName(String name, String lastname) {
		//Assert User Name
		String UserName = name + " " + lastname;
		String temporal = driver.findElement(HeaderUserInfo).getText();
		Assert.assertEquals(UserName,temporal); 
	}
	public void verifyLogOut() {
		//Assert Logout
		String LogOut = driver.findElement(LogOutDiv).getText();
		Assert.assertEquals("Sign out",LogOut);
	}
}
