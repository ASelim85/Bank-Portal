package Pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UserAccessPage extends PageBase {
    public static By userAccessLink = By.xpath("//*[@id=\"root\"]/div/section/aside/div[1]/nav/ul/li[7]/div/span");
    public static By usersLink = By.xpath("//a[@href='/users']");
    public static By rolesLink = By.xpath("//*[@id=\"rc-menu-uuid-43947-1-users-popup\"]/li[2]/span/a");
    public static By usersTxtTitleEle = By.xpath("//div[@class='ant-col ant-col-12']");
    public static By addNewUser = By.xpath("//a[@href='/users/new']");
    public static By userNameField = By.id("login");
    public static By roleIdField = By.id("roleId");
    public static By firstNameField = By.id("firstName");
    public static By lastNameField = By.id("lastName");
    public static By emailField = By.id("email");
    public static By nationalIDField = By.id("nationalId");
    public static By nationalIdExpiryDateField = By.id("nationalIdExpiryDate");
    public static By genderField = By.id("gender");
    public static By birthDateField = By.id("birthDate");
    public static By mobileNoField = By.id("mobileNo");
    public static By governorateField = By.id("governorate");
    public static By cityField = By.id("city");
    public static By addressField = By.id("address");
    public static By submitBtn = By.xpath("//button[@type='submit']");
    public static By roleName = By.xpath("//*[@id=\"root\"]/div/section/section/main/div/div/div/form/div[1]/div[2]/div/div/div[2]/div/div/div/div[2]/div/div/div/div[2]/div[1]/div/div/div[2]");
    public static By msgSuccess = By.xpath("//div[@class='ant-notification-notice-message']");
    public static By notDescription = By.xpath("//div[@class='ant-notification-notice-description']");
    public static By roleTitle = By.xpath("//*[@title='"+RolesAccessPage.RoleNameEN+"']");
    public static By genderTitle = By.xpath("//*[@title='Male']");
    public static By govTitle = By.xpath("//*[@title='Cairo']");

    public static By cityTitle = By.xpath("//*[@title='Maadi']");
    static String tommorowsDate;
    static Faker data = new Faker();

    public UserAccessPage(WebDriver driver) {
        super(driver);
    }

    public static void clickUserAccess() {
        click(userAccessLink);
    }

    public static void clickUsers() {
        click(usersLink);
    }

    public static void clickRoles() {
        click(rolesLink);
    }

    public static String getUsersTextTitle() {
        waitElement(usersTxtTitleEle);
        return action(usersTxtTitleEle).getText();
    }

    public static void clickAddNewUser() {
        click(addNewUser);
    }

    public static void fillUserName() {
        setText(userNameField, data.name().firstName());
    }

    public static void selectRole() throws InterruptedException {
        setText(roleIdField, RolesAccessPage.RoleNameEN);
        WebElement roleTitle = driver.findElement(By.xpath("//*[@title='"+RolesAccessPage.RoleNameEN+"']"));
        roleTitle.click();
    }

    public static void fillFirstNameField() {
        setText(firstNameField, data.name().firstName());
    }

    public static void fillLastNameField() {
        setText(lastNameField, data.name().lastName());
    }

    public static void fillEmailField() {
        setText(emailField, "aselim@axisapp.com");
    }

    public static void fillNIDField() {
        setText(nationalIDField, "20607180102685");
    }

    public static String getCurrentDate() {
        Date dt = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dt);
        calendar.add(Calendar.DATE, 1);
        dt = calendar.getTime();
        tommorowsDate = new SimpleDateFormat("dd/MM/yyyy").format(dt);
        return tommorowsDate;
    }

    public static void fillNIDExpiryDate() {
        clicks(nationalIdExpiryDateField);
        setText(nationalIdExpiryDateField, getCurrentDate());
        setText(nationalIdExpiryDateField, String.valueOf(Keys.ENTER));
//        setText(nationalIdExpiryDateField, String.valueOf(Keys.TAB));

    }

    public static void selectGender() throws InterruptedException {
        WebElement genderField = driver.findElement(By.id("gender"));
        genderField.click();
        clicks(genderTitle);
    }

    public static void selectBirthDate() {
        click(birthDateField);
        setText(birthDateField, "18/07/2006");
    }

    public static void fillMobNum() {
        setText(mobileNoField, "01110693883");
    }

    public static void selectGovernorate() throws InterruptedException {
        WebElement Governorate = driver.findElement(By.id("governorate"));
        Governorate.click();
        click(govTitle);

    }

    public static void selectCity() throws InterruptedException {
        WebElement city = driver.findElement(By.id("city"));
        city.click();
        click(cityTitle);
    }

    public static void fillAddress() {
        setText(addressField, "الحرم اليوناني - التحرير - وسط البلد");
    }

    public static void clickSubmit() {
        click(submitBtn);
    }
    public static String getNotificationMsg() {
        waitElement(msgSuccess);
        return action(msgSuccess).getText();
    }
    public static String getNotificationDesc() {
        waitElement(notDescription);
        return action(notDescription).getText();
    }
}
