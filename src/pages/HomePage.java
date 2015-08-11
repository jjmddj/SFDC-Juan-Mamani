package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Juan Mamani on 10/08/2015.
 */
public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl;

    @FindBy(linkText = "Login")
    private WebElement loginBtn;

    public HomePage() {
        driver = new FirefoxDriver();
        baseUrl = "https://login.salesforce.com/";
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 15);
        driver.get(baseUrl);
        PageFactory.initElements(driver, this);
    }

    public LoginPage clickLoginBtn() {
        return new LoginPage(driver);
    }
}
