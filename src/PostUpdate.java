import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import org.testng.annotations.Test;

public class PostUpdate {
	@Test
	public static void PostUpdate_main() throws InterruptedException, AWTException {
		WebDriver driver=new FirefoxDriver();
		//for chrome browser
	    // System.setProperty("webdriver.chrome.driver", "chromedriver.exe path");
		//WebDriver driver=new ChromeDriver();
		driver.get("http://demo.rtcamp.com/rtmedia/");
		Thread.sleep(5000);
		Login.UserLogin(driver);
		PostUpdatePublic(driver);
		driver.close();
	}
	
	public static void PostUpdatePublic(WebDriver driver) throws InterruptedException, AWTException
	{
	driver.findElement(By.cssSelector(".rtmedia-add-media-button")).click();//click add media button
	Thread.sleep(5000);
	setClipboardData("C:\\Users\\Public\\Pictures\\Sample Pictures\\Koala.jpg");//image path
	//native key strokes for CTRL, V and ENTER keys
	Robot robot = new Robot();
	robot.keyPress(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_V);
	robot.keyRelease(KeyEvent.VK_V);
	robot.keyRelease(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);
	robot.delay(1000);
	//wait for file to be uploaded 
	new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(By.id("rtm-upload-start-notice")));
	System.out.println("File uploaded successfully");
	driver.findElement(By.id("whats-new")).sendKeys("Test");//post text
	driver.findElement(By.id("aw-whats-new-submit")).click();//click on submit
	//Wait for post updated successfully
	new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.just-posted")));
	System.out.println("post updated successfully");
	}
	public static void setClipboardData(String string) {
		   StringSelection stringSelection = new StringSelection(string);
		   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		}
}
