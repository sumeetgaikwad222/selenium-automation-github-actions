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

public class Buttons {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private JavascriptExecutor js;
	private Actions act;

	public Buttons(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.js = (JavascriptExecutor)driver;
		this.act = new Actions(driver);
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	public WebDriverWait getWait() {
		return wait;
	}
	public JavascriptExecutor getJs() {
		return js;
	}
	public Actions getAct() {
		return act;
	}
	public String getButtonname() {
		return buttonname;
	}
	public By getButtons() {
		return buttons;
	}
	public WebElement getButtonlink() {
		return buttonlink;
	}

	String buttonname = "Double Click Me";
	By buttons = By.xpath("//button[normalize-space()='"+buttonname+"']");
	@FindBy(xpath = "//a[normalize-space()='Buttons']") private WebElement buttonlink;
	public void check()
	{
		driver.findElement(By.xpath("(//button[normalize-space()='Elements'])[1]")).click();
		buttonlink.click();
		WebElement bt = wait.until(ExpectedConditions.elementToBeClickable(buttons));
		if (buttonname.equalsIgnoreCase("Click Me")) {
			bt.click();
		}
		else if(buttonname.equalsIgnoreCase("Right Click Me"))
		{
			act.contextClick(bt).perform();
		}
		else if (buttonname.equalsIgnoreCase("Double Click Me")) {
			act.doubleClick(bt).click().perform();
		}
	}
	
}
