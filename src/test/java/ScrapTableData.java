import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)


public class ScrapTableData {
    WebDriver driver;
    @BeforeAll
    public void setup(){
        driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
@Test
    public void scrapData() throws IOException {
        driver.get("https://dsebd.org/latest_share_price_scroll_by_value.php");
        WebElement table= driver.findElement(By.className("floatThead-wrapper"));
        List<WebElement> allRows= table.findElements(By.tagName("tbody"));
        String filePath = "./src/test/resources/ScrapedData.txt";
        FileWriter writer = new FileWriter(filePath);


        for(WebElement row:allRows){
           List <WebElement> cells= row.findElements(By.tagName("td"));
           for(WebElement cell:cells){
               writer.write(cell.getText() + " | ");
               System.out.println(cell.getText());
           }
            writer.write("\n");
        }
        writer.close();
    }

    @AfterAll
    public void quitDriver(){
        // driver.quit();
    }



}
