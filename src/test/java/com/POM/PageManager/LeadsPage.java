package com.POM.PageManager;

import HelpsPOM.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeadsPage {
    private WebDriver driver;
    private ValidateHelper validateHelper;
    public LeadsPage(WebDriver driver) {
        this.driver = driver;
        validateHelper = new ValidateHelper(driver);
    }
    private By spanLeads = By.xpath("//*[@id=\"side-menu\"]/li[11]");
    private By buttonNewLead = By.xpath("//*[@onclick='init_lead(); return false;']");
    public AddNewLeads actionsLeadsPage(){
        validateHelper.verifyUrl("/leads");
        validateHelper.verifyHighLight(spanLeads,"class","active");
        validateHelper.clickElement(buttonNewLead);
        return new AddNewLeads(driver);
    }
}
