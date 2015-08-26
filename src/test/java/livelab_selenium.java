
/**
 * Created by maximilian on 12.08.15.
 */


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class livelab_selenium {
    public static void main(String[] args) {

        Random rand = new Random();

        int country = 0;

        // load WebDriver

        WebDriver driver = new ChromeDriver();

        for (int i = 0; i < 100; i++){

            int n = rand.nextInt(100) + 1;

            System.setProperty("webdriver.chrome.driver","/home/maximilian/bin/chromedriver");

            // browse to url

            switch (country) {
                case 0: driver.get("https://demo-itec.aau.at/livelab/bd_crowd_shaka_dif_bd_US/survey.php");
                    country = 1;
                    break;
                case 1: driver.get("https://demo-itec.aau.at/livelab/bd_crowd_shaka_dif_bd_EE/survey.php");
                    country = 2;
                    break;
                case 2: driver.get("https://demo-itec.aau.at/livelab/bd_crowd_shaka_dif_bd_WE/survey.php");
                    country = 3;
                    break;
                case 3: driver.get("https://demo-itec.aau.at/livelab/bd_crowd_shaka_dif_bd_ASIA/survey.php");
                    country = 0;
            }

            // find element by name
            WebElement age = driver.findElement(By.name("age"));

            // insert data
            age.sendKeys(Integer.toString(n));

            driver.findElement(By.name("gender")).click();

            Select residents = new Select(driver.findElement(By.name("residents")));
            residents.selectByVisibleText("Albania");

            Select stateProvince = new Select(driver.findElement(By.name("state_province")));
            stateProvince.selectByVisibleText("Alaska");

            Select nationality = new Select(driver.findElement(By.name("nationality")));
            nationality.selectByVisibleText("Afghan");

            Select occupation = new Select(driver.findElement(By.name("occupation")));
            occupation.selectByVisibleText("Legal");

            Select education = new Select(driver.findElement(By.name("education")));
            education.selectByVisibleText("primary school");

            // submit form

            age.submit();

            // wait specific amount of time for an element to appear

            WebElement myDynamicElement = (new WebDriverWait(driver, 1000)).until(ExpectedConditions.presenceOfElementLocated(By.name("QoE")));

            myDynamicElement.submit();

            driver.findElement(By.name("participated")).click();
            driver.findElement(By.name("participated")).submit();



        }
        //Close the browser
        driver.quit();
    }
}