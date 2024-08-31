package workspace;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AbstractComponent {
	protected WebDriver driver;

	// Constructor
	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = "[routerlink='/dashboard/cart']")
	WebElement cartHeader;

	// Method to wait for an element to appear
	public void waitForElementToAppear(By findBy) {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public Cartpage goToCartPage() {
		cartHeader.click();
		Cartpage Cartpage = new Cartpage(driver);
		return Cartpage;
	}

	public void waitForElementToDisappear(WebElement ele) throws InterruptedException {
		//Thread.sleep(1000);
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.invisibilityOf(ele));

	}
}
