package com.POM.PageManager;

import HelpsPOM.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class NewProjectPage {
    private WebDriver driver;
    private ValidateHelper validateHelper;

    public NewProjectPage(WebDriver driver) {
        this.driver = driver;
        validateHelper = new ValidateHelper(driver);
    }
    private By title = By.xpath("//*[@id=\"project_form\"]/div/h4");
    private By buttonProject = By.cssSelector("#project_form > div > div > div.panel-body > div.horizontal-scrollable-tabs.panel-full-width-tabs > div.horizontal-tabs > ul > li.active > a");
    private By inputProjectName = By.xpath("//*[@id=\"name\"]");
    private By buttonCustomer = By.xpath("//*[@id=\"tab_project\"]/div[2]/div/button");
    private By inputCustomer = By.xpath("//*[@id=\"tab_project\"]/div[2]/div/div/div[1]/input");
    private By clickCustomer = By.xpath("//*[@id=\"bs-select-6-0\"]");
    private By labelCalculate = By.xpath("//*[@id=\"tab_project\"]/div[3]/div/label");
    private By spanProgress = By.xpath("//*[@id=\"tab_project\"]/div[4]/span");
    private By selectBillingType = By.xpath("//*[@id=\"billing_type\"]");
    private By selectStatus = By.xpath("//*[@id=\"status\"]");
    private By inputTotalRate = By.xpath("//*[@id=\"project_cost\"]");
    private By inputEstimatedHours = By.xpath("//*[@id=\"estimated_hours\"]");
    private By buttonMembers = By.xpath("//*[@id=\"tab_project\"]/div[9]/div[2]/div/div/button");
    private By inputMembers = By.xpath("//*[@id=\"tab_project\"]/div[9]/div[2]/div/div/div/div[1]/input");
    private By inputStartDate = By.xpath("//*[@id=\"start_date\"]");
    private By inputDeadline = By.xpath("//*[@id=\"deadline\"]");
    private By inputTag = By.xpath("//*[@id=\"tab_project\"]/div[11]/ul/li/input");
    private By iframeDescription = By.xpath("//iframe[@id='description_ifr']");
    private By iframeBody = By.xpath("//*[@id=\"tinymce\"]");
    private By labelSendProjectCreatedEmail = By.xpath("//*[@id=\"tab_project\"]/div[13]/label");
    private By buttonSave = By.xpath("//*[@id=\"project_form\"]/div/div/div[2]/button");

    public void actionsNewProject() {
        validateHelper.verifyText(title,"Add new project");
        Assert.assertTrue(driver.findElement(buttonProject).getText().trim().toString().contains("Project"),"Project chưa được chọn");
        validateHelper.setText(inputProjectName,"TNT");
        validateHelper.clickElement(buttonCustomer);
        validateHelper.setSendKeysEnter(inputCustomer,"Anh tester 091311023");
        validateHelper.clickElement(clickCustomer);
        validateHelper.clickElement(labelCalculate);
        Actions actions = new Actions(driver);
        actions.clickAndHold(driver.findElement(spanProgress)).moveByOffset(100,0).release().perform();
        validateHelper.selectDropdownByText(selectBillingType,"Fixed Rate");
        validateHelper.selectDropdownByValue(selectStatus,"3");
        // Xử lý 2 cái này dùng action chứ sendkey bình thường và javascript không sử dụng được
        actions.moveToElement(driver.findElement(inputTotalRate)).click().sendKeys("5").perform();
        actions.moveToElement(driver.findElement(inputEstimatedHours)).click().sendKeys("8").perform();
        validateHelper.clickElement(buttonMembers);
        validateHelper.setSendKeysEnter(inputMembers,"Anh Tester Admin");
        validateHelper.clickElement(buttonMembers);
        driver.findElement(inputStartDate).clear();
        validateHelper.setText(inputStartDate,"08-09-2024");
        validateHelper.setText(inputDeadline,"12-09-2024");
        validateHelper.setText(inputTag,"abc");
        driver.switchTo().frame(driver.findElement(iframeDescription));
        validateHelper.setText(iframeBody,"Who are you");
        driver.switchTo().defaultContent();
        validateHelper.clickElement(buttonSave);
    }
}
