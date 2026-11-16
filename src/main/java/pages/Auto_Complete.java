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

public class Auto_Complete {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private JavascriptExecutor js;
	private Actions act;

	public Auto_Complete(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.js = (JavascriptExecutor)driver;
		this.act = new Actions(driver);
	}
	
	@FindBy(xpath = "//button[normalize-space()='Widgets']") private WebElement Widgetslink;
	@FindBy(xpath = "//a[normalize-space()='Auto Complete']") private WebElement AutoComplete;
	@FindBy(id = "tags") private WebElement field;
	public void always()
	{
		wait.until(ExpectedConditions.elementToBeClickable(Widgetslink));
		Widgetslink.click();
		AutoComplete.click();
	}
	public void check(String value)
	{
		wait.until(ExpectedConditions.elementToBeClickable(field));
		field.sendKeys(value);
		WebElement firstoption = driver.findElement(By.xpath("(//ul[@id='ui-id-1']//li)[1]"));
		wait.until(ExpectedConditions.visibilityOf(firstoption));
		wait.until(ExpectedConditions.elementToBeClickable(firstoption));
		firstoption.click();
	}
	
}
