package pageRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetail extends ActionBase {

    @FindBy(xpath ="//button[@class='c-main-product__action__buy bl-button bl-button--primary bl-button--medium']")
    public WebElement beliSekarangBtn;

    @FindBy(xpath ="//button[@class='c-main-product__action__cart bl-button bl-button--outline bl-button--medium']")
    public WebElement addToCartBtn;

    @FindBy(xpath ="//div[@class='c-dialog__content']")
    public WebElement keranjangModal;

    public ProductDetail(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public ProductDetail verifyProductDetail() {
        try {
            waitUntilWebElementIsVisible(beliSekarangBtn);
            waitUntilWebElementIsVisible(addToCartBtn);
        } catch (Exception e) {
            e.getMessage();
        }
        return new ProductDetail(driver);
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

    public ProductDetail clickBeli() {
        try {
            waitAndClickElement(beliSekarangBtn);
        } catch (Exception e) {
            e.getMessage();
        }
        return new ProductDetail(driver);
    }

    public ProductDetail clickAddToCart() {
        try {
            waitAndClickElement(addToCartBtn);
            waitUntilWebElementIsVisible(keranjangModal);
            Thread.sleep(5000);
        } catch (Exception e) {
            e.getMessage();
        }
        return new ProductDetail(driver);
    }
}
