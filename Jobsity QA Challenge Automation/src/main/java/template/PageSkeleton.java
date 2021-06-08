package template;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageSkeleton {

    //<editor-fold desc="Global Variables">
    protected WebDriver driver;
    private static final int TIMEOUT = 5;
    private final WebDriverWait wait;
    //</editor-fold>

    public PageSkeleton(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, TIMEOUT);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
    }

    public void waitForScreenToLoad(WebElement element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element.getAttribute("id"))));
    }

    public Select fromDropdownList(WebElement elementDD) { return new Select(elementDD); }
}