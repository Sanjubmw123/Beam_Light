package LightBeam;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class lightbeam {
	WebDriver driver;

	@Test
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://lightbeamhealth.com/");
		 driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		WebElement webEle = driver.findElement(By.xpath("//*[@id='menu-item-657']/a/span[1]"));
		webEle.click();
		String link = webEle.getText();

		String actualLink = link.substring(0, link.length() - 1).trim();
		String expectedLink = "WHY LIGHTBEAM";
		Assert.assertEquals(actualLink, expectedLink, "Didn't match with actual and expected");
		System.out.println(actualLink); 
		driver.findElement(By.xpath("//a/span [contains(text(),'Industry Leading')]")).click();
		String actualString = driver.findElement(By.xpath("//*[text()='info@lightbeamhealth.com']")). getText();
		String expectedString = "info@lightbeamhealth.com";
		assertTrue(actualString.contains(expectedString));
				

	}
}