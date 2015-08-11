package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Juan Mamani on 10/08/2015.
 */
public class AddItemForm {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "input[id=acc2]")
    private WebElement accountNameTxt;

    @FindBy(css = "input[id=opp3]")
    private WebElement opportunityNameTxt;

    @FindBy(css = "input[id=opp4]")
    private WebElement AccountNameInOpportunityTxt;

    @FindBy(css = "input[id=opp9]")
    private WebElement closeDateTxt;

    @FindBy(css = "select[id=col0]")
    private WebElement SelectFindAccountName;

    @FindBy(css = "select[id=oper0]")
    private WebElement selectMatch;

    @FindBy(css = "input[id=fval0]")
    private WebElement nameAccountDelete;

    @FindBy(css = "select#opp11")
    private WebElement stageTxt;

    @FindBy(css = "input[name=save]")
    private WebElement saveBtn;

    @FindBy(css = "input[name=find]")
    private WebElement searchBtn;

    @FindBy(css = "tr[class*=last] div[class=delBtns] input")
    private WebElement deleteBtn;

    @FindBy(css = "div[id=opp9_ileinner]")
    private WebElement getgetCloseDateTxt;

    @FindBy(css = "div[id=opp11_ileinner]")
    private WebElement getStateTxt;

    @FindBy(css = "input[name=new]")
    private WebElement addOpportunitie;

    @FindBy(xpath= "//a[text()='Mass Delete Accounts']")
    private WebElement massDeleteAccounts;

    @FindBy(css = "td[class=actionColumn] input")
    private WebElement checkName;


    public AddItemForm(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }

    public AddItemForm clickNewBtn() {
        addOpportunitie.click();
        return this;
    }

    public AddItemForm clickSaveBtn() {
        saveBtn.click();
        return this;
    }

    public AddItemForm clickSearchBtn() {
        searchBtn.click();
        return this;
    }

    public AddItemForm setAccountNameTxt(String account) {
        wait.until(ExpectedConditions
                .visibilityOf(accountNameTxt));
        accountNameTxt.clear();
        accountNameTxt.sendKeys(account);
        return this;
    }

    public AddItemForm setAccountNameInOpportunityTxt(String account) {
        wait.until(ExpectedConditions
                .visibilityOf(AccountNameInOpportunityTxt));
        AccountNameInOpportunityTxt.clear();
        AccountNameInOpportunityTxt.sendKeys(account);
        return this;
    }

    public AddItemForm setOpportunityName(String opportunityName) {
        wait.until(ExpectedConditions
                .visibilityOf(opportunityNameTxt));
        opportunityNameTxt.clear();
        opportunityNameTxt.sendKeys(opportunityName);
        return this;
    }

    public AddItemForm setCloseDate(String closeDate) {
        wait.until(ExpectedConditions.visibilityOf(closeDateTxt));
        closeDateTxt.clear();
        closeDateTxt.sendKeys(closeDate);
        return this;
    }

    public AddItemForm selectStage(String stage) {
        wait.until(ExpectedConditions
                .visibilityOf(stageTxt));
        Select stageSelect = new Select(stageTxt);
        stageSelect.selectByValue(stage);
        return this;
    }

    public String getAccount(String account) {
        return driver.findElement(By.xpath("//span[text()='" + account + "']")).getText();
    }

    public String getAccountNamefromOpportunityDetail(String account) {
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()='" + account + "']"))));
        return driver.findElement(By.xpath("//a[text()='" + account + "']")).getText();
    }

    public String getCloseDate() {
        return getgetCloseDateTxt.getText();
    }

    public String getStage() {
        return getStateTxt.getText();
    }

    public AddItemForm ClickMassDeleteAccountsBtn() {
        massDeleteAccounts.click();
        return this;
    }

    public AddItemForm FindAccountName(String accountName) {
        wait.until(ExpectedConditions
                .visibilityOf(SelectFindAccountName));
        Select stageSelect = new Select(SelectFindAccountName);
        stageSelect.selectByValue(accountName);
        return this;
    }

    public AddItemForm setSelectMatch(String match) {
        wait.until(ExpectedConditions
                .visibilityOf(selectMatch));
        Select stageSelect = new Select(selectMatch);
        stageSelect.selectByValue(match);
        return this;
    }

    public AddItemForm setAccountDelete(String accountName) {
        wait.until(ExpectedConditions
                .visibilityOf(nameAccountDelete));
        nameAccountDelete.sendKeys(accountName);
        return this;
    }

    public AddItemForm CheckaccountNameDelete() {
        checkName.click();
        return this;
    }

    public AddItemForm ClickDeleteBtn() {
        deleteBtn.click();
        return this;
    }
}
