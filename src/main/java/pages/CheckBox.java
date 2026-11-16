package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckBox {
	
	@FindBy(xpath = "(//button[normalize-space()='Elements'])[1]") private WebElement elements;
	@FindBy(xpath = "//a[normalize-space()='Radio Button']") private WebElement radiolink;
	private WebDriver driver;
	private WebDriverWait wait;
	private JavascriptExecutor js;

	public WebElement getElements() {
		return elements;
	}
	public WebElement getRadiolink() {
		return radiolink;
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
	public CheckBox(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.js = (JavascriptExecutor)driver;
	}
	public void checking(String button)
	{
		wait.until(ExpectedConditions.elementToBeClickable(elements)).click();
		wait.until(ExpectedConditions.elementToBeClickable(radiolink)).click();
		WebElement radiobutton = driver.findElement(By.xpath("//label[text()='"+button+"']/preceding-sibling::input"));
		wait.until(ExpectedConditions.elementToBeClickable(radiobutton));
		radiobutton.click();
		String actualMessage = driver.findElement(
			    By.id("check1")
			).getText();

			System.out.println(actualMessage);
	}
}
