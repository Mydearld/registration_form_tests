import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class TextBoxTests extends TestsBase {

    @Test
    void successAllTextFieldsPopulation() {

        open("/text-box");
        $("input[id=userName]").setValue("John Smith");
        $("input[id=userEmail]").setValue("johnsmith@mail.com");
        $("[id=currentAddress]").setValue("Test Address");
        $("[id=permanentAddress]").setValue("Test Address");
        executeJavaScript("window.scrollTo(0, document.body.scrollHeight);");
        $("button[id=submit]").click();

        $("[id=output] [id=name]").shouldHave(text("John Smith"));
        $("[id=output] [id=email]").shouldHave(text("johnsmith@mail.com"));
        $("[id=output] [id=currentAddress]").shouldHave(text("Test Address"));
        $("[id=output] [id=permanentAddress]").shouldHave(text("Test Address"));

    }

    @Test
    void emptyTextFieldsPopulation() {

        open("/text-box");
        executeJavaScript("window.scrollTo(0, document.body.scrollHeight);");
        $("button[id=submit]").click();

        $("[id=output]").shouldNotBe(visible);

    }
}
