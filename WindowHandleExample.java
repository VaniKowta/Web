package com.wbl;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandleExample {

	static String LOCATION = "C:\\Users\\rkowt\\workspace\\WebDriverExamples\\resources\\drivers\\";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", LOCATION + "\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://talentscreen.io");
		driver.findElement(By.xpath(".//a[text()='Log In']")).click();

		// to get current window name

		driver.findElement(By.cssSelector(".btn.btn-lg.btn-block.btn-social.btn-google")).click();
		String currentWindowName = driver.getWindowHandle();
		System.out.println("current windowname::" + currentWindowName);

		// gives all windows that are open

		Set<String> windows = driver.getWindowHandles();
		System.out.println("count of windows::" + windows.size());
		// iterating over windows and trying to switch to child window
		for (String win : windows) {
			System.out.println("windowname::" + win);
			// making sure that we are switching to child window but not parent
			// window
			if (!win.equals(currentWindowName)) {
				driver.switchTo().window(win);
				// in each window
			}
		}
        driver.findElement(By.id(".//*[@id='identifierLink']"));
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("Test123");

		Thread.sleep(5000);
		
		driver.quit();
	}

}
