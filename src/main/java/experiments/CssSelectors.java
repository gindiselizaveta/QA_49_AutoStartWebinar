package experiments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
            hideBanner();
            footerBanner();
            WebElement btnYes = driver.findElement(By
                    .cssSelector("label[for='yesRadio']"));
            btnYes.click();
            pause(4000);
            //WebElement btnImpressive = driver.findElement(By.cssSelector("label[for='impressiveRadio']"));
            //btnImpressive.click();
            driver.navigate().back();
            driver.navigate().back();
            hideBanner();
            footerBanner();
            WebElement div = driver.findElement(By.cssSelector("div[class ='category-cards'] div[class='card mt-4 top-card']:last-child"));
            div.click();
            pause(4000);
            driver.navigate().back();
            WebElement divWid = driver.findElement(By.cssSelector("div[class ='category-cards'] div[class='card mt-4 top-card']:nth-child(4)"));
            divWid.click();
            pause(4000);
            WebElement divAl = driver.findElement(By.cssSelector("div[class='category-cards'] div[class='card mt-4 top-card']:nth-child(3) div[class='card-body'] h5"));
            System.out.println(divAl.getText());
            pause(4000);


            driver.quit();
        }

        @Test
        public void clickCheckBox() {
            driver.get("https://demoqa.com/");
            driver.manage().window().maximize();
            pause(4000);
            WebElement divEl = driver
                    .findElement(By.cssSelector(".card-up"));
            divEl.click();
            pause(4000);
            WebElement btnCheckBox = driver.findElement(By.id("item-1"));
            btnCheckBox.click();
            pause(4000);
            hideBanner();
            footerBanner();
            WebElement checkBox = driver.findElement(By.cssSelector("svg[class= 'rct-icon rct-icon-uncheck']"));
            checkBox.click();
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

        public void hideBanner() {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("document.querySelector('#fixedban').style.display= 'none'");

        }public void footerBanner() {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("document.querySelector('footer').style.display='none'");

        }

}
