import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;  //фреймворк - набор инструментов котрый мы будем использовать для чего-то.

import java.util.concurrent.TimeUnit;

public class MainTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //каждый поиск элемента ищет не более 10 секунд
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void outBrauser() {
        driver.quit();
    }

    @Test
    public void testSelenium() {

            driver.get("https://www.browserstack.com/users/sign_in");

            WebElement username = driver.findElement(By.id("user_email_login"));
            WebElement password = driver.findElement(By.id("user_password"));
            WebElement login = driver.findElement(By.name("commit"));

            username.sendKeys("abc@gmail.com");
            password.sendKeys("your_password");
            login.click();

            String expectedUrl = "https://live.browserstack.com/dashboard";
            String actualUrl = driver.getCurrentUrl();

            Assert.assertEquals(actualUrl, expectedUrl);
    }
    @Test
    public void testNewPassword() {

        driver.get("https://www.browserstack.com/users/sign_in");

        WebElement link = driver.findElement(By.linkText("Forgot password?"));
        link.click();


        Assert.assertEquals(driver.getCurrentUrl(), "https://www.browserstack.com/users/password/new");
    }

    @Test //аннотация. используется как маркер, что это тест.
    void testGetSum() {
        int result;

        result = Main.getSum(10, 10);
        Assert.assertEquals(result, 20);

        result = Main.getSum(0, 0);
        Assert.assertEquals(result, 0);

        result = Main.getSum(-10, -10);
        Assert.assertEquals(result, -20);

        result = Main.getSum(0, 0);
        Assert.assertEquals(result, 0);

        result = Main.getSum(-10, 10);
        Assert.assertEquals(result, 0);
    }
}
