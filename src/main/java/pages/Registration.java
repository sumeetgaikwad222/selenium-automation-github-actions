package pages;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Registration {
	
	@FindBy(xpath ="//a[normalize-space()='Register']")	private WebElement registerlink;
	private WebDriver driver;
	private WebDriverWait wait;
	private JavascriptExecutor js;
	private Actions act;
	
	
	public WebElement getRegisterlink() {
		return registerlink;
	}
	
	public Registration(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.js = (JavascriptExecutor) driver;
		this.act = new Actions(driver);
		PageFactory.initElements(driver, this);
	}
	public void perform(String name, String lastname, String username, String password, String Filename) throws IOException
	{
		registerlink.click();
		wait.until(ExpectedConditions.urlContains("register"));
		driver.findElement(By.id("firstname")).sendKeys(name);
		driver.findElement(By.id("lastname")).sendKeys(lastname);
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Register']")).click();
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		File desc = new File(
		    "C:\\Users\\SUMEET GAIKWAD\\eclipse-workspace\\Re_Start\\src\\test\\resources"
		    + Filename + ".png");

		Files.copy(source.toPath(), desc.toPath());
	}
}
