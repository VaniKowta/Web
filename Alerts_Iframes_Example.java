package com.wbl;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Alerts_Iframes_Example {

	String LOCATION = System.getProperty("user.dir") + "\\resources\\drivers";
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.chrome.driver", LOCATION + "\\chromedriver.exe");

		driver = new ChromeDriver();
	}

	@Test
	public void alerts() {
		driver.get("http://www.rightstart.com/");

		WebDriverWait wait = new WebDriverWait(driver, 15);

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("close-button")));

		element.click();

	}

	@Test
	public void alertWIndows() throws InterruptedException {
		driver.get("file:///C:/Users/rkowt/Desktop/Alert.html");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("alertId")).click();

		// Thread.sleep(5000);

		Alert alert = driver.switchTo().alert();

		Thread.sleep(5000);

		// alert.sendKeys("this is prompt");

		// goes to immediate parent window of the alert
		driver.switchTo().parentFrame();

		// goes to root window
		driver.switchTo().defaultContent();

		alert.dismiss();
	}
}

/*
	@Test
	public void switchToIframe() {
		driver.get("file:///C:/Users/rkowt/Desktop/Alert.html");

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.switchTo().frame("ifr");

		System.out.println("element inside iframe::" + driver.findElement(By.cssSelector(".phone>a")).getText());

		driver.switchTo().parentFrame();

		driver.close();
	}

}
*/