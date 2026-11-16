package pages;

import java.time.Duration;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Frames {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private JavascriptExecutor js;
	private Actions act;

	public Frames(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.js = (JavascriptExecutor)driver;
		this.act = new Actions(driver);
	}
	
	@FindBy(xpath = "//button[normalize-space()='Alerts, Frames & Windows']") private WebElement mainlink;
	@FindBy(xpath = "//a[normalize-space()='Frames']") private WebElement Frameslink;
	public void always()
	{
		wait.until(ExpectedConditions.elementToBeClickable(mainlink));
		mainlink.click();
		wait.until(ExpectedConditions.elementToBeClickable(Frameslink));
		Frameslink.click();
	}
	public void frameone()
	{
		WebElement frame = driver.findElement(By.xpath("//iframe[@src='new-tab-sample.php'][1]"));
		driver.switchTo().frame(frame);
		WebElement texts = driver.findElement(By.xpath("//div[@class='row d-flex justify-content-center logindiv bg-white rounded']"));
		System.out.println(texts.getText());
		WebElement btn = driver.findElement(By.xpath("//a[normalize-space()='Selenium Tutorial']"));
		String mainwindow = driver.getWindowHandle();
		btn.click();
		Set<String> allwindows = driver.getWindowHandles();
		
		for(String handle:allwindows)
		{
			if (!handle.equals(mainwindow)) {
				driver.switchTo().window(handle);
				System.out.println(driver.getTitle());
				driver.switchTo().window(mainwindow);
				break;
			}
		}
		WebElement frame2 = driver.findElement(By.xpath("//iframe[@src='new-tab-sample.php'][2]"));
		act.scrollToElement(frame2).perform();
		driver.switchTo().frame(frame2);
		WebElement texts2 = driver.findElement(By.xpath("//div[@class='row d-flex justify-content-center logindiv bg-white rounded']"));
		System.out.println(texts2.getText());
	}
	
}
