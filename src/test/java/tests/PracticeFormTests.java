package tests;

import dto.Student;
import manager.AppManager;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;

public class PracticeFormTests extends AppManager {

    @Test
    public void practiceFormPositiveTest() {
        Student student = new Student("Liza","Fox","lizkafox@mail.ru","Female","0123456789","13 June 1997", "Math, Chemestry, English", "Sports","","Fox avenue", "NCR","Delhi");
        new HomePage(getDriver()).clickBtrForms();
        new FormsPage(getDriver()).clickBtnPracticeForm();
    }

}
