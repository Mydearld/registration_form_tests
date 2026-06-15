import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTests extends TestsBase {

      @Test
      void successAllRegistrationFormFieldsPopulation() {

        open("/automation-practice-form");
        executeJavaScript("""
                                 document.getElementById('fixedban')?.remove();
                                 document.querySelector('footer')?.remove();
                           """);
        $("input[id=firstName]").setValue("Jane");
        $("input[id=lastName]").setValue("Smith");
        $("input[id=userEmail]").setValue("janesmith@mail.com");
        $("[id=genterWrapper]").find(byText("Female")).click();
        $("input[id=userNumber]").setValue("8909678545");
        $("input[id=dateOfBirthInput]").click();
        $("[class=react-datepicker__month-select]").selectOption("March");
        $("[class=react-datepicker__year-select]").selectOptionByValue("1990");
        $x("//div[text()='15']").click();
        $("input[id=subjectsInput]").setValue("Test Subject");
        $("[id=hobbiesWrapper]").find(byText("Music")).click();
        $("input[id=uploadPicture]").uploadFromClasspath("my_png.png");
        $("[id=currentAddress]").setValue("Current Address");
        $("[id=state]").click();
        $("input[id=react-select-3-input]").setValue("Haryana").pressEnter();
        $("input[id=react-select-4-input]").setValue("Karnal").pressEnter();
        $("button[id=submit]").click();

        $("[id=example-modal-sizes-title-lg]").shouldHave(text("Thanks for submitting the form"));
        $x("//div[@class='table-responsive']").shouldHave(text("Student Name Jane Smith"));
        $x("//div[@class='table-responsive']").shouldHave(text("Student Email janesmith@mail.com"));
        $x("//div[@class='table-responsive']").shouldHave(text("Gender Female"));
        $x("//div[@class='table-responsive']").shouldHave(text("Mobile 8909678545"));
        $x("//div[@class='table-responsive']").shouldHave(text("Date of Birth 15 March,1990"));
        $x("//div[@class='table-responsive']").shouldHave(text("Subjects Test Subject"));
        $x("//div[@class='table-responsive']").shouldHave(text("Hobbies Music"));
        $x("//div[@class='table-responsive']").shouldHave(text("Picture my_png.png"));
        $x("//div[@class='table-responsive']").shouldHave(text("Address Current Address"));
        $x("//div[@class='table-responsive']").shouldHave(text("State and City Haryana Karnal"));

    }

      @Test
      void requiredFieldsFormFieldsPopulation() {

        open("/automation-practice-form");
        executeJavaScript("""
                                 document.getElementById('fixedban')?.remove();
                                 document.querySelector('footer')?.remove();
                           """);
        $("input[id=firstName]").setValue("Rob");
        $("input[id=lastName]").setValue("Robin");
        $("[id=genterWrapper]").find(byText("Male")).click();
        $("input[id=userNumber]").setValue("8909678545");
        $("button[id=submit]").click();

        $("[id=example-modal-sizes-title-lg]").shouldHave(text("Thanks for submitting the form"));
        $x("//div[@class='table-responsive']").shouldHave(text("Student Name Rob Robin"));
        $x("//div[@class='table-responsive']").shouldHave(text("Gender Male"));
        $x("//div[@class='table-responsive']").shouldHave(text("Mobile 8909678545"));

      }

      @Test
      void submittingEmptyFormFields() {

        open("/automation-practice-form");
        executeJavaScript("""
                                 document.getElementById('fixedban')?.remove();
                                 document.querySelector('footer')?.remove();
                           """);
        $("button[id=submit]").click();

        $("[id=example-modal-sizes-title-lg]").shouldNotBe(visible);

      }

      @Test
      void submittIngncorrectEmailFormat() {

        open("/automation-practice-form");
        executeJavaScript("""
                                 document.getElementById('fixedban')?.remove();
                                 document.querySelector('footer')?.remove();
                           """);
        $("input[id=firstName]").setValue("Jane");
        $("input[id=lastName]").setValue("Smith");
        $("input[id=userEmail]").setValue("почта");
        $("[id=genterWrapper]").find(byText("Female")).click();
        $("input[id=userNumber]").setValue("8909678545");
        $("input[id=dateOfBirthInput]").click();
        $("[class=react-datepicker__month-select]").selectOption("March");
        $("[class=react-datepicker__year-select]").selectOptionByValue("1990");
        $x("//div[text()='15']").click();
        $("button[id=submit]").click();

        $("[id=example-modal-sizes-title-lg]").shouldNotBe(visible);

      }
}
