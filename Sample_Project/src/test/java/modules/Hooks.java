package modules;


import com.aventstack.extentreports.service.ExtentService;
import helpers.BrowserFactory;
import helpers.ConfigReader;
import helpers.FunctionsLibrary;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageobjects.Savings;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class Hooks {

    public static WebDriver driver;

    private ConfigReader configReader;
    private BrowserFactory driverFactory;
    Properties prop;



    Logger log =Logger.getLogger(Hooks.class);

    public static FunctionsLibrary functionsLibrary;
    public static SoftAssertions softAssertions;


   public static  Savings  SavingsPageObj = new Savings();

    public static Scenario scenario;




    @Before(order = 0)
    public void getProperty() {
        configReader = new ConfigReader();
        prop = configReader.init_prop();
    }


    @Before(order = 1)
    public void setUp() throws InterruptedException {

        log.info("Set up");




        String browserName = prop.getProperty("browser");
        BrowserFactory driverFactory = new BrowserFactory();
        driver = driverFactory.init_driver(browserName);


        log.info("Open browser");
        driver.manage().window().maximize();
      //  driver.manage().window().setSize(new Dimension(1920, 1080));

        Thread.sleep(5000);

        log.info("Maxmize window");


        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        functionsLibrary = new FunctionsLibrary(driver);
        softAssertions = new SoftAssertions();

        PageFactory.initElements(driver, SavingsPageObj);



    }

    @Before(order = 2)
    public void printName(Scenario scenario){

        Collection<String> tags = scenario.getSourceTagNames();

        Properties prop = new Properties();


        prop.setProperty("extent.reporter.spark.out", "target/test-output/" + tags + ".html");

        
        ExtentService e1 = new ExtentService();
        Class<?>[] a = e1.getClass().getDeclaredClasses();

        Method met;
        try {

            met = a[0].getDeclaredMethod("initSpark", Properties.class);

            met.setAccessible(true);
            met.invoke(a[0], prop);

        } catch (NoSuchMethodException e) {
            System.out.println("There is no method with name inithtml");
        } catch (IllegalAccessException e) {
            System.out.println("Arugment passed method with name inithtml");
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }


    @After(order = 1)

    public void afterFailedScenario(Scenario scenario) throws IOException {




        Collection<String> screenshotName = scenario.getSourceTagNames();

        if (scenario.isFailed()) {

            log.error("Check the particular Test case step because due to xpath issue/loading issue");

            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

            scenario.attach(sourcePath, "image/png", String.valueOf(screenshotName));


        }
    }

    @After (order = 0)
    public void Scenario() {

        // driver.quit();
    }

}




