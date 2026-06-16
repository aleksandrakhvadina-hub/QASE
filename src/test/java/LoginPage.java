import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    private final String EMAIL = "[name=email]";
    private final String PASSWORD = "[name=password]";
    private final String SIGN_IN = "Sign in";

    public void open() {
        Selenide.open("/login");
    }

    public void login(String email, String password) {
        $(EMAIL).setValue(email);
        $(PASSWORD).setValue(password);
        $(byText(SIGN_IN)).click();
    }
}
