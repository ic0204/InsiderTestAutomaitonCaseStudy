package pages;

import org.openqa.selenium.By;

import java.util.Hashtable;

public class OpenPositionsPage extends BasePage {
    public Hashtable<String, By> openPositionSPageElement;

    public OpenPositionsPage() {
        super();
        this.openPositionSPageElement = new Hashtable<>();


        openPositionSPageElement.put("QA Assurance Engineer Position button", By.xpath("//p[text()='Software Quality Assurance Engineer']"));
        openPositionSPageElement.put("Apply Now button for QA Assurance Engineer Position",By.xpath("//p[text()='Software Quality Assurance Engineer']/following-sibling::a"));
        openPositionSPageElement.put("closed Location DropBox", By.cssSelector("span#select2-filter-by-location-container"));
        openPositionSPageElement.put("opened Location DropBox", By.xpath("//select[@id='filter-by-location']"));
        this.pageElements=openPositionSPageElement;
    }
}
