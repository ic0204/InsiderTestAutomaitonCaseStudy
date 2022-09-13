package pages;

import org.openqa.selenium.By;

import java.util.Hashtable;

public class HomePage extends BasePage{

    public Hashtable<String, By> homeElements;

    public HomePage(){
        super();
        this.homeElements = new Hashtable<>();
        homeElements.put("Announcement button", By.xpath("//span[text()=' – Join A Brand New Way™ Movement > SAVE THE DATE']"));
        homeElements.put("Careers button",By.xpath("//h5[text()='Careers']"));
        homeElements.put("Connect button",By.xpath("//h1[@data-slide-index='0']"));
        homeElements.put("Predict button",By.xpath("//h1[@data-slide-index='1']"));
        homeElements.put("Individualize button",By.xpath("//h1[@data-slide-index='2']"));

        this.pageElements=homeElements;


    }

}
