package workspace;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import org.openqa.selenium.WebElement;

public class SeleniumTest extends baseTest {
	@Test
	public void SubmitOrder() throws InterruptedException, IOException {
		String productName = "ZARA COAT 3";
		LandingPage landingPage = launchApplication();
		ProductCatalog productCatalog = landingPage.LoginApplication("webtesting.sania@gmail.com", "Sania123");
		List<WebElement> products = productCatalog.getProductList();
		productCatalog.addProductToCart(productName);
		Cartpage Cartpage = productCatalog.goToCartPage();
		boolean match = Cartpage.VerifyProductDisplay(productName);
		Assert.assertTrue(match, "The product " + productName + " was not found in the cart.");
		CheckoutPage CheckoutPage = Cartpage.goToCheckOut();
		CheckoutPage.selectCountry("india");
		ConfirmationPage ConfirmationPage = CheckoutPage.Submitorder();
		String ConfirmationMessage = ConfirmationPage.getConfirmationMessage();
		Assert.assertTrue(ConfirmationMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}

}
