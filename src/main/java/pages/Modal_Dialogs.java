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

public class Modal_Dialogs {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private JavascriptExecutor js;
	private Actions act;

	public Modal_Dialogs(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.js = (JavascriptExecutor)driver;
		this.act = new Actions(driver);
	}
	
	@FindBy(xpath = "//button[normalize-space()='Alerts, Frames & Windows']") private WebElement mainlink;
	@FindBy(xpath = "//a[normalize-space()='Modal Dialogs']") private WebElement Modellink;
	@FindBy(xpath = "//button[normalize-space()='Small Modal']") private WebElement smallbutton;
	@FindBy(xpath = "//button[normalize-space()='Large Modal']") private WebElement largebutton;
	@FindBy(xpath = "(//div[@class='modal-content'])[1]") private WebElement smpopup;
	public void always()
	{
		wait.until(ExpectedConditions.elementToBeClickable(mainlink));
		mainlink.click();
		wait.until(ExpectedConditions.elementToBeClickable(Modellink));
		Modellink.click();
	}
	
	public void check()
	{
		wait.until(ExpectedConditions.elementToBeClickable(smallbutton));
		smallbutton.click();
		wait.until(ExpectedConditions.visibilityOf(smpopup));
		System.out.println(smpopup.getText());
		WebElement closebtn = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//button[@class='btn btn-primary'][normalize-space()='Close'])[1]"))));
		closebtn.click();
	}
}
