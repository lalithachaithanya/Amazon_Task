package amazonTask;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class amazonClass {
	
	public static WebDriver driver;
	
	public static void screenshot(String im) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File sc = ts.getScreenshotAs(OutputType.FILE);
		File imgpath=new File("C:\\Users\\krish\\eclipse-workspace\\amazon\\image\\"+im+".jpeg");
		Files.copy(sc, imgpath);
	}
	
	public static void screenshotusingelement(WebElement ele, String im) throws IOException {
		
		File sc = ele.getScreenshotAs(OutputType.FILE);
		File imgPath = new File("C:\\Users\\krish\\eclipse-workspace\\amazon\\image\\"+im+".jpeg");
		Files.copy(sc, imgPath);
		
	}

	public static void jsscroll(WebElement ele) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()",ele);
		
		
		
		
	}
	public static void main(String[] args) throws IOException {
		
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in/");
		
		screenshot("cs");
		
		WebElement cs = driver.findElement(By.xpath("//button[text()='Continue shopping']"));
		screenshotusingelement(cs, "Lalu");
		cs.click();
		
		WebElement bs = driver.findElement(By.xpath("//a[text()='Bestsellers']"));
		bs.click();
		
		screenshot("bspage");
		
		
		
		
		
		
		
		
		

		
	}
}
