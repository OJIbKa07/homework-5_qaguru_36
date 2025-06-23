import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragAndDropHerokuApp {

    @BeforeAll
    static void basicSettingBrowser() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
    }

    @Test
    void swapElementTest() {
        open("/drag_and_drop");

        SelenideElement columnA = $("#column-a");
        SelenideElement columnB = $("#column-b");

        $(columnA).shouldHave(text("A"));
        $(columnB).shouldHave(text("B"));

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

    @Test
    void swapElementDragAndDropTest() {
        open("/drag_and_drop");

        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));

        $("#column-a").dragAndDrop(to("#column-b"));

        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
