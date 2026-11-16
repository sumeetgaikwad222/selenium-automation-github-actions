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

public class Links {
	
	
	
	private WebDriver driver;
	private WebDriverWait wait;
	private JavascriptExecutor js;
	private Actions act;
	@FindBy(xpath = "(//button[normalize-space()='Elements'])[1]") private WebElement elements;
	@FindBy(xpath = "//a[normalize-space()='']") private WebElement li;
	
	
	public Links(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.js = (JavascriptExecutor)driver;
		this.act = new Actions(driver);
		PageFactory.initElements(driver, this);
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

	public WebElement getElements() {
		return elements;
	}

	public WebElement getLi() {
		return li;
	}

	public void check(String ln, String message)
	{
		elements.click();
		li.click();
		By linksname = By.xpath("//a[@id='"+ln+"']");
		WebElement elem = wait.until(ExpectedConditions.elementToBeClickable(linksname));
		elem.click();
		
		By mess = By.xpath(message);
		WebElement ms = wait.until(ExpectedConditions.elementToBeClickable(mess));
		wait.until(ExpectedConditions.visibilityOf(ms));
		System.out.println(ms.getText());
	}
}
