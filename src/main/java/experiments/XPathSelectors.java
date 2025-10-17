package experiments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class XPathSelectors {

    WebDriver driver = new ChromeDriver();

    @Test

    public void selectorsTextBox() {
        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();
        hideBanner();
        footerBanner();
        pause(3000);

        //WebElement inputFullName = driver.findElement(By.cssSelector("input[placeholder='Full Name']"));
        //inputFullName.sendKeys("Fox");
        WebElement inputFullName = driver.findElement(By.xpath("//input[@placeholder='Full Name']"));
        inputFullName.sendKeys("Lizka Fox");
        WebElement inputEmail = driver.findElement(By.xpath("//form/div[@id='userEmail-wrapper']/div[2]/input"));
        inputEmail.sendKeys("Lizkafox@mail.ru");
        WebElement labelText = driver.findElement(By.xpath("//*[text()='Current Address']"));
        System.out.println(labelText.getTagName());
        WebElement textAreaCurAdd = driver.findElement(By.xpath("//*[text()='Current Address']/../..//textarea"));
        textAreaCurAdd.sendKeys("Fox street 1");
        WebElement textAreaPerAdd = driver.findElement(By.xpath("//div[@id='permanentAddress-wrapper']//textarea"));
        textAreaPerAdd.sendKeys("Fox's avenue 13");
        WebElement btnSubmit = driver.findElement(By.xpath("//button[text()='Submit']"));
        btnSubmit.click();
        WebElement outPut = driver.findElement(By.xpath("//*[@id='output']"));
        System.out.println(outPut.getText());

        //pause(3000);
        //driver.quit();
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
}
