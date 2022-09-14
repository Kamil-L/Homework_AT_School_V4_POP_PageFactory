import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.form.FormPage;

import static org.assertj.core.api.Assertions.assertThat;

public class FormTest extends BaseTest {


    @Test
    @DisplayName("2.0 Filling out the form")
    @Tag("basic")
    @Tag("form")
    @Tag("pop")
    void shouldFillFormWithSuccess() {

        driver.get("https://seleniumui.moderntester.pl/form.php");
        String formSubmitMessageExpected = "Form send with success";

        FormPage formPage = new FormPage(driver);

        formPage.setFirstName("Jan");
        formPage.setLastName("Kowalski");
        formPage.setEmail("jan.kowalski@email.com");
        formPage.selectRandomSex();
        formPage.setAge("22");
        formPage.selectRandomYearOfExperience();
        formPage.selectProfession("gridCheckAutomationTester");
        formPage.selectRandomContinent();
        formPage.selectSeleniumCommand("switch-commands", "wait-commands");
        formPage.uploadFile("src/main/resources/test_file.txt");
        formPage.sendForm();

        assertThat(formPage.getValidationMessage()).isEqualTo(formSubmitMessageExpected);

    }
}