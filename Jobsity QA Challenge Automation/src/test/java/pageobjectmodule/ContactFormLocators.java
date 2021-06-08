package pageobjectmodule;

import template.PageSkeleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ContactFormLocators extends PageSkeleton {


    public ContactFormLocators(WebDriver driver) {
        super(driver);
    }



    //<editor-fold desc="Web Elements">
    @FindBy(id = "submitMessage")
    public WebElement submitBtn;

    @FindBy(id = "id_order")
    public WebElement orderRefBox;

    @FindBy(id = "message")
    public WebElement messageBox;

    @FindBy(id = "email")
    public WebElement emailBox;

    @FindBy(id = "id_contact")
    public WebElement subjectDD;

    @FindBy(id = "desc_contact2")
    public WebElement subjectDesc;

    @FindBy(id = "fileUpload")

    public WebElement fileUpload;

    @FindBy(xpath = "//*[@id=\"uniform-fileUpload\"]/span[1]")
    public WebElement fileBox;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/p")
    public WebElement successMsg;

    @FindBy(xpath = "//p[@class='form-group form-ok']")
    public WebElement validateEmail;


    @FindBy(xpath = "//div[@class='alert alert-danger']")
    public WebElement errorMsg;


    //</editor-fold>



}







