package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.w3c.dom.Text;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
// import io.github.bonigarcia.wdm.WebDriverManager;
import demo.wrappers.Wrappers;

public class TestCases {
    ChromeDriver driver;
Wrappers wrappers =new Wrappers();
    /*
     * TODO: Write your tests here with testng @Test annotation. 
     * Follow `testCase01` `testCase02`... format or what is provided in instructions
     */
    @Test
    public void testCase01()throws InterruptedException{   // Go to URL and Input Crio Learner ++++
        System.out.println( "Test 01 START");
        driver.navigate().to("https://forms.gle/wjPkzeSEk1CM7KgGA");
        Thread.sleep(3200);
    WebElement Name = driver.findElement(By.xpath("(//input[@jsname='YPqjbf'])[1]"));
       wrappers.inputText(Name,"Crio Learner");


        Thread.sleep(1000);
    
    System.out.println( "Test 01 END");
    }

    @Test
    public void testCase02()throws InterruptedException{   // Generate Epoch 
        System.out.println( "Test 02 START");
    
        WebElement Why = driver.findElement(By.xpath("//textarea[@jsname='YPqjbf']"));
      long Epoch = wrappers.generateEpochTime();
      System.out.println(">>"+Epoch);
        wrappers.inputText(Why, "I want to be the best QA Engineer! "+Epoch);
    System.out.println( "Test 02 END");
    }//div[@id='i13']
    

    @Test
    public void testCase03()throws InterruptedException{   // click years of EXP , 
        System.out.println( "Test 03 START");
        Thread.sleep(1200);
        
        WebElement Option01 = driver.findElement(By.xpath("//div[@id='i13']"));
        wrappers.ScrollToElement(driver,Option01);

        Option01.click();




List<WebElement> Optionss = driver.findElements(By.xpath("(//div[@class='rq8Mwb'])/parent::*"));

for (int i=1; i<=4;i++){
    Thread.sleep(2000);
    String text =driver.findElement(By.xpath("((//div[@class='rq8Mwb'])/parent::*)["+i+"]/following-sibling::div//span")).getText();
    //System.out.println(text);

    if(text.equals("Springboot")){
        Thread.sleep(1000);
        System.out.println(text+" NOT Clicked");

    }else{
        Thread.sleep(1000);
        driver.findElement(By.xpath("((//div[@class='rq8Mwb'])/parent::*)["+i+"]")).click();
        System.out.println(text+" Is Clicked");
    }

}
Thread.sleep(3000);



    
    System.out.println( "Test 03 END");
    }

    @Test  
    public void testCase04()throws InterruptedException{ 
        System.out.println( "Test 04 START");

if(driver.getCurrentUrl().contains("doc")){
    WebElement DDselect =driver.findElement(By.xpath("//div[@jscontroller='liFoG']//div[@jsname='wQNmvb']/span[(text()='Choose')]"));
      wrappers.ScrollToElement(driver,DDselect);
}else{

    driver.get("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");
    WebElement DDselect =driver.findElement(By.xpath("//div[@jscontroller='liFoG']//div[@jsname='wQNmvb']/span[(text()='Choose')]"));
 wrappers.ScrollToElement(driver,DDselect);
}

 WebElement DDselect =driver.findElement(By.xpath("//div[@jscontroller='liFoG']//div[@jsname='wQNmvb']/span[(text()='Choose')]"));
//  wrappers.ScrollToElement(driver,DDselect);

 DDselect.click();
Thread.sleep(3000);

//WebElement element =driver.findElement(By.xpath("(//div[@jscontroller='liFoG']//div[@jsname='wQNmvb']/span[normalize-space(text()) != ''])[2]/ancestor::div[5]"));
WebElement element=driver.findElement(By.xpath( "(//span[text()='Mr'])[2]"));
Actions actions = new Actions(driver);

// Perform a mouse click on the element
actions.moveToElement(element).click().perform();
  // Send the down arrow key
Thread.sleep(1000);  // Optionally, wait for 1 second before the next action
//DDselect.sendKeys(Keys.ENTER); 

Thread.sleep(3000);
System.out.println( "Test 04 END");
    }




    @Test
    public void testCase05()throws InterruptedException{ 
        System.out.println( "Test 05 START");

        if(driver.getCurrentUrl().contains("doc")){

        }else{
        
            driver.get("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");
            WebElement DDselect =driver.findElement(By.xpath("//div[@jscontroller='liFoG']//div[@jsname='wQNmvb']/span[(text()='Choose')]"));
         wrappers.ScrollToElement(driver,DDselect);
        }
        
        // Get the current date
        LocalDate today = LocalDate.now();

        // Define the date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // Format the date
        String formattedDate = today.format(formatter);

        // Print the formatted date
        System.out.println(formattedDate);

      
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
WebElement DateSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@jsname='YPqjbf'])[2]")));

Thread.sleep(2000);
DateSelect.sendKeys(formattedDate);






        LocalTime now = LocalTime.now();
        
        // Extract hours, minutes, and AM/PM
        DateTimeFormatter hourFormatter = DateTimeFormatter.ofPattern("hh");
        DateTimeFormatter minuteFormatter = DateTimeFormatter.ofPattern("mm");
        DateTimeFormatter amPmFormatter = DateTimeFormatter.ofPattern("a");

        String hours = now.format(hourFormatter);     // Hours in 12-hour format
        String minutes = now.format(minuteFormatter); // Minutes
        String amPm = now.format(amPmFormatter);      // AM or PM
        
        // Print AM or PM
        System.out.println("Current time is hours " + hours);
        System.out.println("Current time is minutes " + minutes);
        System.out.println("Current time is amPm " + amPm);
//         wrappers.ScrollToElement(driver,DateSelect);
//         Thread.sleep(2000);
//         // Locate the two input fields using XPath
//         WebElement hourField = driver.findElement(By.xpath("((//input[@type='text' and @class='whsOnd zHQkBf' and @jsname='YPqjbf'])[position() >last()-2])[1]"));
//         WebElement minuteField = driver.findElement(By.xpath("((//input[@type='text' and @class='whsOnd zHQkBf' and @jsname='YPqjbf'])[position() >last()-2])[2]"));
//      //   WebElement ampmField = driver.findElement(By.xpath("(//div[@jsname='d9BH4c'])[2]"));
//         WebElement AM = driver.findElement(By.xpath("(//span[text()='AM'])[2]"));
//         WebElement PM = driver.findElement(By.xpath("(//span[text()='PM'])[2]"));

//         // Input hours and minutes
//         hourField.sendKeys(hours);
//         minuteField.sendKeys(minutes);
//        // ampmField.click();
// if(amPm.equals("AM")){

// AM.click();
// System.out.println("clicked  " + AM);

// }else{
//     PM.click();
//     System.out.println("clicked  " + PM);
// }




DateSelect.sendKeys(Keys.TAB,Keys.TAB);
WebElement hoursInput = driver.switchTo().activeElement();
hoursInput.sendKeys(hours);
hoursInput.sendKeys(Keys.TAB);
WebElement minutesInput = driver.switchTo().activeElement();
Thread.sleep(1000);
minutesInput.sendKeys(minutes);
minutesInput.sendKeys(Keys.TAB);
WebElement ampm = driver.switchTo().activeElement();
//ampm.click();


Thread.sleep(5000);

WebElement submitBtw= driver.findElement(By.xpath("//span[text()='Submit']"));
submitBtw.click();

WebElement ResultTEXT =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Thanks for your response, Automation Wizard!']")));
String t=ResultTEXT.getText();
System.out.println(t);
System.out.println( "Test 05 END");


    }



     
    /*
     * Do not change the provided methods unless necessary, they will help in automation and assessment
     */
    @BeforeTest
    public void startBrowser()
    {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log"); 

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
       
    }
 

    @AfterTest
    public void endTest()
    {
        driver.close();
        driver.quit();

    }
}