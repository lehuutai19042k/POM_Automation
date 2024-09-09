package com.POM.PageManager;

import HelpsPOM.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class AddNewLeads {
    private WebDriver driver;
    private ValidateHelper validateHelper;
    public AddNewLeads(WebDriver driver) {
        this.driver = driver;
        validateHelper = new ValidateHelper(driver);
    }
    private By title = By.xpath("//*[@id=\"lead-modal\"]/div/div/div[1]/h4");
    private By buttonStatus = By.xpath("//*[@id=\"lead_form\"]/div[1]/div[3]/div[1]/div/div/div[1]/button");
    private By inputStatus = By.xpath("//*[@id=\"lead_form\"]/div[1]/div[3]/div[1]/div/div/div[1]/div/div[1]/input");
    private By buttonSource = By.xpath("//*[@id=\"lead_form\"]/div[1]/div[3]/div[2]/div/div/div[1]/button");
    private By inputSource = By.xpath("//*[@id=\"lead_form\"]/div[1]/div[3]/div[2]/div/div/div[1]/div/div[1]/input");
    private By buttonAssigned = By.xpath("//*[@id=\"lead_form\"]/div[1]/div[3]/div[3]/div/div/button");
    private By inputAssigned = By.xpath("//*[@id=\"lead_form\"]/div[1]/div[3]/div[3]/div/div/div/div[1]/input");
    private By inputTag = By.xpath("//*[@id=\"inputTagsWrapper\"]/ul[1]/li/input");
    private By inputName = By.xpath("/html/body/div[11]/div/div/div[2]/div/div/div[2]/div/div/form/div[1]/div[3]/div[7]/div[1]/input");
    private By inputAddress = By.xpath("//*[@id=\"address\"]");
    private By inputPosition = By.xpath("//*[@id=\"title\"]");
    private By inputCity = By.xpath("//*[@id=\"city\"]");
    private By inputEmailAddress = By.xpath("//*[@id=\"email\"]");
    private By inputState = By.xpath("//*[@id=\"state\"]");
    private By inputWebsite = By.xpath("//*[@id=\"website\"]");
    private By buttonCountry = By.xpath("//*[@id=\"lead_form\"]/div[1]/div[3]/div[8]/div[4]/div/button");
    private By inputCountry = By.xpath("//*[@id=\"lead_form\"]/div[1]/div[3]/div[8]/div[4]/div/div/div[1]/input");
    private By inputPhone = By.xpath("//*[@id=\"phonenumber\"]");
    private By inputZipCode = By.xpath("//*[@id=\"zip\"]");
    private By inputLeadValue = By.xpath("//*[@id=\"lead_form\"]/div[1]/div[3]/div[7]/div[6]/div/input");
    private By buttonDefaultLanguage = By.xpath("//*[@id=\"lead_form\"]/div[1]/div[3]/div[8]/div[6]/div/button");
    private By inputDefaultLanguage = By.xpath("//*[@id=\"lead_form\"]/div[1]/div[3]/div[8]/div[6]/div/div/div[1]/input");
    private By inputCompany = By.xpath("//*[@id=\"company\"]");
    private By inputDescription = By.xpath("//*[@id=\"description\"]");
    private By checkboxContactedToday = By.xpath("//*[@id=\"contacted_today\"]");
    private By labelContactedToday = By.xpath("//*[@id=\"lead_form\"]/div[1]/div[3]/div[9]/div[2]/div/div[3]/label");
    private By labelPublic = By.xpath("//*[@id=\"lead_form\"]/div[1]/div[3]/div[9]/div[2]/div/div[2]/label");
    private By inputDateContacted = By.xpath("//*[@id=\"custom_contact_date\"]");
    private By buttonSave = By.xpath("//*[@id=\"lead-form-submit\"]");

    public void actionsAddNewLeads() throws Exception{
        validateHelper.verifyText(title,"Add new lead");
        validateHelper.clickElement(buttonStatus);
        validateHelper.setSendKeysEnter(inputStatus,"Active");
        validateHelper.clickElement(buttonSource);
        validateHelper.setSendKeysEnter(inputSource,"Google");
        validateHelper.clickElement(buttonAssigned);
        validateHelper.setSendKeysEnter(inputAssigned,"Admin Example");
        validateHelper.setSendKeysEnter(inputTag,"abc");
        validateHelper.setText(inputName,"LHT");
        validateHelper.setText(inputAddress,"HCM");
        validateHelper.setText(inputPosition,"Nhân viên");
        validateHelper.setText(inputCity,"Thu Duc");
        validateHelper.setText(inputEmailAddress,"123@gmail.com");
        validateHelper.setText(inputState,"H03");
        validateHelper.setText(inputWebsite,"123.org.com");
        validateHelper.clickElement(buttonCountry);
        validateHelper.setSendKeysEnter(inputCountry,"Vietnam");
        validateHelper.setText(inputPhone,"01235466");
        validateHelper.setText(inputZipCode,"0545421");
        validateHelper.setText(inputLeadValue,"5");
        validateHelper.clickElement(buttonDefaultLanguage);
        validateHelper.setSendKeysEnter(inputDefaultLanguage,"Vietnamese");
        validateHelper.setText(inputCompany,"TNHH TH");
        validateHelper.setText(inputDescription,"Tập viết Automation");
        validateHelper.clickElement(labelPublic);
        /*validateHelper.verifyButtonSelected(checkboxContactedToday);*/
        validateHelper.clickElement(labelContactedToday);
        validateHelper.setSendKeysEnter(inputDateContacted,"07-09-2024 03:00");
        validateHelper.clickElement(buttonSave);
    }

}
