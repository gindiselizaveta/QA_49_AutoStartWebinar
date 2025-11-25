package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.Watchable;

public class BasePage {
    static WebDriver driver;
    public static void setDriver(WebDriver webDriver){
        driver = webDriver;
    }

    public static void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void hideBanner() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('#fixedban').style.display= 'none'");

    }

    public void footerBanner() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('footer').style.display='none'");

    }

    public boolean validateTextInElement(WebElement element, String text){
        return  element.getText().contains(text);
    }
}
