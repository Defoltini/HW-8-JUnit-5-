import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class OzonTests extends TestBase{
@Tag("High")
@Tag("Smoke")
@CsvSource({
        "брюки",
        "кофта"
})
@ParameterizedTest (name = "Проверка поиска по слову {0}")
void checkSearchOzon(String clothes){
    $("[name='text']").setValue(clothes);
    $("[aria-label='Поиск']").click();
    $("#paginator").shouldHave(text(clothes));
}
}
