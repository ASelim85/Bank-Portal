package Pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RolesAccessPage extends PageBase {
    public static By userAccessLink = By.xpath("//*[@id=\"root\"]/div/section/aside/div[1]/nav/ul/li[7]/div/span");
    public static By rolesLink = By.xpath("//a[@href='/roles']");
    public static By rolesTxtTitleEle = By.xpath("//div[@class='ant-col ant-col-12']");
    public static By addNewRole = By.xpath("//a[@href='/roles/new']");
    public static By roleNameENField = By.id("englishName");
    public static By roleNameARField = By.id("arabicName");
    public static By permissionField = By.id("permissions");
    public static By dashboardCheckBox = By.xpath("//*[@title='Dashboard']");

    public static By moneyPoolCheckBox = By.xpath("//*[@title='Money Pool']");
    public static By KYCSCheckBox = By.xpath("//*[@title='KYCS']");

    public static By walletsCheckBox = By.xpath("//*[@title='Wallets']");
    public static By userAccessCheckBox = By.xpath("//*[@title='User Access']");
    public static By reportsCheckBox = By.xpath("//*[@title='Reports']");
    public static By SMEsCheckBox = By.xpath("//*[@title='SMEs']");

    public static By submitBtn = By.xpath("//button[@type='submit']");

    public static By roleDetailsTitle = By.xpath("//*[@id=\"root\"]/div/section/section/main/div/h4");

    public static By roleNameTitle = By.xpath("//div[@class='ant-col _detail-value_1hyj4_21']");

    static Faker data = new Faker();
    static String RoleNameEN;

    public RolesAccessPage(WebDriver driver) {
        super(driver);
    }

    public static void clickUserAccess() {
        click(userAccessLink);
    }

    public static void clickRoles() {
        click(rolesLink);
    }

    public static String getRolesTextTitle() {
        waitElement(rolesTxtTitleEle);
        return action(rolesTxtTitleEle).getText();
    }

    public static void clickAddNewRole() {
        click(addNewRole);
    }

    public static void fillRoleNameEN() {
        RoleNameEN = data.book().title();
        setText(roleNameENField, RoleNameEN);
    }

    public static void fillRoleNameAR() {
        setText(roleNameARField, "تست");
    }

    public static void selectDashboard() {
        WebElement permissionTxtBOx = driver.findElement(By.id("permissions"));
        permissionTxtBOx.click();
        click(dashboardCheckBox);
//        permissionTxtBOx.sendKeys(Keys.ESCAPE);
    }

    public static void selectMoneyPool() {
        WebElement permissionTxtBOx = driver.findElement(By.id("permissions"));
        permissionTxtBOx.click();
        click(moneyPoolCheckBox);
//        permissionTxtBOx.sendKeys(Keys.ESCAPE);
    }

    public static void selectKYCS() {
        WebElement permissionTxtBOx = driver.findElement(By.id("permissions"));
        permissionTxtBOx.click();
        click(KYCSCheckBox);
//        permissionTxtBOx.sendKeys(Keys.ESCAPE);
    }

    public static void selectWallets() {
        WebElement permissionTxtBOx = driver.findElement(By.id("permissions"));
        permissionTxtBOx.click();
        click(walletsCheckBox);
//        permissionTxtBOx.sendKeys(Keys.ESCAPE);
    }

    public static void selectUserAccess() {
        WebElement permissionTxtBOx = driver.findElement(By.id("permissions"));
        permissionTxtBOx.click();
        click(userAccessCheckBox);
//        permissionTxtBOx.sendKeys(Keys.ESCAPE);
    }

    public static void selectReports() {
        WebElement permissionTxtBOx = driver.findElement(By.id("permissions"));
        permissionTxtBOx.click();
        click(reportsCheckBox);
//        permissionTxtBOx.sendKeys(Keys.ESCAPE);
    }

    public static void selectSMEs() {
        WebElement permissionTxtBOx = driver.findElement(By.id("permissions"));
        permissionTxtBOx.click();
        click(SMEsCheckBox);
        permissionTxtBOx.sendKeys(Keys.ESCAPE);
    }

    public static void clickSubmitBtn() {
        click(submitBtn);
    }

    public static String getRolesDetailsTextTitle() {
        waitElement(roleDetailsTitle);
        return action(roleDetailsTitle).getText();
    }

    public static String getRoleNameText() {
        waitElement(roleNameTitle);
        return action(roleNameTitle).getText();
    }
}
