package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Resize {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private JavascriptExecutor js;
	private Actions act;

	public Resize(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.js = (JavascriptExecutor)driver;
		this.act = new Actions(driver);
	}
	
	@FindBy(xpath = "//button[normalize-space()='Interaction']") private WebElement Interactionlink;
	@FindBy(xpath = "//a[normalize-space()='Resizable']") private WebElement Resizable;
	
	public void always()
	{
		wait.until(ExpectedConditions.elementToBeClickable(Interactionlink));
		act.scrollToElement(Interactionlink).perform();
		Interactionlink.click();
		Resizable.click();
	}
	public void check()
	{
		WebElement handle = driver.findElement(
			    By.xpath("(//div[@class='both selector'])[1]")
			);

			act.moveToElement(handle)
			   .clickAndHold()
			   .moveByOffset(50, 50)
			   .release()
			   .perform();
	}
}
