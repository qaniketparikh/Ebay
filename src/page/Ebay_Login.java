package page;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

public class Ebay_Login {
	
	WebDriver driver;
		public void OpenBrowser() throws IOException {
		FileInputStream fs = new FileInputStream("C:\\Practice\\ebay.properties");
		  Properties prop = new Properties();
		  prop.load(fs);
		  
		  String browser = prop.getProperty("Browser");
		  if (browser.equals("Firefox")) {
			  System.setProperty("webdriver.gecko.driver", "C:\\jar\\geckodriver.exe");
			 driver = new FirefoxDriver();
			
		}
		  else {
			  System.setProperty("webdriver.ie.driver", "C:\\jar\\IEDriverServer_x64_3.150.1\\IEDriverServer.exe");
			  driver = new InternetExplorerDriver();
		}
		
	}
		
		public void OpenURL() throws IOException {
			FileInputStream fs = new FileInputStream("C:\\Practice\\ebay.properties");
			  Properties prop = new Properties();
			  prop.load(fs);
			driver.get(prop.getProperty("URL"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		public void CorrectUserName() throws IOException {
			FileInputStream fs = new FileInputStream("C:\\Practice\\ebay.properties");
			  Properties prop = new Properties();
			  prop.load(fs);
			driver.findElement(By.id("userid")).sendKeys(prop.getProperty("UserName"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			
		}
		
		public void ClickContinue() {
			driver.findElement(By.id("signin-continue-btn")).click();
		}
		
		public void CorrectPassword() throws IOException {
			FileInputStream fs = new FileInputStream("C:\\Practice\\ebay.properties");
			  Properties prop = new Properties();
			  prop.load(fs);
			
			driver.findElement(By.id("pass")).sendKeys(prop.getProperty("Password"));
		}
		
		public void SignIn() {
			driver.findElement(By.id("sgnBt")).click();
		}
		
		public void SignOut() {
			WebElement signout = driver.findElement(By.id("gh-ug"));
			Actions builder = new Actions(driver);
			builder.moveToElement(signout).build().perform();
			
			driver.findElement(By.linkText("Sign out")).click();
			
		}
		
		
		public void CloseBrowser() {
			driver.quit();
		}
		
		public void Search() {
			driver.findElement(By.id("gh-ac")).sendKeys("laptop");
			  driver.findElement(By.id("gh-btn")).click();
		}
		
		public void Cart() {
			WebElement cart = driver.findElement(By.className("gh-cart-icon"));
			Actions builder = new Actions(driver);
			builder.moveToElement(cart).build().perform();
			
		}
		
		public String emptyCartmsg() {
			return driver.findElement(By.className("gh-minicart-header__title")).getText();
		}
		
		public String emptyCartmsg2() {
			return driver.findElement(By.className("gh-minicart-empty-message")).getText();
		}
		
		public void screenshot() throws IOException {
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			  FileUtils.copyFile(srcFile, new File("C:\\Practice\\abc.png"));
		}
		
		
		
		
		
		
		
	
	

}
