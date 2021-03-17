import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FillFormTests {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void selenideFillFormTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Name");
        $("#lastName").setValue("LastName");
        $("#userEmail").setValue("name@example.com");
        $(byText("Female")).click();
        $("#userNumber").setValue("1920321016");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("10");
        $(".react-datepicker__year-select").selectOptionByValue("1986");
        $(".react-datepicker__day--025").click();

        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("#subjectsInput").setValue("Math").pressEnter();

        $("[for='hobbies-checkbox-1']").click();
        $("#uploadPicture").uploadFromClasspath("first.png");
        $("#currentAddress").setValue("Test Address 234");

        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();

        $("#submit").click();

        $(".modal-content").shouldBe(visible);
        $(".modal-content").shouldHave(text("Name LastName"));
        $(".modal-content").shouldHave(text("name@example.com"));
        $(".modal-content").shouldHave(text("Female"));
        $(".modal-content").shouldHave(text("1920321016"));
        $(".modal-content").shouldHave(text("25 November,1986"));
        $(".modal-content").shouldHave(text("Computer Science, Maths"));
        $(".modal-content").shouldHave(text("Sports"));
        $(".modal-content").shouldHave(text("first.PNG"));
        $(".modal-content").shouldHave(text("Test Address 234"));
        $(".modal-content").shouldHave(text("NCR Delhi"));

        $("#closeLargeModal").click();
    }
}
