package id.ac.ui.cs.advprog.eshop.functional;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
public class CreateProductFunctionalTest {

    @LocalServerPort
    private int serverPort;

    @Value("${app.baseUrl:http://localhost}")
    private String testBaseUrl;

    private String baseUrl;

    @BeforeEach
    void setupTest() {
        baseUrl = String.format("%s:%d", testBaseUrl, serverPort);
    }

    @Test
    void testProductCreation(ChromeDriver driver) {
        driver.get(baseUrl + "/product/create");

        // Find the input fields and submit button
        WebElement nameInput = driver.findElement(By.id("nameInput"));
        WebElement quantityInput = driver.findElement(By.id("quantityInput"));
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));

        // Fill in the form
        nameInput.sendKeys("Red Diary Page");
        quantityInput.sendKeys("10");

        // Submit the form
        submitButton.click();

        // Find the created product in the product list
        String pageTitle = driver.getTitle();
        WebElement productName = driver.findElement(By.xpath("//td[contains(text(),'Red Diary Page')]"));
        WebElement productQuantity = driver.findElement(By.xpath("//td[contains(text(),'10')]"));

        // Assert that the created product exists in the product list
        Assertions.assertEquals("Product List", pageTitle);
        Assertions.assertNotNull(productName);
        Assertions.assertNotNull(productQuantity);
    }
}