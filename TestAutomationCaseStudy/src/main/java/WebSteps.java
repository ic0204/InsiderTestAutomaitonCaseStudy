import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.openqa.selenium.support.ui.Select;

import pages.*;




public class WebSteps implements MainSteps {
    public WebDriver driver;
    public BasePage page;

    public void initializeDriver(String browser) {
        if (browser.equals("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--disable-notifications");
            WebDriverManager.chromedriver().setup();
            //System.setProperty("webdriver.chrome.driver", FileSystems.getDefault().getPath("").toAbsolutePath().toString() + "\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver(options);
        } else if (browser.equals("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--disable-notifications");
            WebDriverManager.firefoxdriver().setup();
           // System.setProperty("webdriver.gecko.driver", FileSystems.getDefault().getPath("").toAbsolutePath().toString() + "\\geckodriver\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
    }

    public void seePage(String pageName) {
        switch (pageName) {
            case "home":
                page = new HomePage();
                break;
            case "career":
                page = new CareersPage();
                break;
            case "open position":
                page = new OpenPositionsPage();
                break;
            case "quality assurance pages":
                page = new QualityAssurancePage();
                break;
            default:
                break;
        }
    }

    public void openUrl(String url) {
        this.driver.navigate().to(url);
        System.out.println(url + " address was reached.");
    }


    public WebElement findElement(String element, int index) {
        try {
            WebElement object;
            //HKC burası hep boş geliyor sanki
            By elem = page.pageElements.get(element);

            if (elem == null) {
                elem = page.commonElements.get(element);
            }
            object = driver.findElements(elem).get(index);


            System.out.println("Object found : " + element);
            return object;
        } catch (Exception e) {
            //Assert.fail("Element is not found!");
            return null;
        }
    }

    public WebElement waitElement(String element, int timeout) throws InterruptedException {
        WebElement object;
        for (int i = 0; i < timeout; i++) {

            object = findElement(element, 0);
            if (object != null) {
                Thread.sleep(2000);
                return object;
            } else {
                Thread.sleep(2000);
            }
        }


        Assert.fail("Waiting element is not found!");
        return null;
    }

    public void clickElement(String element, int index) throws InterruptedException {
        WebElement object = waitElement(element, 30);
        WebElement webElement=null;
        if (object != null) {
            try {
                webElement=findElement(element, index);
                webElement.click();
            } catch (ElementClickInterceptedException e) {
                JavascriptExecutor jsexecutor = ((JavascriptExecutor) driver);
                jsexecutor.executeScript("arguments[0].click();", webElement);
            }
            System.out.println("Clicked on object-->" + element);
        } else {
            System.out.println("Could not click on object-->" + element);
        }
    }

    public boolean isDisplayedElement(String element, int index) {
        WebElement object;
        object = findElement(element, 0);
        if (object == null) {

            System.out.println("This element situation is not displayed");
            return false;
        } else if (object.isDisplayed()) {

            System.out.println("This element situation is displayed");
            return true;
        } else {
            System.out.println("This element situation is not displayed");
            return false;
        }

    }

    public boolean isEnabledElement(String element, int index){
        JavascriptExecutor jsExecutor = ((JavascriptExecutor)driver);

        jsExecutor.executeScript("window.scrollBy(0,2000)");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement webElement = findElement(element,0);



        if(webElement==null){
            System.out.println("This element situation is not 1enabled");
            return false;
        }else if(webElement.isEnabled()){
            System.out.println("This element situation is enabled");
            return true;
        }else{

            System.out.println("This element situation is not displayed");
            return false;
        }
    }

    public void selectDropDownBoxItem(String element,int index ){
        WebElement object = findElement(element,0);
        Select dropBoxItem = new Select(object);
        dropBoxItem.selectByVisibleText("Istanbul, Turkey");
    }
    public  void goToNewTab(){
        for (String handle : driver.getWindowHandles()) {
            if(!driver.getWindowHandle().equals(handle)) {
                driver.switchTo().window(handle);
                return;
            }
        }
    }




}