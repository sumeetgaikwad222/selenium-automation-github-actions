package pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Browser_windows {
	
	@FindBy(xpath = "//button[normalize-space()='Alerts, Frames & Windows']") private WebElement alertframewindow;
	@FindBy(xpath = "//a[normalize-space()='Browser Windows']") private WebElement browserwindowtab;
	@FindBy(xpath = "//body//main//div[@class='container']") private WebElement samplemessage;
	@FindBy(xpath = "//body//main//div[@class='container']") private WebElement newwindowmessage;
	private WebDriverWait wait;
	private WebDriver driver;
	private JavascriptExecutor js;
	private Actions act;
	public Browser_windows(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.js = (JavascriptExecutor) driver;
		this.act = new Actions(driver);
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getAlertframewindow() {
		return alertframewindow;
	}
	
	public void perform(String windowtitle)
	{
		alertframewindow.click();
		wait.until(ExpectedConditions.elementToBeClickable(browserwindowtab));
		browserwindowtab.click();
		String mainwindow = driver.getWindowHandle();
		driver.findElement(By.xpath("//button[normalize-space()='"+windowtitle+"']")).click();
		Set<String> allwindows = driver.getWindowHandles();
		if (windowtitle.equalsIgnoreCase("New Tab")) {
			for(String window : allwindows)
			{
				if (!window.equals(mainwindow)) {
					driver.switchTo().window(window);
					System.out.println(samplemessage.getText());
					break;
					
				}
			}
		}
		else if (windowtitle.equalsIgnoreCase("New Window")) {
			for(String window1 : allwindows)
			{
				if (!window1.equals(mainwindow)) {
					driver.switchTo().window(window1);
					System.out.println(samplemessage.getText());
					break;
					
				}
			}
		}
		else if(windowtitle.equalsIgnoreCase("New Window Message"))
		{
			for(String window2 : allwindows)
			{
				if(!window2.equals(mainwindow))
				{
					driver.switchTo().window(window2);
					wait.until(ExpectedConditions.textToBePresentInElement(newwindowmessage, "New Window Message"));
					System.out.println(newwindowmessage.getText());
					break;
				}
			}
		}
	}
}
