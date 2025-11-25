package tests;

import dto.Student;
import enums.Gender;
import enums.Hobbies;
import enums.StateCity;
import manager.AppManager;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormTests extends AppManager {
    SoftAssert softAssert = new SoftAssert();


    @Test
    public void practiceFormPositiveTest() {

        List<Hobbies> hobbies = new ArrayList<>();
        hobbies.add(Hobbies.READING);
        hobbies.add(Hobbies.MUSIC);


        Student student = new Student("Lizka", "Fox",
                "lizkafox@gmail.com", Gender.FEMALE,
                "0123456789", "13 Jun 2002",
                "Maths,Chemistry,Commerce", hobbies, ""
                , "street 13", StateCity.UTTAR_PRADESH.getState(), StateCity.UTTAR_PRADESH.getCity()[2]);
        new HomePage(getDriver()).clickBtrForms();
        new FormsPage(getDriver()).clickBtnPracticeForm();
        new PracticeFormPage(getDriver()).typePracticeForm(student);

        //Assert.assertTrue(new PracticeFormPage(getDriver()).validateModalMessageNegative());
        //System.out.println("test failed");

        Assert.assertTrue(new PracticeFormPage(getDriver()).validateModalMessage());
    }

    @Test
    public void practiceFormPositiveTestWithSoftAssert() {

        List<Hobbies> hobbies = new ArrayList<>();
        hobbies.add(Hobbies.READING);
        hobbies.add(Hobbies.MUSIC);


        Student student = new Student("Lizka", "Fox",
                "lizkafox@gmail.com", Gender.FEMALE,
                "0123456789", "13 Jun 2002",
                "Maths,Chemistry,Commerce", hobbies, ""
                , "street 13", StateCity.UTTAR_PRADESH.getState(), StateCity.UTTAR_PRADESH.getCity()[2]);
        new HomePage(getDriver()).clickBtrForms();
        new FormsPage(getDriver()).clickBtnPracticeForm();
        new PracticeFormPage(getDriver()).typePracticeForm(student);

        //softAssert.assertTrue(new PracticeFormPage(getDriver()).validateModalMessageNegative(), "validate model negative message");
        //System.out.println("test failed");
        softAssert.assertTrue(new PracticeFormPage(getDriver()).validateModalMessage(), "validate Modal Message");
        System.out.println("test passed");

        softAssert.assertTrue(getDriver().findElement(By.xpath("//tbody/tr/td[last()]")).getText().contains(student.getLastName()),"last name validation");
        softAssert.assertTrue(getDriver().findElement(By.xpath("//tbody/tr/td[last()]")).getText().contains(student.getFirstName()),"first name validation");

        softAssert.assertAll();
    }

}
