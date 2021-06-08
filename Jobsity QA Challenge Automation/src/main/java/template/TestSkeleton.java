package template;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestSkeleton {

    protected static WebDriver driver;
    public String testFile = System.getProperty("user.dir") + "\\src\\main\\resources\\test.png";

    public WebDriver getDriver() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        return driver;

    }

    @BeforeMethod
    public void Initialize() {
        getDriver();
        driver.get("http://automationpractice.com/index.php?controller=contact");
    }

    @AfterMethod
    public void Finalize() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }

    }
}


