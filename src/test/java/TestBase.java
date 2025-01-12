import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize= "1920x1080";
        Configuration.baseUrl = "https://www.ozon.ru/";
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
            }

    @AfterEach
    void closeWebDriver() {
        Selenide.closeWebDriver();
    }
}
