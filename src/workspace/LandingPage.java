package workspace;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends AbstractComponent{
    public WebDriver driver;

    // Constructor
    public LandingPage(WebDriver driver) {
    	super(driver); 
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    
    @FindBy(id = "userEmail")
     WebElement userEmail;

    @FindBy(css = "#userPassword")
     WebElement userPassword;

    @FindBy(id = "login")
     WebElement submit;
    
    public ProductCatalog LoginApplication(String email, String password) {
        userEmail.sendKeys(email);
        userPassword.sendKeys(password);
        submit.click();
        ProductCatalog productCatalog = new ProductCatalog(driver);
        return productCatalog ;
    }
    
    
    public void Goto() {
    	driver.get("https://rahulshettyacademy.com/client");
    }
}


