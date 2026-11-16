package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import groovyjarjarantlr4.v4.runtime.tree.xpath.XPath;

public class Alerts {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private JavascriptExecutor js;
	private Actions act;

	public Alerts(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.js = (JavascriptExecutor)driver;
		this.act = new Actions(driver);
	}
	
	@FindBy(xpath = "//button[normalize-space()='Alerts, Frames & Windows']") private WebElement mainlink;
	@FindBy(xpath = "//a[normalize-space()='Alerts']") private WebElement alertlink;
	@FindBy(xpath = "//button[normalize-space()='Alert']") private WebElement alertbutton;
	
	public void always()
	{
		wait.until(ExpectedConditions.elementToBeClickable(mainlink));
		mainlink.click();
		wait.until(ExpectedConditions.elementToBeClickable(alertlink));
		alertlink.click();
	}
	public void onclickalert()
	{
		alertbutton.click();
		driver.switchTo().alert().accept();
	}
	public void waitforsecalert()
	{
		WebElement el = driver.findElement(By.xpath("//button[@onclick='myMessage()']"));
		wait.until(ExpectedConditions.elementToBeClickable(el));
		el.click();
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}
	public void acceptanddismissalert(String action)
	{
		WebElement el = driver.findElement(By.xpath("//button[@onclick='myDesk()']"));
		wait.until(ExpectedConditions.elementToBeClickable(el));
		el.click();
		wait.until(ExpectedConditions.alertIsPresent());
		
		if (action.equalsIgnoreCase("accept")) {
			driver.switchTo().alert().accept();
		}
		else if (action.equalsIgnoreCase("dismiss")) {
			driver.switchTo().alert().dismiss();
		}
		else {
	        throw new IllegalArgumentException(
	                "Action must be accept or dismiss");
	    }
		
		WebElement texts = driver.findElement(By.xpath("//div[@id='desk']"));
		wait.until(ExpectedConditions.visibilityOf(texts));
		System.out.println(texts.getText());
	}
	public void enterprompt(String message)
	{
		WebElement el = driver.findElement(By.xpath("//button[@onclick='myPromp()']"));
		wait.until(ExpectedConditions.elementToBeClickable(el));
		el.click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alerts = driver.switchTo().alert();
		alerts.sendKeys(message);
		alerts.accept();
	}
}
