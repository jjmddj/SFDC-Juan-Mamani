package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Juan Mamani on 10/08/2015.
 */
public class TopMenu {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "a[title*=Accounts]")
    private WebElement accountsLnk;

    @FindBy(css = "a[title*=Opportunities]")
    private WebElement opportunitiesLnk;

    public TopMenu(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }

    public AddItemForm clickaccountsLnk() {
        accountsLnk.click();
        return new AddItemForm(driver);
    }

    public AddItemForm clickOpportunitiesLnkLnk() {
        opportunitiesLnk.click();
        return new AddItemForm(driver);
    }
}
