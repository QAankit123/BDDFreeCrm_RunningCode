package StepDefination;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefination {

	ChromeDriver driver;
	
	@Given("^User is on Login Page$")
	public void User_is_on_LoginPage() 
	{	
		System.setProperty("webdriver.chrome.driver", "E:\\Ss\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.crmpro.com/index.html");
	}
//	@When("^title of login page is CRMPRO$") 
//	public void Validate_Title_Of_page()
//	{
//		String title=driver.getCurrentUrl();
//		Assert.assertEquals("https://www.crmpro.com/index.html", title);	
//		System.out.println(title);
//	}
	
	@Then("^User Enter Username and Password$")
	public void User_Enter_Credentials() 
	{	
     driver.findElementByXPath("//input[@name='username']").sendKeys("ankitsrv");
	 driver.findElementByXPath("//input[@name='password']").sendKeys("admin@123");	
	}
	@And("^user clicks on Login Button$")
	public void User_click_Login() 
	{	
     WebElement loginbtn=driver.findElementByXPath("//input[@type='submit']");
     JavascriptExecutor js = (JavascriptExecutor)driver;
     js.executeScript("arguments[0].click();", loginbtn);
	}
	@And("^User is on home page$")
	public void User_is_On_home_page() 
	{
	
	WebDriverWait wait = new WebDriverWait(driver,10);
    WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='logo_text']")));
	boolean status=element.isDisplayed();
	
       if(status)
       {
    	   System.out.println("User Login in to the system");
       }
       else{
    	   System.out.println("User is not login");
       }
	}
	
	
	
}
