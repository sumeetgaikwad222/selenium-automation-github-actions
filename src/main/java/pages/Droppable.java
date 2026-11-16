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

public class Droppable {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private JavascriptExecutor js;
	private Actions act;

	public Droppable(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.js = (JavascriptExecutor)driver;
		this.act = new Actions(driver);
	}
	
	@FindBy(xpath = "//button[normalize-space()='Interaction']") private WebElement Interactionlink;
	@FindBy(xpath = "//a[normalize-space()='Droppable']") private WebElement Droppable;
	
	public void always()
	{
		wait.until(ExpectedConditions.elementToBeClickable(Interactionlink));
		act.scrollToElement(Interactionlink).perform();
		Interactionlink.click();
		Droppable.click();
	}
	public void check()
	{
		WebElement taget = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement location = driver.findElement(By.xpath("//div[@id='droppable']"));
		
		act.dragAndDrop(taget, location).perform();
	}
}
