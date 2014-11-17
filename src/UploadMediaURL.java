import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.AWTException;

public class UploadMediaURL {
	@Test
	public static void UploadMediaURL_main() throws InterruptedException, AWTException {
		WebDriver driver=new FirefoxDriver();
		//for chrome browser
		//System.setProperty("webdriver.chrome.driver", "chromedriver.exe path");
		//WebDriver driver=new ChromeDriver();
		driver.get("http://demo.rtcamp.com/rtmedia/");
		Thread.sleep(5000);
		Login.UserLogin(driver);
		uploadmedia_URL(driver);
		driver.close();
	}
	public static void uploadmedia_URL(WebDriver driver) throws InterruptedException, AWTException
	{
		//driver.get("http://demo.rtcamp.com/rtmedia/members/test-sel/media/");
		driver.findElement(By.className("rtp-user-name")).click();//click on username
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a.activity[title='Activity']")).click();//click on activity
		Thread.sleep(5000);
		driver.findElement(By.id("media-personal-li")).click();//click on media
		Thread.sleep(5000);
		driver.findElement(By.id("rtm_show_upload_ui")).click();//click on upload
		Thread.sleep(3000);
		Select album=new Select(driver.findElement(By.className("rtmedia-user-album-list")));
		album.selectByVisibleText("Wall Posts");//select album
		Thread.sleep(2000);
		Select privacy=new Select(driver.findElement(By.id("rtSelectPrivacy")));
		privacy.selectByVisibleText("Private");//select privacy
		//enter URL for image
		driver.findElement(By.id("rtmedia_url_upload_input")).sendKeys("http://www.tntnphotos.com/wp-content/uploads/Beauty-of-nature-random-4884759-1280-800.jpg");
		//wait until image is uploaded
		new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOfElementLocated(By.className("rtm-url-upload-file-name")));
		driver.findElement(By.id("rtmedia_upload_terms_conditions")).click();//accept terms and conditions
		driver.findElement(By.className("start-media-upload")).click();//start uploading
		//check if media is uploaded
		new WebDriverWait(driver,60).until(ExpectedConditions.textToBePresentInElement(By.className("rtm-url-upload-file-status"), "Uploaded"));
		System.out.println("File uploaded to media successfully");
	}
	
}
