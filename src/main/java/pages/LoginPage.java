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

public class LoginPage {
	
	@FindBy(xpath = "//a[normalize-space()='Login']") private WebElement loinlink;
	@FindBy(id = "email") private WebElement username;
	@FindBy(id = "password") private WebElement password;
	@FindBy(xpath = "//input[@value='Login']") private WebElement login;
	@FindBy(partialLinkText = "New User") private WebElement newuser;
	private WebDriver driver;
	private WebDriverWait wait;
	private JavascriptExecutor js;
	private Actions act;
	public WebElement getLoinlink() {
		return loinlink;
	}
	public WebElement getUsername() {
		return username;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getLogin() {
		return login;
	}
	public WebElement getNewuser() {
		return newuser;
	}
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.js = (JavascriptExecutor) driver;
		this.act = new Actions(driver);
		PageFactory.initElements(driver, this);
	}
	public void perform()
	{
		getLoinlink().click();
		wait.until(ExpectedConditions.urlContains("login"));
		getUsername().sendKeys("admin");
		getPassword().sendKeys("admin");
		getLogin().click();
	}
	
}
