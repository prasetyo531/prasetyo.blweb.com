package scenario;

import driverManager.BaseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageRepository.HomepageScreen;
import pageRepository.LoginScreen;

public class LoginInvalidOtp extends BaseTest {

    @Test
    @Parameters({"phonemail", "otp"})
    public void loginInvalidOtp(String phonemail, String otp) {
        HomepageScreen homepageScreen = new HomepageScreen(driver);
        LoginScreen loginScreen = new LoginScreen(driver);

        homepageScreen.goTo();
        homepageScreen.clickLoginHome();

        loginScreen.inputDatatoLogin(phonemail);
        loginScreen.clickLanjut();
        loginScreen.isConfirmationModalAppear();
        loginScreen.inputOtp(otp);
        loginScreen.clickVerifikasi();
        loginScreen.assertErrorOtp();
    }
}
