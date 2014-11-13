import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
public class UploadMediaFile {
	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriver driver=new FirefoxDriver();
		//for chrome browser
		//System.setProperty("webdriver.chrome.driver", "chromedriver.exe path");
		//WebDriver driver=new ChromeDriver();
		driver.get("http://demo.rtcamp.com/rtmedia/");
		Thread.sleep(5000);
		Login.UserLogin(driver);
		uploadmedia(driver);
	}
	public static void uploadmedia(WebDriver driver) throws InterruptedException, AWTException
	{
		driver.get("http://demo.rtcamp.com/rtmedia/members/test-sel/media/");//link for media page 
		Thread.sleep(3000);
		driver.findElement(By.id("rtm_show_upload_ui")).click();//click on upload
		Thread.sleep(3000);
		Select album=new Select(driver.findElement(By.className("rtmedia-user-album-list")));//select album
		album.selectByVisibleText("Wall Posts");
		Thread.sleep(2000);
		Select privacy=new Select(driver.findElement(By.id("rtSelectPrivacy")));//select privacy for media 
		privacy.selectByVisibleText("Private");
		driver.findElement(By.id("rtMedia-upload-button")).click();//click on upload button
		Thread.sleep(5000);
		setClipboardData("C:\\Users\\Public\\Pictures\\Sample Pictures\\Koala.jpg");//path for image
		//native key strokes for CTRL, V and ENTER keys
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(1000);
		//wait for upload status
		new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOfElementLocated(By.className("plupload_file_status")));
		driver.findElement(By.id("rtmedia_upload_terms_conditions")).click();//accept terms and conditions
		driver.findElement(By.className("start-media-upload")).click();//click on upload media
		//wait until media is uploaded
		new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOfElementLocated(By.className("rtmedia-list-item")));
		System.out.println("File uploaded to media successfully");
	}
	public static void setClipboardData(String string) {
		   StringSelection stringSelection = new StringSelection(string);
		   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		}
}
