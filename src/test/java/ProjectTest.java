import io.qameta.allure.Description; // ДОБАВЬ
import io.qameta.allure.Feature; // ДОБАВЬ
import io.qameta.allure.Story; // ДОБАВЬ
import org.testng.annotations.Test;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.screenshot;

@Feature("Создание и удаление проекта")
public class ProjectTest extends BaseTest {

    @Test
    @Story("Создание и удаление проекта")
    @Description("Создание проекта, проверка создания, удаление и проверка удаления")
    public void checkCreateProject() {
        open("/login");
        $("[name=email]").setValue("druzalexandra@gmail.com");
        $("[name=password]").setValue("o08UglWKWNPGJq4L");
        $(byText("Sign in")).click();

        $(byText("Create new project")).shouldBe(visible);
        takeScreenshot("После входа");

        $(byText("Create new project")).click();

        $("#project-name").setValue("test1");
        $("#project-code").setValue("test1");
        $(byText("Create project")).click();

        open("/projects");
        takeScreenshot("после_создания_проекта");

        $(byText("test1")).shouldBe(visible);

        deleteProject("test1");
        takeScreenshot("после_удаления_проекта");

        $(byText("test1")).shouldNotBe(visible);
    }

    public void deleteProject(String projectName) {
        $x(String.format("//*[text()='%s']/ancestor::tr//button[@aria-label='Open action menu']", projectName))
                .shouldBe(visible)
                .click();
        $("[data-testid=remove]").shouldBe(visible).click();
        $x("//span[text()='Delete project']").shouldBe(visible).click();
    }
    private void takeScreenshot(String name) {
        Allure.addAttachment(name,
                new java.io.ByteArrayInputStream(
                        ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES)
                )
        );
    }
}
