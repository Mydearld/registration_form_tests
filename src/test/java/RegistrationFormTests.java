import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTests extends TestsBase {

      @Test
      void successAllRegistrationFormFieldsPopulation() {

        File myFile = new File("src/test/resources/my_png.png");

        open("/automation-practice-form");
        $("input[id=firstName]").setValue("Jane");
        $("input[id=lastName]").setValue("Smith");
        $("input[id=userEmail]").setValue("janesmith@mail.com");
        $("input[value=Female]").click();
        $("input[id=userNumber]").setValue("8909678545");
        $("input[id=dateOfBirthInput]").click();
        $("[class=react-datepicker__month-select]").selectOption("March");
        $("[class=react-datepicker__year-select]").selectOptionByValue("1990");
        $x("//div[text()='15']").click();
        $("input[id=subjectsInput]").setValue("Test Subject");
        $("input[id=hobbies-checkbox-3]").click();
        $("input[id=uploadPicture]").uploadFile(myFile);
        $("[id=currentAddress]").setValue("Current Address");
        executeJavaScript("window.scrollTo(0, document.body.scrollHeight);");
        $("[id=state]").click();
        $("input[id=react-select-3-input]").setValue("Haryana").pressEnter();
        $("input[id=react-select-4-input]").setValue("Karnal").pressEnter();
        $("button[id=submit]").click();

        $("[id=example-modal-sizes-title-lg]").shouldHave(text("Thanks for submitting the form"));

    }

      @Test
      void requiredFieldsFormFieldsPopulation() {

        open("/automation-practice-form");
        $("input[id=firstName]").setValue("Rob");
        $("input[id=lastName]").setValue("Robin");
        $("input[value=Male]").click();
        $("input[id=userNumber]").setValue("8909678545");
        executeJavaScript("window.scrollTo(0, document.body.scrollHeight);");
        $("button[id=submit]").click();

        $("[id=example-modal-sizes-title-lg]").shouldHave(text("Thanks for submitting the form"));

      }

      @Test
      void submittingEmptyFormFields() {

        open("/automation-practice-form");
        executeJavaScript("window.scrollTo(0, document.body.scrollHeight);");
        $("button[id=submit]").click();

        $("[id=example-modal-sizes-title-lg]").shouldNotBe(visible);

      }

      @Test
      void submittIngncorrectEmailFormat() {

        open("/automation-practice-form");
        $("input[id=firstName]").setValue("Jane");
        $("input[id=lastName]").setValue("Smith");
        $("input[id=userEmail]").setValue("почта");
        $("input[value=Female]").click();
        $("input[id=userNumber]").setValue("8909678545");
        $("input[id=dateOfBirthInput]").click();
        $("[class=react-datepicker__month-select]").selectOption("March");
        $("[class=react-datepicker__year-select]").selectOptionByValue("1990");
        $x("//div[text()='15']").click();
        executeJavaScript("window.scrollTo(0, document.body.scrollHeight);");
        $("button[id=submit]").click();

        $("[id=example-modal-sizes-title-lg]").shouldNotBe(visible);

      }
}
