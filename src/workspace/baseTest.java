package workspace;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class baseTest {
	public WebDriver driver;
	
	 public WebDriver initializeDriver() throws IOException {
		 Properties prop = new Properties();

	        // Load the properties file using FileInputStream
		 FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\workspace2\\gobalData.properties");

	        // Load the properties into the prop object
	        prop.load(fis);
	    String browsername = prop.getProperty("browser");
	    if (browsername.equalsIgnoreCase("chrome")) {
	    	   driver = new ChromeDriver();
        } else if (browsername.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else if (browsername.equalsIgnoreCase("firefox")) {
        	 driver = new FirefoxDriver();
        }
	        
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			return driver;
	 }
	 public  LandingPage launchApplication() throws IOException {
	        // Initialize the driver
	        driver = initializeDriver();
	        LandingPage landingPage = new LandingPage(driver);
			landingPage.Goto();
            return landingPage;
}
}