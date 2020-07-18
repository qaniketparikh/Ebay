package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import page.Ebay_Login;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class EbayTests {
	WebDriver driver;
	Ebay_Login ep = new Ebay_Login();
  
  @BeforeMethod
  public void beforeMethod() throws IOException, InterruptedException {
	  ep.OpenBrowser();
	  ep.OpenURL();
	  Thread.sleep(2000);
	  ep.CorrectUserName();
	  Thread.sleep(3000);
	  ep.ClickContinue();
	  Thread.sleep(2000);
	  ep.CorrectPassword();
	  Thread.sleep(2000);
	  ep.SignIn();
	 	   
  }

  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  ep.SignOut();
	  Thread.sleep(2000);
	  ep.CloseBrowser();
	  
  }
  
  @Test
  public void Search() {
	  ep.Search();
  }

  @Test(groups = {"nik"})
  public void Cart() throws IOException, InterruptedException {
	  ep.Cart();
	  Assert.assertEquals(ep.emptyCartmsg(), "Your cart is empty");
	  Assert.assertEquals(ep.emptyCartmsg2(), "Time to start shopping!");
	  
	  Thread.sleep(4000);
	  ep.screenshot();
	  
	  
  }
}
