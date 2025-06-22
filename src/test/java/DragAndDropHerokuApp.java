import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragAndDropHerokuApp {

    @BeforeAll
    static void basicSettingBrowder() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
    }

    @Test
    void swapElement() {
        open("/drag_and_drop");

        SelenideElement columnA = $("#column-a");
        SelenideElement columnB = $("#column-b");
        WebElement source = columnA.toWebElement();
        WebElement target = columnB.toWebElement();

        Selenide.actions()
                .clickAndHold(source)
                .moveToElement(target)
                .release()
                .build()
                .perform();

        columnA.shouldHave(text("B"));
        columnB.shouldHave(text("A"));
    }
}
