/**
 * 
 */
package firpeoproject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * @author srinidhi.k
 *
 */

public class FitPeoAutomation {

	public static void main(String[] args) {
		// Setup WebDriver
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		try {
			// Navigate to the FitPeo Homepage
			driver.get("https://fitpeo.com");

			// Navigate to the Revenue Calculator Page
			WebElement revenueCalculatorLink = driver.findElement(By.linkText("Revenue Calculator"));
			revenueCalculatorLink.click();

			Thread.sleep(2000);
			// using pwdn command to go to the slider part //
			Actions actions = new Actions(driver);
			actions.sendKeys(Keys.PAGE_DOWN).perform();

			// Adjust the slider to set its value to 820
			WebElement slider = driver.findElement(By.xpath(".//input[@type='range']"));
			Thread.sleep(2000);

			actions.dragAndDropBy(slider, 94, 0).perform();

			// Adjust the static field to 560
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement sliderValueField = driver.findElement(By.xpath("//input[@type='number']"));
			sliderValueField.click();
			Thread.sleep(1000);

			// Clear the field completely using JavaScript
			js.executeScript("arguments[0].value = '';", sliderValueField);
			Thread.sleep(1000);

			// Set the value to 560
			sliderValueField.sendKeys("560");
			Thread.sleep(2000);

			actions.sendKeys(Keys.PAGE_DOWN).perform();
			Thread.sleep(1000);
			driver.findElement(By.xpath(".//span[text()='57']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(".//span[text()='19.19']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(".//span[text()='63']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(".//span[text()='15']")).click();

			// Validate Total Recurring Reimbursement
			WebElement totalReimbursement = driver.findElement(
					By.xpath(".//p[text()='Total Recurring Reimbursement for all Patients Per Month:']/p"));
			String reimbursementText = totalReimbursement.getText();
			Thread.sleep(2000);
			assert reimbursementText.equals("$110700") : "Total Recurring Reimbursement did not match expected value";
		} catch (Exception e) {

		} finally {

			driver.quit();
		}

	}

}
