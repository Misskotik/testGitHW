package ru.misskotik;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class AppTest1
{
    public static void main( String[] args ) throws InterruptedException  {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions ();
        options.addArguments("start-maximized");
        options.addArguments("--incognito");
        options.addArguments("disable-popup-blocking");


        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get ("https://www.saucedemo.com");
        driver.manage().window().maximize();

        driver.findElement(By.id("user-name")).sendKeys ("standard_user");
        driver.findElement(By.id("password")).sendKeys ("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.xpath(".//div[@id='shopping_cart_container']/a")).click();
        driver.quit();


    }
}
