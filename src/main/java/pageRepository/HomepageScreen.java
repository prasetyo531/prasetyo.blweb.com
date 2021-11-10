package pageRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HomepageScreen extends ActionBase {

    //descendants
    @FindBy(xpath ="//*[@id='vm__white-header-dweb']//descendant::a[122]")
    public WebElement daftarBtn;

    @FindBy(xpath ="//*[@id='vm__white-header-dweb']//descendant::a[123]")
    public WebElement loginBtn;

    @FindBy(id ="v-omnisearch__input")
    public WebElement searchBar;

    @FindBy(xpath ="((//img[@class='bl-thumbnail--img'])[1]")
    public WebElement firstIndexSearchResult;

    public HomepageScreen(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public HomepageScreen goTo(){
        this.driver.get("https://bukalapak.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //continue interacting with the application.
        return new HomepageScreen(driver);
    }

    public HomepageScreen clickDaftarHome() {
        try {
            waitAndClickElement(daftarBtn);
            waitForContainsUrl("https://accounts.bukalapak.com/register?");
        } catch (Exception e) {
            e.getMessage();
        }
        return new HomepageScreen(driver);
    }

    public HomepageScreen clickLoginHome() {
        try {
            waitAndClickElement(loginBtn);
            waitForContainsUrl("https://accounts.bukalapak.com/login?");
        } catch (Exception e) {
            e.getMessage();
        }
        return new HomepageScreen(driver);
    }

    public HomepageScreen inputSearch(String keyword) {
        try {
            waitUntilWebElementIsVisible(searchBar);
            waitAndClickElement(searchBar);
            sendKeysToWebElement(searchBar, keyword);
        } catch (Exception e) {
            e.getMessage();
        }
        return new HomepageScreen(driver);
    }

    public HomepageScreen waitClickSearchResult() {
        try {
            waitForContainsUrl("https://www.bukalapak.com/products?from=omnisearch&from_keyword_history=false&search%5Bkeywords%5D=");
            waitAndClickElement(firstIndexSearchResult);
        } catch (Exception e) {
            e.getMessage();
        }
        return new HomepageScreen(driver);
    }
}
