import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
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
        $x("//div[@class='react-datepicker__day react-datepicker__day--015']").click();
        $("input[id=subjectsInput]").setValue("Test Subject");
        $("input[id=hobbies-checkbox-3]").click();
        $("input[id=uploadPicture]").uploadFile(myFile);
        $("[id=currentAddress]").setValue("Test Subject");
        executeJavaScript("window.scrollBy(0, -500);");
        $("[id=state]").click();
        $("[input[id=react-select-3-input]").setValue("Haryana").pressEnter();
      // $("[id=city]").selectOption("Karnal");
      //  $("[id=city]").click();
        $("button[id=submit]").click();

      $("[id=example-modal-sizes-title-lg]").shouldHave(text("Thanks for submitting the form"));

    }
}
