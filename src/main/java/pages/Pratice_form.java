package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Pratice_form {
	
	@FindBy(id = "name") private WebElement firstname;
	@FindBy(id = "email") private WebElement email;
	@FindBy(id = "mobile") private WebElement mobile;
	@FindBy(id = "dob") private WebElement calender;
	@FindBy(id = "subjects") private WebElement subjects;
	@FindBy(xpath = "//input[@type='checkbox']") List<WebElement> hobbies;
	@FindBy(xpath = "//input[@id='picture']") private WebElement picture;
	@FindBy(xpath = "//textarea[@id='picture']") private WebElement address;
	@FindBy(xpath = "//select[@id='state']") private WebElement state;
	@FindBy(xpath = "//select[@id='city']") private WebElement city;
	@FindBy(xpath = "//input[@value='Login']") private WebElement submit;
	private WebDriver driver;
	private WebDriverWait wait;
	private JavascriptExecutor js;
	private Actions act;
	public WebElement getFirstname() {
		return firstname;
	}
	public WebElement getEmail() {
		return email;
	}
	public WebElement getMobile() {
		return mobile;
	}
	public WebElement getCalender() {
		return calender;
	}
	public WebElement getSubjects() {
		return subjects;
	}
	public List<WebElement> getHobbies() {
		return hobbies;
	}
	public WebElement getPicture() {
		return picture;
	}
	public WebElement getAddress() {
		return address;
	}
	public WebElement getState() {
		return state;
	}
	public WebElement getCity() {
		return city;
	}
	public WebElement getSubmit() {
		return submit;
	}
	public Pratice_form(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.js = (JavascriptExecutor)driver;
		this.act = new Actions(driver);
		PageFactory.initElements(driver, this);
	}
	public void perform1(String name, String Email, String Genders, String hobbyname)
	{
		firstname.sendKeys(name);
		email.sendKeys(Email);
		driver.findElement(By.xpath("//label[text()='"+Genders+"']")).click();
		mobile.sendKeys("9876543210");
		calender.click();
		calender.sendKeys("10-02-1995");
		subjects.click();
		subjects.sendKeys("Maths");
		hobbies.get(0).click();
		for (WebElement h : hobbies) {
			if(h.getText().equals(hobbyname))
			{
				wait.until(ExpectedConditions.elementToBeClickable(h));
				h.click();
				break;
			}
		}
		picture.sendKeys("C:\\Users\\SUMEET GAIKWAD\\eclipse-workspace\\Re_Start\\src\\test\\resources\\test.jpg");
		address.sendKeys("current address");
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", state);
		act.moveToElement(state).click().perform();
		state.sendKeys("NCR" + Keys.ENTER);
		act.moveToElement(city).click().perform();
		Select sele = new Select(city);
		sele.selectByVisibleText("Meerut");
		act.scrollToElement(submit).click().perform();
		submit.click();
	}
}
