
package base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;

import files.ReadFiles;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass implements Constant {

    protected static WebDriver driver;

    @BeforeTest
    public void setup(@Optional("chrome") String browser) throws IOException {

        ReadFiles files = new ReadFiles();
        String url = files.config(Config, "url");

        if (browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();

            // Headless execution for GitHub Actions
            options.addArguments("--headless=new");

            // Linux CI stability options
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");

            // Set browser window dimensions
            options.addArguments("--window-size=1920,1080");

            driver = new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("edge")) {

            System.setProperty(MSEDGEKey, MSEDGEDriverPath);

            EdgeOptions options = new EdgeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1920,1080");

            driver = new EdgeDriver(options);

        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));

        driver.get(url);
    }

    @AfterTest(alwaysRun = true)
    public void teardown() {

        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
