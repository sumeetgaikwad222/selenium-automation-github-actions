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

public class HorizontalScroll {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private JavascriptExecutor js;
	private Actions act;

	public HorizontalScroll(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.js = (JavascriptExecutor)driver;
		this.act = new Actions(driver);
	}
	
	@FindBy(xpath = "//button[normalize-space()='Widgets']") private WebElement Widgetslink;
	@FindBy(xpath = "//a[normalize-space()='Horizontal Scroll']") private WebElement HScroll;
	
	public void always()
	{
		wait.until(ExpectedConditions.elementToBeClickable(Widgetslink));
		Widgetslink.click();
		act.scrollToElement(HScroll).perform();
		HScroll.click();
		WebElement slid = driver.findElement(By.xpath("(//div[@class='horizan-scroll'])[1]"));
		slid.click();
		js.executeScript("window.scrollBy(500,0)");
	}
}
