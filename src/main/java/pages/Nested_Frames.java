package pages;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Nested_Frames {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private JavascriptExecutor js;
	private Actions act;

	public Nested_Frames(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.js = (JavascriptExecutor)driver;
		this.act = new Actions(driver);
	}
	
	@FindBy(xpath = "//button[normalize-space()='Alerts, Frames & Windows']") private WebElement mainlink;
	@FindBy(xpath = "//a[normalize-space()='Nested Frames']") private WebElement NestFrameslink;
	public void always()
	{
		wait.until(ExpectedConditions.elementToBeClickable(mainlink));
		mainlink.click();
		wait.until(ExpectedConditions.elementToBeClickable(NestFrameslink));
		NestFrameslink.click();
	}
	public void check()
	{
		WebElement parent = driver.findElement(By.xpath("(//div[@class='col-md-8 col-lg-8 col-xl-8'])[1]"));
		driver.switchTo().frame(parent);
		WebElement fm = driver.findElement(By.xpath("(//header[@class='header selenium bg-white p-3 '])[1]"));
		driver.switchTo().frame(fm);
		WebElement btn = driver.findElement(By.xpath("//a[normalize-space()='Selenium Tutorial']"));
		btn.click();
		
		driver.switchTo().defaultContent();
		WebElement fm1 = driver.findElement(By.xpath("//div[@class='row d-flex justify-content-center logindiv bg-white rounded']"));
		act.scrollToElement(fm1).perform();
		driver.switchTo().frame(fm1);
		System.out.println(fm1.getText());
	}
}
