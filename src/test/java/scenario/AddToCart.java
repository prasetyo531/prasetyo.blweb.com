package scenario;

import driverManager.BaseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageRepository.HomepageScreen;
import pageRepository.ProductDetail;

public class AddToCart extends BaseTest {

    @Test
    @Parameters({"search"})
    public void addToCart(String search) {
        HomepageScreen homepageScreen = new HomepageScreen(driver);
        ProductDetail productDetailScreen = new ProductDetail(driver);

        homepageScreen.goToAddCookie();
        homepageScreen.inputSearch(search);
        homepageScreen.waitClickSearchResult();

        productDetailScreen.verifyProductDetail();
        productDetailScreen.clickAddToCart();
    }
}
