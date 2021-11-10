package pageRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetail extends ActionBase {

    @FindBy(xpath ="//button[@class='c-main-product__action__buy bl-button bl-button--primary bl-button--medium']")
    public WebElement beliSekarangBtn;

    public ProductDetail(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public ProductDetail clickBeliAsGuest() {
        try {
            waitAndClickElement(beliSekarangBtn);
            waitForContainsUrl("product_sku_id");
        } catch (Exception e) {
            e.getMessage();
        }
        return new ProductDetail(driver);
    }

}
