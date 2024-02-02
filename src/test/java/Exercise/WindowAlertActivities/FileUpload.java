package Exercise.WindowAlertActivities;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class FileUpload {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException, IOException {

		String downloadPath = System.getProperty("user.dir");
		
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();

		chromePrefs.put("profile.default_content_settings.popups", 0);

		chromePrefs.put("download.default_directory", downloadPath);
		
		
		
		
		
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		
		
		
		WebDriver driver = new ChromeDriver(options);	
		driver.manage().window().maximize();
		driver.get("https://png2pdf.com/");
		driver.findElement(By.cssSelector("div label span[class=\"button__text\"]")).click();
		//Now we will invoke .exe file through our local system which we have generated through AutoIt tool for handling window alert
		Thread.sleep(3000);
		
		Runtime.getRuntime().exec("C:\\Users\\admin\\Desktop\\FileUpload1.exe");
		
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10000));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div button span[class=\"button__text\"]:nth-child(3)")));
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("div button span[class=\"button__text\"]:nth-child(3)")).click();
		Thread.sleep(5000);
		File f= new File(downloadPath +"/png2pdf.pdf");
		
		if(f.exists()) {
			
			Assert.assertTrue(f.exists());
			
		if(f.delete()) 
			
	System.out.println("File Deleted");
			
		
			
		}
		

	}

}
