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

        String firstName = "Name";
        String lastName = "LastName";
        String email = "name@example.com";
        String gender = "Female";
        String mobileNumber = "1920321016";
        String subject = "Computer Science";
        String picture = "first.png";
        String address = "Test Address 234";
        String state = "NCR";
        String city = "Delhi";

        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $(byText(gender)).click();
        $("#userNumber").setValue(mobileNumber);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("10");
        $(".react-datepicker__year-select").selectOptionByValue("1986");
        $(".react-datepicker__day--025").click();

        $("#subjectsInput").setValue(subject).pressEnter();

        $("[for='hobbies-checkbox-1']").click();
        $("#uploadPicture").uploadFromClasspath(picture);
        $("#currentAddress").setValue(address);

        $("#state").click();
        $(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();

        $("#submit").click();

        $(".modal-content").shouldBe(visible).shouldHave(text(firstName),
                text(lastName),
                text(email),
                text(gender),
                text(mobileNumber),
                text("25 November,1986"),
                text(subject),
                text("Sports"),
                text(picture),
                text(address),
                text(state),
                text(city));

        $("#closeLargeModal").click();
        $(".modal-content").shouldNotBe(visible);
    }
}
