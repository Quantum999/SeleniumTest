package testproject1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyntraTest {

    private static final String EMAIL = "sales.infinitycorp@gmail.com";
    private static final String PASSWORD = "123456";

	public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://tms.pisystindia.com/admin");

        WebElement email = driver.findElement(By.id("admin_email"));
        WebElement password = driver.findElement(By.id("admin_password"));

        email.sendKeys(EMAIL);
        password.sendKeys(PASSWORD);

        WebElement login = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div[2]/button"));
        login.click();

        try {
            Thread.sleep(3000);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        WebElement emailPromotion = driver.findElement(By.xpath("/html/body/div[1]/div/div/ul/li[9]/a"));
        emailPromotion.click();

        try {
            Thread.sleep(3000);
        }
        catch (Exception e) {
            e.printStackTrace();
        }



        driver.quit();
    }
}
