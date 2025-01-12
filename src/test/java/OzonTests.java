import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class OzonTests extends TestBase{
@Tag("High")
@Tag("Smoke")
@CsvSource({
        "брюки",
        "кофта"
})
@ParameterizedTest (name = "Проверка поиска по слову {0}")
void checkSearchOzon(String clothes){
    open("https://www.wildberries.ru/");
    Configuration.pageLoadStrategy = "eager";
    Configuration.browserSize= "1920x1080";
    $("#searchInput").setValue(clothes);
    $("#applySearchBtn").click();
    $("#mainContainer").shouldHave(text(clothes));
}

    @Tag("High")
    @Tag("Smoke")
    @ParameterizedTest (name = "Проверка валюты в виджете {0}")
    void checkСurrencyOnStartPage(String clothes){
}
