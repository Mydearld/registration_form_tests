import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestsBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.timeout = 10000;
    }
}
