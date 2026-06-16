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
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Jane Smith"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("janesmith@mail.com"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Female"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("8909678545"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("15 March,1990"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Test Subject"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Music"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("my_png.png"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Current Address"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("Haryana Karnal"));

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
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Rob Robin"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("8909678545"));

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
