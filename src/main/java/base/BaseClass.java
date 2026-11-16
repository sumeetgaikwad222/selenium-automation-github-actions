package base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;

import files.ReadFiles;
import io.cucumber.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass implements Constant {
	protected static WebDriver driver;
	@BeforeTest
	public void setup(@Optional("chrome") String browser) throws IOException
	{
		ReadFiles files = new ReadFiles();
		String url = files.config(Config, "url");
		
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty(MSEDGEKey, MSEDGEDriverPath);
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
		driver.get(url);
	}
	@AfterTest
	public void teardown() {
	if (driver != null) {
		driver.quit();
	}
	}
}
