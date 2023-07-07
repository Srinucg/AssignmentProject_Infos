package helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {

    public WebDriver driver;

    public static ThreadLocal<WebDriver> sscmDriver = new ThreadLocal<>();


    public WebDriver init_driver(String browser) {

        System.out.println("browser value is: " + browser);

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                sscmDriver.set(new ChromeDriver());


                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                sscmDriver.set(new FirefoxDriver());
                break;
            case "safari":
                sscmDriver.set(new SafariDriver());
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                sscmDriver.set(new EdgeDriver());
                break;
            case "htmlunit":
                //   driver = new HtmlUnitDriver();
                WebDriverManager.getInstance(HtmlUnitDriver.class).setup();
                sscmDriver.set(new HtmlUnitDriver());
                break;
            case "isHeadless":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                options.addArguments("--no-sandbox");


            default:
                System.out.println("Please pass the correct browser value: " + browser);
                break;
        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();

    }

    public static synchronized WebDriver getDriver() {
        return sscmDriver.get();
    }


}

