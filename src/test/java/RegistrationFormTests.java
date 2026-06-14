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
        $("input[id=subjectsInput]").setValue("Test Subject");
        $("input[id=hobbies-checkbox-3]").click();
        $("input[id=uploadPicture]").uploadFile(myFile);
        $("[id=currentAddress]").setValue("Test Subject");
        //$("[id=state]").selectOption(3);
        /*$("id=city").selectOption("Karnal");*/
        $("button[id=submit]").click();

      $("[id=example-modal-sizes-title-lg]").shouldHave(text("Thanks for submitting the form"));

    }
}
