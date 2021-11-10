package pageRepository;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterScreen extends ActionBase {

    //Self
    @FindBy(xpath ="//*[@type='text']//self::input")
    public WebElement handphoneEmailField;

    @FindBy(xpath ="//button[@class='bl-button bl-button--primary bl-button--medium bl-button--block']")
    public WebElement daftarButton;

    @FindBy(xpath ="//div[@class='bl-modal__wrapper']")
    public WebElement registerConfirmationModal;

    @FindBy(xpath ="//button[@class='mb-8 bl-button bl-button--primary bl-button--medium bl-button--block']")
    public WebElement yaKirimCode;

    //following
    @FindBy(xpath ="//*[@type='text']//following::input")
    public WebElement otpField;

    //following
    @FindBy(xpath ="//button[@class='bl-button bl-button--primary bl-button--medium bl-button--block'][2]")
    public WebElement verifikasiBtn;

    @FindBy(xpath ="//p[@class='bl-text bl-text--caption bl-text--error']")
    public WebElement otpMsgLbl;

    public RegisterScreen(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public RegisterScreen inputDatatoRegis(String phonemail) {
        try {
            WaitUntilWebElementIsVisible(handphoneEmailField);
            sendKeysToWebElement(handphoneEmailField, phonemail);
        } catch (Exception e) {
            e.getMessage();
        }
        return new RegisterScreen(driver);
    }

    public RegisterScreen clickDaftar() {
        try {
            waitAndClickElement(daftarButton);
            waitForContainsUrl("https://accounts.bukalapak.com/login?");
        } catch (Exception e) {
            e.getMessage();
        }
        return new RegisterScreen(driver);
    }

    public RegisterScreen isConfirmationModalAppear() {
        try {
            WaitUntilWebElementIsVisible(registerConfirmationModal);
        } catch (Exception e) {
            e.getMessage();
        }
        return new RegisterScreen(driver);
    }

    public RegisterScreen confirmYesModal() {
        try {
            waitAndClickElement(yaKirimCode);
        } catch (Exception e) {
            e.getMessage();
        }
        return new RegisterScreen(driver);
    }

    public RegisterScreen inputOtp(String otp) {
        try {
            WaitUntilWebElementIsVisible(otpField);
            sendKeysToWebElement(otpField, otp);
        } catch (Exception e) {
            e.getMessage();
        }
        return new RegisterScreen(driver);
    }

    public RegisterScreen clickVerifikasi() {
        try {
           waitAndClickElement(verifikasiBtn);
        } catch (Exception e) {
            e.getMessage();
        }
        return new RegisterScreen(driver);
    }

    public RegisterScreen assertErrorOtp() {
        try {
            WaitUntilWebElementIsVisible(otpMsgLbl);
            String = otpMsgLbl.getText();
            Assert.assertEquals("Kode rahasia tidak sesuai", String);
        } catch (Exception e) {
            e.getMessage();
        }
        return new RegisterScreen(driver);
    }
}
