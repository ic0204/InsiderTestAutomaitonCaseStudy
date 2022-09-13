package pages;

import org.openqa.selenium.By;

import java.util.Hashtable;

public abstract class BasePage {

    public Hashtable<String , By> pageElements;
    public Hashtable<String , By> commonElements;


    public BasePage(){
        this.pageElements = new Hashtable<>();
        this.commonElements = new Hashtable<>();

        commonElements.put("More button",By.xpath("//ul[@class='navbar-nav overflow-y']/li/a/span"));
        commonElements.put("Accept All button for Cookies",By.xpath("//div[@class='cli-bar-btn_container']//a[1]"));

    }
}
