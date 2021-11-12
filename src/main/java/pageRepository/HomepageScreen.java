package pageRepository;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HomepageScreen extends ActionBase {

    //descendants
    @FindBy(xpath =".bl-flex-container>.bl-flex-item:nth-child(2)>.bl-flex-container.align-items-center>:nth-child(1)")
    public WebElement daftarBtn;

    //@FindBy(xpath ="//*[@id='vm__white-header-dweb']//descendant::a[123]")
    @FindBy(xpath =".bl-flex-container>.bl-flex-item:nth-child(2)>.bl-flex-container.align-items-center>:nth-child(2)")
    public WebElement loginBtn;

    @FindBy(id ="v-omnisearch__input")
    public WebElement searchBar;

    @FindBy(xpath ="//button[@title='Cari']")
    public WebElement submitSearchBar;

    @FindBy(xpath ="//div[@class='v-omnisearch__results_container']")
    public WebElement searchSuggestion;

    @FindBy(xpath ="(//div[@class='bl-product-card__thumbnail'])[1]")
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

    public HomepageScreen goToAddCookie(){
        this.driver.get("https://bukalapak.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Cookie loginCookie = new Cookie("user_credentials", "0d9e1015cd658b778b02b8d0ba53cd590b1d0d11194c235f2f134e76df219f9671dcabf9463ec9e5ff2017403fd2361c6e66fbc9fda8ca4ba69e7042e2bed065%3A%3A47339297%3A%3A2022-02-10T22%3A07%3A43%2B07%3A00");
        driver.manage().addCookie(loginCookie);
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
            waitUntilWebElementIsVisible(searchSuggestion);
            waitAndClickElement(submitSearchBar);
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
