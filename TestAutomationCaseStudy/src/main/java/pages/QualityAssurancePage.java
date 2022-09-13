package pages;

import org.openqa.selenium.By;

import java.util.Hashtable;

public class QualityAssurancePage extends BasePage {
    public Hashtable<String, By> qAssuranceElements;


    public QualityAssurancePage(){
        super();
        this.qAssuranceElements=new Hashtable<>();
        qAssuranceElements.put("See all QA jobs button",By.cssSelector("section#page-head>div>div>div>div>div>a"));
        this.pageElements=qAssuranceElements;
    }

}
