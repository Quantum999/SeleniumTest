package testproject1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyntraTest {
	public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://tms.pisystindia.com/admin");
        driver.manage().window().maximize();

        WebElement men = driver.findElement(By.xpath("(//a[contains(text(), 'Master')])[1]"));

        Actions action = new Actions(driver);
        action.moveToElement(men);
        action.perform();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        WebElement phoneCases = driver.findElement(By.xpath("//a[contains(text(), 'Phone Cases')]"));
        phoneCases.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        WebElement price = driver.findElement(By.xpath("(//span[contains(@class, 'product-discountedPrice')])[1]"));
        String amount = price.getText();
        amount = amount.split(" ")[1];

        if(amount.equals("849")) {
            System.out.println("Test case passed");
        }
        else {
            System.out.println("Test case failed");
        }

        driver.quit();
    }
}
