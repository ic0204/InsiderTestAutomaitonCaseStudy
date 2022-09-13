import org.openqa.selenium.WebElement;

import java.io.IOException;

public interface MainSteps {

    public void initializeDriver(String browser);

    public void seePage(String page);

    public void openUrl(String url);

    public WebElement findElement(String element,int index);

    public WebElement waitElement(String element, int timeout) throws InterruptedException, IOException;

    public boolean isDisplayedElement(String element, int index);

    public boolean isEnabledElement(String element, int index);

    public void selectDropDownBoxItem(String element,int index);

    public void clickElement(String element,int index) throws InterruptedException;


}
