package workspace;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Cartpage extends AbstractComponent {
	 public Cartpage (WebDriver driver) {
	    	super(driver); 
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	    
	 @FindBy(css = ".totalRow button")
	    WebElement checkoutEle;
	 @FindBy(css =".cartSection h3" )
	private List<WebElement> productTitles;
	 
	 public Boolean VerifyProductDisplay(String productName) {
		 boolean match =productTitles .stream()
			.anyMatch(cardproduct -> cardproduct.getText().equalsIgnoreCase(productName));
		 return match;
	 }
	 public  CheckoutPage goToCheckOut() {
		 
		 checkoutEle.click();
		 return new CheckoutPage(driver);
	 }
}
