import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.AWTException;

public class UploadMediaURL {
	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriver driver=new FirefoxDriver();
		//for chrome browser
		//System.setProperty("webdriver.chrome.driver", "chromedriver.exe path");
		//WebDriver driver=new ChromeDriver();
		driver.get("http://demo.rtcamp.com/rtmedia/");
		Thread.sleep(5000);
		Login.UserLogin(driver);
		uploadmedia_URL(driver);
	}
	public static void uploadmedia_URL(WebDriver driver) throws InterruptedException, AWTException
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
		//enter URL for media 
		driver.findElement(By.id("rtmedia_url_upload_input")).sendKeys("http://www.tntnphotos.com/wp-content/uploads/Beauty-of-nature-random-4884759-1280-800.jpg");
		new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOfElementLocated(By.className("rtm-url-upload-file-name")));
		driver.findElement(By.id("rtmedia_upload_terms_conditions")).click();//accept terms and conditions
		driver.findElement(By.className("start-media-upload")).click();//click upload button 
		//wait until media is uploaded to album
		new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOfElementLocated(By.className("rtmedia-list-item")));
		System.out.println("File uploaded to media successfully");
	}
	
}
