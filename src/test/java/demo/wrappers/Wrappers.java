package demo.wrappers;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Wrappers {
    /*
     * Write your selenium wrappers here
     */


public void inputText(WebElement Element ,String textToInput ){

Element.sendKeys(textToInput);

}

public long generateEpochTime(){

    long epochTime = Instant.now().getEpochSecond();
    
  return epochTime;  }



public void ScrollToElement (WebDriver driver , WebElement element){

    JavascriptExecutor js = (JavascriptExecutor) driver; 
    js.executeScript("arguments[0].scrollIntoView(true);", element);


}




}



