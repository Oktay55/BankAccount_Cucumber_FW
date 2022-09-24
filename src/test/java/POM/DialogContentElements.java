package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class DialogContentElements extends BasePOM{

    public DialogContentElements() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//ms-add-button[@tooltip='BANK_ACCOUNT.TITLE.ADD']//button")
    private WebElement addButton;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='name']//input")
    private WebElement nameInput;

    @FindBy(xpath = "//ms-text-field[@placeholder='GENERAL.FIELD.NAME']//input")
    private WebElement searchName;

    @FindBy(xpath = "//span[text()='Search']")
    private WebElement searchButton;

    @FindBy(xpath = "//ms-edit-button[@class='ng-star-inserted']")
    private WebElement editButton;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='name']")
    private WebElement searchName2;

    @FindBy(xpath = "//ms-masked-text-field[@formcontrolname='iban']//input")
    private WebElement ibanInput;

    @FindBy(xpath = "//ms-delete-button[@class='ng-star-inserted']")
    private WebElement deleteButton;

    @FindBy(xpath = "(//div[@class='ng-star-inserted']//button)[2]")
    private WebElement deleteButton2;

    @FindBy(xpath = "(//mat-select[@role='combobox'])[3]")
    private WebElement currencyInputDropdown;

    @FindBy(xpath = "//span[text()=' USD '] ")
    private WebElement currencyUsd;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='integrationCode']//input")
    private WebElement integrationCodeInput;

    @FindBy(xpath = "//ms-save-button[@class='ng-star-inserted']")
    private WebElement saveButton;

    @FindBy(xpath = "//div[contains(text(), 'successfully')]")
    private WebElement successMessage;

    @FindBy(xpath = "//div[contains(text(), 'already exists.')]")
    private WebElement unsuccessfulMessage;

    @FindBy(xpath = "//div[text()=' There is no data to display ']")
    private WebElement noDataMessage;

    public void userCreateBankAccount(String name, String iban, String currency, String integrationCode) {
        addButton.click();
        nameInput.sendKeys(name);
        ibanInput.sendKeys(iban);
        currencyInputDropdown.click();
        switch (currency) {
            case "USD":
                currencyUsd.click();
                break;
        }
        integrationCodeInput.sendKeys(integrationCode);
        saveButton.click();
    }
    public void validateCreateSuccessMessage() {
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        Assert.assertTrue(successMessage.getText().contains("success".toLowerCase()));
    }
    public void validateUnsuccessfulMessage() {
        wait.until(ExpectedConditions.visibilityOf(unsuccessfulMessage));
        Assert.assertTrue(unsuccessfulMessage.getText().contains("already exists.".toLowerCase()));
    }

    public void searchNameAndClickSearch(String name) {
        searchName.sendKeys(name);
        searchButton.click();

    }
    public void editBankAccountName(String newName) {
        waitUntilVisibleAndClickableThenClick(editButton);
        nameInput.clear();
        nameInput.sendKeys(newName);
        saveButton.click();
    }
    public void editSuccessMessage() {
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        Assert.assertTrue(successMessage.getText().contains("success".toLowerCase()));

    }

    public void searchNameToDelete(String name) {
        searchName.sendKeys(name);
        searchButton.click();
    }
    public void deleteBankAccountName() {
        deleteButton.click();
        deleteButton2.click();
    }

    public void deleteSuccessMessage() {
        Assert.assertTrue(successMessage.getText().contains("success".toLowerCase()));
    }

    public void searchDeletedData(String name) {
        searchName.sendKeys(name);
        searchButton.click();


    }
    public void noDataMessage() {
        wait.until(ExpectedConditions.visibilityOf(noDataMessage));
        Assert.assertTrue(noDataMessage.getText().contains("no data".toLowerCase()));

    }

}






