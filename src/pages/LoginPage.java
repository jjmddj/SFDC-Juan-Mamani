package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Juan Mamani on 10/08/2015.
 */
public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "username")
    private WebElement emailTxt;

    @FindBy(id = "password")
    private WebElement passwordTxt;

    @FindBy(id = "Login")
    private WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        try {
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            driver.switchTo().defaultContent();
        }
        PageFactory.initElements(driver, this);
    }

    public LoginPage setEmailTxt(String email) {
        try {
            wait.until(ExpectedConditions.visibilityOf(emailTxt));
            emailTxt.clear();
            emailTxt.sendKeys(email);
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            driver.switchTo().defaultContent();
        }
        return this;
    }

    public LoginPage setPasswordTxt(String password) {
        try {
            passwordTxt.clear();
            passwordTxt.sendKeys(password);
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            driver.switchTo().defaultContent();
        }
        return this;
    }

    public MainApp clickLoginBtn() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
            loginBtn.click();
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            driver.switchTo().defaultContent();
        }
        return new MainApp(driver);
    }
}
