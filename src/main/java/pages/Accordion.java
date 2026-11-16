package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Accordion {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private JavascriptExecutor js;
	private Actions act;

	public Accordion(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.js = (JavascriptExecutor)driver;
		this.act = new Actions(driver);
	}
	
	@FindBy(xpath = "//button[normalize-space()='Widgets']") private WebElement Widgetslink;
	@FindBy(xpath = "//a[normalize-space()='Accordion']") private WebElement Accordionlink;
	@FindBy(xpath = "//button[normalize-space()='What is Lorem Ipsum?']") private WebElement first;
	@FindBy(xpath = "//button[normalize-space()='Where can I get some?']") private WebElement second;
	
	
	public void always()
	{
		wait.until(ExpectedConditions.elementToBeClickable(Widgetslink));
		Widgetslink.click();
		Accordionlink.click();
	}
	public void check()
	{
		first.click();
		WebElement sec1 = driver.findElement(By.xpath("//div[@id='collapseTwentyOne']//p[@class='text-justify']"));
		wait.until(ExpectedConditions.visibilityOf(sec1));
		System.out.println(sec1.getText());
		Assert.assertTrue(sec1.isDisplayed(), "The section is not displayed");
	}
	public void check1()
	{
		second.click();
		WebElement sec2 = driver.findElement(By.xpath("(//p[contains(text(),\"There are many variations of passages of Lorem Ips\")])[1]"));
		wait.until(ExpectedConditions.visibilityOf(sec2));
		System.out.println(sec2.getText());
		Assert.assertTrue(sec2.isDisplayed(), "The section is not displayed");
	}
}
