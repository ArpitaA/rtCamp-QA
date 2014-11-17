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
import org.testng.annotations.Test;
public class UploadMediaFile {
	@Test
	public static void UploadMediaFile_main() throws InterruptedException, AWTException {
		WebDriver driver=new FirefoxDriver();
		//for chrome browser
		//System.setProperty("webdriver.chrome.driver", "chromedriver.exe path");
		//WebDriver driver=new ChromeDriver();
		driver.get("http://demo.rtcamp.com/rtmedia/");
		Thread.sleep(5000);
		Login.UserLogin(driver);
		uploadmedia(driver);
		driver.close();
	}
	public static void uploadmedia(WebDriver driver) throws InterruptedException, AWTException
	{
		//driver.get("http://demo.rtcamp.com/rtmedia/members/test-sel/media/");
		driver.findElement(By.className("rtp-user-name")).click();//click on username
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a.activity[title='Activity']")).click();//click on activity
		Thread.sleep(5000);
		driver.findElement(By.id("media-personal-li")).click();//click on media
		Thread.sleep(5000);
		driver.findElement(By.id("rtm_show_upload_ui")).click();//click on upload button
		Thread.sleep(3000);
		Select album=new Select(driver.findElement(By.className("rtmedia-user-album-list")));
		album.selectByVisibleText("Wall Posts");//select album 
		Thread.sleep(2000);
		Select privacy=new Select(driver.findElement(By.id("rtSelectPrivacy")));
		privacy.selectByVisibleText("Private");//select privacy
		driver.findElement(By.id("rtMedia-upload-button")).click();//click on upload button
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
		//wait until file is uploaded
		new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOfElementLocated(By.className("plupload_file_status")));
		driver.findElement(By.id("rtmedia_upload_terms_conditions")).click();//accept terms and conditions
		driver.findElement(By.className("start-media-upload")).click();//click to start uploading
		//wait until media in uploaded
		new WebDriverWait(driver,60).until(ExpectedConditions.textToBePresentInElement(By.className("plupload_file_status"), "Uploaded"));
		System.out.println("File uploaded to media successfully");
	}
	public static void setClipboardData(String string) {
		   StringSelection stringSelection = new StringSelection(string);
		   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		}
}
