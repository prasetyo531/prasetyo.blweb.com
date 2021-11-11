package scenario;

import driverManager.BaseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageRepository.HomepageScreen;

public class SearchProduct extends BaseTest {

    @Test
    @Parameters({"search"})
    public void addToCart(String search) {
        HomepageScreen homepageScreen = new HomepageScreen(driver);

        homepageScreen.goToAddCookie();
        homepageScreen.inputSearch(search);
        homepageScreen.waitClickSearchResult();
    }
}
