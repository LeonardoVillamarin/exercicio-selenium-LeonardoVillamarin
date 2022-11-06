package exselenium;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExSelenium {
	
	public WebDriver driver;
	
	@BeforeClass
	public static void configuraDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\leovi\\Documents\\chromedriver.exe");
	}
	
    @Before
    public void createDriver() {  
    
		driver = new ChromeDriver();
        driver.get("https://pt.wikipedia.org/");
    }	

	@Test
	public void test() {
		WebElement search = driver.findElement(By.xpath("/html/body/div[1]/div/header/div[2]/div/a"));
		
		search.click();
		
		WebElement search_input = driver.findElement(By.name("search"));
		
		search_input.sendKeys("Beyoncé", Keys.RETURN);

		WebElement search_result = driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/main/div[2]/div[3]/div[3]/div[2]/ul/li[1]/table/tbody/tr/td[2]/div[1]/a/span"));
		
		search_result.click();
		
		new WebDriverWait(driver, 30).until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

		String idade = driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/main/div[2]/div[3]/div[1]/table[1]/tbody/tr[5]/td[2]/span")).getText();
		
		idade = idade.replace(" de 1981 (41 anos)", "");
		
		assertTrue(idade.equals("4 de setembro"));
	}
	
    @After
    public void quitDriver() {
       driver.quit();
    }
}
