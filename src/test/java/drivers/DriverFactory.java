package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

public class DriverFactory {
    public static DesiredCapabilities dc;
    public static WebDriver driver;

    private void initDriver(){

        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver");
        driver = new ChromeDriver();

// Firefox profile and driver settings

/*        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/geckodriver");
        ProfilesIni profile = new ProfilesIni();
        FirefoxProfile ffProfile= profile.getProfile("default");
        dc = DesiredCapabilities.firefox();
        dc.setCapability(FirefoxDriver.PROFILE,ffProfile);
        driver = new FirefoxDriver(dc);*/
    }

    public WebDriver getDriver(){
        if(driver==null){
            initDriver();
        }
         return driver;
    }

}
