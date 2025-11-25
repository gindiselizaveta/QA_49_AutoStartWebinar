package pages;

import dto.Student;
import enums.Gender;
import enums.Hobbies;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

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

    @FindBy(id = "dateOfBirthInput")
    WebElement fieldDateOfBirth;

    @FindBy(xpath = "//input[@id='subjectsInput']")
    WebElement fieldSubjects;

    @FindBy(id = "react-select-3-input")
    WebElement fieldState;
    @FindBy(id = "react-select-4-input")
    WebElement fieldCity;

    @FindBy(id ="submit" )
    WebElement btnSubmit;

    @FindBy(id="example-modal-sizes-title-lg")
    WebElement modalMessage;

    public boolean validateModalMessage(){
        return validateTextInElement(modalMessage,"Thanks for submitting the form");
    }

    public boolean validateModalMessageNegative(){
        return validateTextInElement(modalMessage,"Error");
    }

    public void typePracticeForm(Student student) {
        hideBanner();
        footerBanner();
        fieldFirstName.sendKeys(student.getFirstName());
        fieldLastName.sendKeys(student.getLastName());
        fieldEmail.sendKeys(student.getEmail());
        typeGender(student.getGender());
        fieldMobile.sendKeys(student.getMobile());
        //fieldDateOfBirth.sendKeys(student.getDateOfBirth());
        typeDateOfBirth(student.getDateOfBirth());
        typeSubjects(student.getSubjects());
        typeHobbies(student.getHobbies());
        fieldCurAddress.sendKeys(student.getAddress());
        typeStateCity(student.getState(), student.getCity());
        btnSubmit.click();
    }

    private void typeGender(Gender gender) {
        WebElement btnGender = driver.findElement(By.xpath(gender.getLocator()));
        btnGender.click();
    }

    private void typeDateOfBirth(String dateOfBirth) {
        fieldDateOfBirth.click();
        String OS = System.getProperty("os.name");
        System.out.println(OS);
        if (OS.startsWith("Mac"))
            fieldDateOfBirth.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        else if (OS.startsWith("Win"))
            fieldDateOfBirth.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        fieldDateOfBirth.sendKeys(dateOfBirth);
        fieldDateOfBirth.sendKeys(Keys.ENTER);
    }

    private void typeSubjects(String subjects) {
        fieldSubjects.click();
        String[] arr = subjects.split(",");
        for (String s : arr) {
            fieldSubjects.sendKeys(s);
            fieldSubjects.sendKeys(Keys.ENTER);
        }
    }

    private void typeHobbies(List<Hobbies> hobbies) {
        for (Hobbies h : hobbies) {
            switch (h) {
                case MUSIC:
                    driver.findElement(By.xpath(h.getLocator())).click();
                    break;
                case SPORTS:
                    driver.findElement(By.xpath(h.getLocator())).click();
                    break;
                case READING:
                    driver.findElement(By.xpath(h.getLocator())).click();
                    break;
            }
        }
    }

    private void typeStateCity(String state, String city) {
        fieldState.sendKeys(state);
        fieldState.sendKeys(Keys.ENTER);
        fieldCity.sendKeys(city);
        fieldCity.sendKeys(Keys.ENTER);
    }
}
