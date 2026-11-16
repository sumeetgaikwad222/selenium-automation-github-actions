package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import groovy.transform.Final;

public class Dynamicbutton {
	@FindBy(xpath = "(//button[normalize-space()='Elements'])[1]") private WebElement elements;
	@FindBy(xpath = "//a[normalize-space()='Dynamic Properties']") private WebElement li;
	@FindBy(id = "colorChange") private WebElement button;
	@FindBy(id = "visibleAfter") private WebElement visiblebutton;
	
	public WebElement getElements() {
		return elements;
	}

	public WebElement getLi() {
		return li;
	}

	public WebElement getButton() {
		return button;
	}

	public WebElement getVisiblebutton() {
		return visiblebutton;
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

	private WebDriver driver;
	private WebDriverWait wait;
	private JavascriptExecutor js;
	private Actions act;
	
	public Dynamicbutton(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.js = (JavascriptExecutor)driver;
		this.act = new Actions(driver);
		PageFactory.initElements(driver, this);
	}
	public void check()
	{
		elements.click();
		li.click();
		button.click();
		wait.until(ExpectedConditions.visibilityOf(visiblebutton));
		wait.until(ExpectedConditions.elementToBeClickable(visiblebutton));
		
	}
}
