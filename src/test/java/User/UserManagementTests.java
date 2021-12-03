package User;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class UserManagementTests {
    //Import Selenium WebDriver
    private WebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException{
        //fetch the chromeDriver.exe file
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        //launch the chromedriver.exe file
        driver = new ChromeDriver();

        //input the website URL
        driver.get ("https://dev.d2rxvhrryr2bkn.amplifyapp.com/login");

        //wait for the page to load in 5 seconds
        Thread.sleep(3000);

        //Maximize the browser
        driver.manage() .window().maximize();

        //Get Page Title and Print out
        System.out.println(driver.getTitle());

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test(priority = 0)
    public void loginTest() throws InterruptedException {
        //click on the username field and input a valid username "performancetests"
        driver.findElement(By.id("username")).sendKeys("performancetests");

        //click on the password field and input a valid password "admin123"
        driver.findElement(By.id("password")).sendKeys("admin123");

        //click on the login button
        driver.findElement(By.xpath("/html/body/div/div/div/div/main/div/div[2]/div/div/div/div[2]/div/div/form/button")).click();

        Thread.sleep( 5000);

        if(driver.getCurrentUrl().contains("https://dev.d2rxvhrryr2bkn.amplifyapp.com/app/feed")) {
            System.out.println("PASSED - User has Successfully logged in");
        }else {
            System.out.println("FAILED - The user was unable to login");
        }

        Thread.sleep(3000);
    }

    @Test(priority = 1)
    public void logOut() throws InterruptedException {
        //Click User Profile
        driver.findElement(By.xpath("/html/body/div/div/div/div/main/div/div[1]/div[1]/div/div[2]/div[3]/button/p")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div/div/div/div/main/div/div[1]/div[1]/div/div[2]/div[3]/div/div/a[3]/p")).click();
        Thread.sleep(3000);
        if(driver.getCurrentUrl().contains("https://dev.d2rxvhrryr2bkn.apmplifyapp.com/app/feed")) {
            System.out.println("PASSED - User has Successfully logged in");
        }else {
            System.out.println("FAILED - User is still logged in");
        }
        Thread.sleep(3000);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    public static void main(String args[]) throws InterruptedException {
        UserManagementTests test = new UserManagementTests();
        test.setUp();

    }
}
