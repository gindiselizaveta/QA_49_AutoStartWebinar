package experiments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CssSelectors {

        WebDriver driver = new ChromeDriver();

        @Test
        public void selectorsHomePage() {
            driver.get("https://demoqa.com/");
            //driver.navigate().to("https://demoqa.com/");
            //driver.navigate().back();
            //driver.navigate().refresh();
            driver.manage().window().maximize();
            pause(4000);

            WebElement footer = driver.findElement(By.tagName("footer"));
            System.out.println(footer.getTagName());
            //footer.click();

            //WebElement divElements = driver
            //       .findElement(By.cssSelector("div[class='card-up']"));
            WebElement divElements = driver
                    .findElement(By.cssSelector(".card-up"));
            divElements.click();
            pause(4000);

            //WebElement radioBtn = driver.findElement(By.cssSelector("li[id='item-2']"));
            //WebElement radioBtn = driver.findElement(By.id("item-2"));
            WebElement radioBtn = driver.findElement(By.cssSelector("#item-2"));
            radioBtn.click();
            pause(4000);
            // driver.navigate().back();
            // driver.navigate().back();
            WebElement btnImpressive = driver.findElement(By.cssSelector("label[for='impressiveRadio']"));
            btnImpressive.click();
            pause(4000);
            driver.quit();
        }

        public static void pause(int time){
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

}
