package scenario;

import driverManager.BaseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageRepository.HomepageScreen;
import pageRepository.RegisterScreen;

public class RegisterInvalidOtp extends BaseTest {

    @Test
    @Parameters({"phonemail", "otp"})
    public void registerInvalidOtp(String phonemail, String otp) {
        HomepageScreen homepageScreen = new HomepageScreen(driver);
        RegisterScreen registerScreen = new RegisterScreen(driver);

        homepageScreen.goTo();
        homepageScreen.clickDaftarHome();

        registerScreen.inputDatatoRegis(phonemail);
        registerScreen.clickDaftar();
        registerScreen.isConfirmationModalAppear();
        registerScreen.confirmYesModal();
        registerScreen.inputOtp(otp);
        registerScreen.clickVerifikasi();
        registerScreen.assertErrorOtp();
    }
}
