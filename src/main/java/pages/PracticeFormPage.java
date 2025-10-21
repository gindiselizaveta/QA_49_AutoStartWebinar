package pages;

import dto.Student;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PracticeFormPage extends BasePage {
    public PracticeFormPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//input[@id='firstName']")
    WebElement fieldFirstName;
    @FindBy(id = "lastName")
    WebElement fieldLastName;
    @FindBy(xpath = "//input[@placeholder='name@example.com']")
    WebElement fieldEmail;
    @FindBy(id = "userNumber")
    WebElement fieldMobile;
    @FindBy(id = "currentAddress")
    WebElement fieldCurAddress;


    public void typePracticeForm(Student student) {
        hideBanner();
        footerBanner();
        fieldFirstName.sendKeys(student.getFirstName());
        fieldLastName.sendKeys(student.getLastName());
        fieldEmail.sendKeys(student.getEmail());
        fieldMobile.sendKeys(student.getMobile());
        fieldCurAddress.sendKeys(student.getAddress());

    }
}
