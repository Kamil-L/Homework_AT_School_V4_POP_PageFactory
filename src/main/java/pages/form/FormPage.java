package pages.form;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;

import java.io.File;
import java.util.List;
import java.util.Random;

public class FormPage extends BasePage {

    public FormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#inputFirstName3")
    private WebElement firstName;

    @FindBy(css = "#inputLastName3")
    private WebElement lastName;

    @FindBy(css = "#inputEmail3")
    private WebElement email;

    @FindBy(name = "gridRadiosSex")
    private List<WebElement> sex;

    @FindBy(css = "#inputAge3")
    private WebElement age;

    @FindBy(name = "gridRadiosExperience")
    private List<WebElement> yearsOfExperience;

    @FindBy(name = "gridCheckboxProfession")
    private List<WebElement> professionsCheckboxes;

    @FindBy(id = "selectContinents")
    private WebElement continents;

    @FindBy(id = "selectSeleniumCommands")
    private WebElement seleniumCommands;

    @FindBy(id = "chooseFile")
    private WebElement fileToUpload;

    @FindBy(css = ".btn-primary")
    private WebElement submitFormButton;

    @FindBy(css = "#validator-message")
    private WebElement validationMessage;


    public void setFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        this.lastName.sendKeys(lastName);
    }


    public void setEmail(String email) {
        this.email.sendKeys(email);
    }

    public void selectRandomSex() {
        getRandomElement(sex).click();
    }

    public void setAge(String age) {
        this.age.sendKeys(age);
    }

    public void selectRandomYearOfExperience() {
        getRandomElement(yearsOfExperience).click();
    }

    public void selectProfession(String profession) {
        for (int i = 0; i < professionsCheckboxes.size(); i++) {
            String val = professionsCheckboxes.get(i).getAttribute("id");
            if (val.equalsIgnoreCase(profession)) {
                professionsCheckboxes.get(i).click();
                break;
            }
        }
    }

    public void selectRandomContinent() {
        Select dropdown = new Select(continents);
        List<WebElement> continentsOptions = dropdown.getOptions();
        Random rand = new Random();
        int index = rand.nextInt(continentsOptions.size());
        dropdown.selectByIndex(index);
    }


    public void selectSeleniumCommand(String firstSelCommand, String secondSelCommand) {
        Select select = new Select(seleniumCommands);
        select.deselectAll();
        select.selectByValue(firstSelCommand);
        select.selectByValue(secondSelCommand);

    }

    public void uploadFile(String filePath) {
        File file = new File(filePath);
        fileToUpload.sendKeys(file.getAbsolutePath());
    }

    public void sendForm() {
        submitFormButton.click();
    }

    public String getValidationMessage() {
        return validationMessage.getText();
    }

}
