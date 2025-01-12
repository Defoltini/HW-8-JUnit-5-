import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class WBTests extends TestBase{
    @Tag("High")
    @Tag("Smoke")
    @CsvSource({
            "брюки",
            "кофта"
    })
    @ParameterizedTest (name = "Проверка поиска по слову {0}")
    void checkSearchWB(String clothes){
        open("https://www.wildberries.ru/");
        $("#searchInput").setValue(clothes);
        $("#applySearchBtn").click();
        $("#mainContainer").shouldHave(text(clothes));
    }
    @EnumSource(Currency.class)
    @Tag("High")
    @Tag("Smoke")
    @ParameterizedTest
    void checkСurrencyOnStartPage(Currency currency){
        open("https://www.wildberries.ru/");

        $(".header__wrap").click();
        $$(".country__wrap").find(text(currency.name())).click();
        $(".main-page__content").shouldHave(text(currency.description));
    }
    static Stream<Arguments> checkСurrencyOnStartPageWithMethodSource(){
        return Stream.of(
                Arguments.of(
                        Currency.AMD,
                        List.of("драм")
                ),
                Arguments.of(
                        Currency.KZT,
                        List.of("тг.")));
   }
    @MethodSource
    @ParameterizedTest
    void checkСurrencyOnStartPageWithMethodSource(Currency currency, List<String> expectedCurrency){
        open("https://www.wildberries.ru/");

        $(".header__wrap").click();
        $$(".country__wrap").find(text(currency.name())).click();

        for (String currencyText : expectedCurrency) {
            $("#body-layout").shouldHave(text(currencyText));
        }
    }

}