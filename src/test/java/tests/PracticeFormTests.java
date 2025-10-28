package tests;

import dto.Student;
import enums.Gender;
import enums.Hobbies;
import enums.StateCity;
import manager.AppManager;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormTests extends AppManager {

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
    }

}
