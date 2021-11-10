package pageRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomepageScreen extends ActionBase {

    //descendants
    @FindBy(xpath ="//*[@id='vm__white-header-dweb']//descendant::a[122]")
    public WebElement daftarBtn;

    @FindBy(xpath ="//*[@id='vm__white-header-dweb']//descendant::a[123]")
    public WebElement loginBtn;

    @FindBy(id ="v-omnisearch__input")
    public WebElement searchBar;

    public HomepageScreen(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public HomepageScreen clickDaftar() {
        try {
            waitAndClickElement(daftarBtn);
            waitForContainsUrl("https://accounts.bukalapak.com/register?");
        } catch (Exception e) {
            e.getMessage();
        }
        return new HomepageScreen(driver);
    }

    public HomepageScreen clickLogin() {
        try {
            waitAndClickElement(loginBtn);
            waitForContainsUrl("https://accounts.bukalapak.com/login?");
        } catch (Exception e) {
            e.getMessage();
        }
        return new HomepageScreen(driver);
    }
}
