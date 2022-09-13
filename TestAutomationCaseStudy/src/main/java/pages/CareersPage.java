package pages;

import org.openqa.selenium.By;

import java.util.Hashtable;

public class CareersPage extends BasePage {

    public Hashtable<String, By> careersElement;

    public CareersPage(){
        this.careersElement = new Hashtable<>();

        careersElement.put("Teams title",By.xpath("//h3[text()[normalize-space()='Find your calling']]"));
        careersElement.put("Location title",By.xpath("//h3[@class='category-title-media ml-0']"));
        careersElement.put("Life at Insider title",By.xpath("//h2[text()='Life at Insider']"));
        careersElement.put("See all teams button", By.xpath("//a[contains(@class,'btn btn-outline-secondary')]"));
        careersElement.put("Quality Assurance button",By.xpath("//h3[text()='Quality Assurance']"));
        this.pageElements=careersElement;

    }
}
