import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class GithubTest {

    @BeforeAll
    static void basicSettingBrowder() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
    }

    @Test
    void shouldBeThePageEnterprizeTest() {
        open("/");
        $x("//button[contains(text(),'Solutions')]").hover();
        $x("//a[contains(text(),'Enterprise')]").click();
        $("h1#hero-section-brand-heading").shouldHave(text("The AI-powered developer platform"));
    }
}
