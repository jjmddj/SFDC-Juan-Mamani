package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Juan Mamani on 10/08/2015.
 */
public class MainApp {

    private WebDriver driver;
    private WebDriverWait wait;

    public MainApp(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }

    public TopMenu goToLeftMenu() {
        return new TopMenu(driver);
    }
}
