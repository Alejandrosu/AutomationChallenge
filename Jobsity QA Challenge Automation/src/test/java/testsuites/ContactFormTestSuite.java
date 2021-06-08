package testsuites;


import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import pageobjectmodule.ContactFormLocators;
import template.TestSkeleton;

public class ContactFormTestSuite extends TestSkeleton {

    Assertion Assert = new Assertion();

    @Test
    public void CTC01_Send_Form_All_Blanks() {
        //This validation consists of submitting the form without any information.
        try {


            ContactFormLocators ContactForm = new ContactFormLocators(driver);

            ContactForm.submitBtn.click();
            ContactForm.waitForScreenToLoad(ContactForm.errorMsg);
            Assert.assertEquals(ContactForm.errorMsg.getText(),"There are 3 errors\n" + "Invalid email address.\n" + "The message cannot be blank.\n" + "Please select a subject from the list provided.");

        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError(e.toString());
        }

    }

    @Test
    public void CTC08_Send_Form_No_Subject() {
        //This validation consists of submitting the form without the subject header.
        try {

            ContactFormLocators ContactForm = new ContactFormLocators(driver);

            ContactForm.emailBox.sendKeys("Test@test.com");
            ContactForm.orderRefBox.sendKeys("Test Reference");
            ContactForm.fileUpload.sendKeys(testFile);
            ContactForm.messageBox.sendKeys("This is a test, don't you agree JPP?");
            ContactForm.submitBtn.click();
            ContactForm.waitForScreenToLoad((ContactForm.errorMsg));
            Assert.assertEquals(ContactForm.errorMsg.getText(),"There is 1 error\n" + "Please select a subject from the list provided.");

        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError(e.toString());
        }
    }


    @Test
    public void CTC02_Send_Form_Without_Email() {
        //This validation consists of submitting the form without the email address.
        try {

            ContactFormLocators ContactForm = new ContactFormLocators(driver);

            ContactForm.fromDropdownList(ContactForm.subjectDD).selectByIndex(1);
            ContactForm.orderRefBox.sendKeys("Test Reference");
            ContactForm.fileUpload.sendKeys(testFile);
            ContactForm.messageBox.sendKeys("This is a test, don't you agree JPP?");
            ContactForm.submitBtn.click();
            ContactForm.waitForScreenToLoad((ContactForm.errorMsg));
            Assert.assertEquals(ContactForm.errorMsg.getText(),"There is 1 error\n" + "Invalid email address.");

        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError(e.toString());
        }
    }

    @Test
    public void CTC04_Send_Form_Without_Order_Reference() {
        //This validation consists of submitting the form without the Order Reference.
        try {

            ContactFormLocators ContactForm = new ContactFormLocators(driver);

            ContactForm.fromDropdownList(ContactForm.subjectDD).selectByIndex(1);
            ContactForm.emailBox.sendKeys("Test@test.com");
            ContactForm.fileUpload.sendKeys(testFile);
            ContactForm.messageBox.sendKeys("This is a test, don't you agree JPP?");
            ContactForm.submitBtn.click();
            ContactForm.waitForScreenToLoad((ContactForm.errorMsg));
            Assert.assertEquals(ContactForm.errorMsg.getText(),"There is 1 error\n" + "Missing Order Reference.");

        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError(e.toString());
        }
    }


    @Test
    public void CTC05_Send_Form_Without_Attachment() {
        //This validation consists of submitting the form without an attachment.
        try {

            ContactFormLocators ContactForm = new ContactFormLocators(driver);

            ContactForm.fromDropdownList(ContactForm.subjectDD).selectByIndex(1);
            ContactForm.emailBox.sendKeys("test@test.com");
            ContactForm.orderRefBox.sendKeys("Test Reference");
            ContactForm.submitBtn.click();
            ContactForm.waitForScreenToLoad(ContactForm.errorMsg);
            Assert.assertEquals(ContactForm.errorMsg.getText(), "There is 1 error\n" + "An attachment is required for the form to be sent.");

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }

    }

    @Test
    public void CTC06_Send_Form_Without_Message() {
        //This validation consists of submitting the form without a message.
        try {

            ContactFormLocators ContactForm = new ContactFormLocators(driver);

            ContactForm.fromDropdownList(ContactForm.subjectDD).selectByIndex(1);
            ContactForm.emailBox.sendKeys("test@test.com");
            ContactForm.orderRefBox.sendKeys("Test Reference");
            ContactForm.fileUpload.sendKeys(testFile);
            ContactForm.submitBtn.click();
            ContactForm.waitForScreenToLoad(ContactForm.errorMsg);
            Assert.assertEquals(ContactForm.errorMsg.getText(), "There is 1 error\n" + "A message is required for the form to be sent.");

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }

    }


    @Test
    public void CTC07_Verify_Form() {
        //This validation consists of submitting all the required fields, the expected result being that it succeeds and takes the user to the success page.
        try {

            ContactFormLocators ContactForm = new ContactFormLocators(driver);

            ContactForm.fromDropdownList(ContactForm.subjectDD).selectByIndex(1);
            ContactForm.emailBox.sendKeys("test@test.com");
            ContactForm.orderRefBox.sendKeys("Test Reference");
            ContactForm.fileUpload.sendKeys(testFile);
            ContactForm.messageBox.sendKeys("This is a test");
            ContactForm.submitBtn.click();
            Assert.assertEquals(ContactForm.successMsg.getText(), "Your message has been successfully sent to our team.");

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }

    }



}
