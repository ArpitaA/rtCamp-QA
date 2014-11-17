import java.awt.AWTException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
public class Register {
	@Test
	public static void Register_main() throws InterruptedException, AWTException {
		WebDriver driver=new FirefoxDriver();
		//for chrome browser
		//System.setProperty("webdriver.chrome.driver", "chromedriver.exe path");
		//WebDriver driver=new ChromeDriver();
		driver.get("http://demo.rtcamp.com/rtmedia/");
		Thread.sleep(5000);
		driver.findElement(By.linkText("Register")).click();//click on register tab
		Thread.sleep(3000);
		driver.findElement(By.id("rtAS_registration_username")).sendKeys("username");//enter username
		driver.findElement(By.id("rtAS_registration_email")).sendKeys("Email");//enter email id
		System.out.println("Usrename and email-id entered");
		((JavascriptExecutor)driver).executeScript("alert('Enter the words in image shown')");//alert to enter validation code
		Thread.sleep(5000);
		driver.switchTo().alert().accept();//alert accepted after 5sec
		System.out.println("Enter the words in image shown");
		Thread.sleep(5000);
		if(driver.findElement(By.id("recaptcha_response_field")).getText().isEmpty())
		{
			System.out.println("verification code was not entered by user");
		}
		else
		{
			driver.findElement(By.id("rtAS_registration_submit")).click();
			System.out.println("Clicked on register button");
		}
		driver.close();
	}
}
