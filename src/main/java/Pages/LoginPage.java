package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {
    public static By txtUsername = By.id("login");
    public static By txtPassword = By.id("password");
    public static By btnSignIn = By.xpath("//button[@type='submit']");
    public static By errorMSG = By.xpath("/html/body/div[2]/div");
    public static By txtOTP = By.id("basic_otp");
    public static By btnVerifyOTP = By.xpath("//button[@type='submit']");
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @Step("Type UserName")
    public static void setUsername(String username) {
        setText(txtUsername, username);
    }
    @Step("Type Passwrod")
    public static void setPassword(String password) {
        setText(txtPassword, password);
    }
    @Step("CLick Log in button")
    public static void clickSignIn() {
        click(btnSignIn);
    }
    @Step("Get the error message")
    public static String GetErrorMSG() {
        waitElement(errorMSG);
        String InvalidPassErrMSG = action(errorMSG).getText();
        return InvalidPassErrMSG;
    }
    @Step("Type OTP")
    public static void setOTP(String otp) {
        setText(txtOTP, otp);
    }
    @Step("Click verify OTP")
    public static void clickVerifyOTP() {
        click(btnVerifyOTP);
    }
}
