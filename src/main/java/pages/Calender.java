package pages;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Calender {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private JavascriptExecutor js;
	private Actions act;
	public Calender(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.js = (JavascriptExecutor)driver;
		this.act = new Actions(driver);
	}
	
	@FindBy(xpath = "//button[normalize-space()='Widgets']") private WebElement Widgetslink;
	@FindBy(xpath = "//a[normalize-space()='Date Picker']") private WebElement Datepickerlink;
	@FindBy(id = "datetimepicker1")private WebElement firstcalender;
	@FindBy(id = "datetimepicker2") private WebElement secondcalender;
	public void always()
	{
		wait.until(ExpectedConditions.elementToBeClickable(Widgetslink));
		Widgetslink.click();
		Datepickerlink.click();
	}
	public void check(String month, String year,String day)
{
firstcalender.click();

Select monthDropdown = new Select(
      driver.findElement(
          By.xpath("(//select[@aria-label='Month'])[1]")));

monthDropdown.selectByVisibleText(month);

WebElement yearInput =
      driver.findElement(
          By.xpath("(//input[@aria-label='Year'])[1]"));

yearInput.clear();
yearInput.sendKeys(year);

String targetDate =
      month + " " + day + ", " + year;

WebElement date =
      wait.until(
          ExpectedConditions.elementToBeClickable(
              By.xpath("//span[@aria-label='"+targetDate+"']")));

date.click();

firstcalender.click();
}
	public void selectDateAndTime(String month,
            String year,
            String day)
{
// Open second calendar
secondcalender.click();

// Select Month
WebElement monthDropdown = wait.until(
ExpectedConditions.visibilityOfElementLocated(
  By.xpath("(//select[@aria-label='Month'])[2]")));

Select sel = new Select(monthDropdown);
sel.selectByVisibleText(month);

// Enter Year
WebElement yearInput = wait.until(
ExpectedConditions.visibilityOfElementLocated(
  By.xpath("(//input[@aria-label='Year'])[2]")));

yearInput.clear();
yearInput.sendKeys(year);

// Build aria-label
String targetDate =
month + " " + day + ", " + year;

System.out.println("Selecting Date : " + targetDate);

// Wait until date becomes clickable
By dateLocator =
By.xpath("//span[@aria-label='" + targetDate + "']");

WebElement date = wait.until(
ExpectedConditions.elementToBeClickable(
  dateLocator));

// Scroll into view
((JavascriptExecutor) driver)
.executeScript(
  "arguments[0].scrollIntoView(true);",
  date);

// Click date
try
{
date.click();
}
catch(Exception e)
{
// Fallback JS click
((JavascriptExecutor) driver)
.executeScript(
      "arguments[0].click();",
      date);
}
}
	
}
