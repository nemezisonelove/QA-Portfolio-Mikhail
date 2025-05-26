import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class LoginTest {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1200x800";
        Configuration.timeout = 6000; // на всякий случай
    }

    @Test
    void loginShouldFailWithInvalidCredentials() {
        open("/login");

        $("#userName").setValue("wronguser");
        $("#password").setValue("wrongpass");

        // Скроллим до кнопки логина
        $("#login").scrollTo().click();

        // Проверяем текст ошибки
        $(".mb-1").shouldHave(text("Invalid username or password!"));
    }
}
