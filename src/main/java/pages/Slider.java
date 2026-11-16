package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Slider {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private JavascriptExecutor js;
	private Actions act;

	public Slider(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.js = (JavascriptExecutor)driver;
		this.act = new Actions(driver);
	}
	
	@FindBy(xpath = "//button[normalize-space()='Widgets']") private WebElement Widgetslink;
	@FindBy(xpath = "//a[normalize-space()='Slider']") private WebElement Sliderlink;
	@FindBy(xpath = "//input[@id='ageInputId']")private WebElement element;
	
	public void always()
	{
		wait.until(ExpectedConditions.elementToBeClickable(Widgetslink));
		Widgetslink.click();
		Sliderlink.click();
	}
	
	public void setSliderValue(int targetValue)
	{
	    WebElement slider =
	            driver.findElement(By.xpath("//input[@type='range']"));

	    int currentValue =
	            Integer.parseInt(slider.getAttribute("value"));

	    while(currentValue < targetValue)
	    {
	        slider.sendKeys(Keys.ARROW_RIGHT);

	        currentValue =
	                Integer.parseInt(slider.getAttribute("value"));
	    }

	    Assert.assertEquals(currentValue, targetValue,
	            "Slider value mismatch");
	}
}
