package pageRepository;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginScreen extends ActionBase {

    //Self
    @FindBy(id ="user_identity_textfield")
    public WebElement handphoneEmailField;

    @FindBy(id ="submit_button")
    public WebElement lanjutButton;

    @FindBy(xpath ="//div[@class='bl-modal__wrapper']")
    public WebElement loginConfirmationModal;

    @FindBy(xpath ="//*[@type='text']//following::input")
    public WebElement otpField;

    //following
    @FindBy(xpath ="//button[@class='bl-button bl-button--primary bl-button--medium bl-button--block']")
    public WebElement verifikasiBtn;

    @FindBy(xpath ="//p[@class='bl-text bl-text--caption bl-text--error']")
    public WebElement otpMsgLbl;

    public LoginScreen(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public LoginScreen inputDatatoLogin(String phonemail) {
        try {
            waitUntilWebElementIsVisible(handphoneEmailField);
            sendKeysToWebElement(handphoneEmailField, phonemail);
        } catch (Exception e) {
            e.getMessage();
        }
        return new LoginScreen(driver);
    }

    public LoginScreen clickLanjut() {
        try {
            waitAndClickElement(lanjutButton);
        } catch (Exception e) {
            e.getMessage();
        }
        return new LoginScreen(driver);
    }

    public RegisterScreen isConfirmationModalAppear() {
        try {
            waitUntilWebElementIsVisible(loginConfirmationModal);
        } catch (Exception e) {
            e.getMessage();
        }
        return new RegisterScreen(driver);
    }

    public LoginScreen inputOtp(String otp) {
        try {
            waitUntilWebElementIsVisible(otpField);
            sendKeysToWebElement(otpField, otp);
        } catch (Exception e) {
            e.getMessage();
        }
        return new LoginScreen(driver);
    }

    public LoginScreen clickVerifikasi() {
        try {
            waitAndClickElement(verifikasiBtn);
        } catch (Exception e) {
            e.getMessage();
        }
        return new LoginScreen(driver);
    }

    public LoginScreen assertErrorOtp() {
        try {
            waitUntilWebElementIsVisible(otpMsgLbl);
            String txt = otpMsgLbl.getText();
            Assert.assertEquals("Kode rahasia tidak sesuai", txt);
        } catch (Exception e) {
            e.getMessage();
        }
        return new LoginScreen(driver);
    }
}
