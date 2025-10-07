import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Webform {
    WebDriver driver;
    @BeforeAll
    public void setup(){
        driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @DisplayName("verify webfrom is fillupped")
    @Test
    public void createUser(){
        driver.get("https://www.digitalunite.com/practice-webform-learners");

       try {
            driver.findElement(By.id("onetrust-accept-btn-handler")).click();
            System.out.println("✅ Cookies accepted");
       } catch (Exception e) {
            System.out.println(" No cookie popup found");

       }


       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));


        driver.findElement(By.id("edit-name")).sendKeys("Nafis Fuad Tanvir");
        driver.findElement(By.id("edit-number")).sendKeys("01323235077");
        driver.findElement(By.id("edit-date")).clear();
        driver.findElement(By.id("edit-date")).sendKeys(Keys.CONTROL+"a",Keys.BACK_SPACE);
        driver.findElement(By.id("edit-date")).sendKeys("10/06/2025");
        driver.findElement(By.id("edit-date")).sendKeys(Keys.ENTER);
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,500)");
        driver.findElement(By.id("edit-email")).sendKeys("test@gmail.com");
        driver.findElement(By.id("edit-tell-us-a-bit-about-yourself-")).sendKeys("i am testing this webform");
        driver.findElement(By.id("edit-uploadocument-upload"))
            .sendKeys("C:\\Users\\Asus\\Downloads\\testfile.doc");
        driver.findElement(By.id("edit-age")).click();
        driver.findElement(By.id("edit-submit")).click();
        String expectedMessage = "Thank you for your submission!";

    }


    @AfterAll
    public void quitDriver(){
        // driver.quit();
    }


    }


