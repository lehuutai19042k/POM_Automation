package HelpsPOM;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.List;

public class ValidateHelper {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;
    private final int timeoutWaitForPageLoad = 20;
    private Select select;

    public ValidateHelper(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutWaitForPageLoad));
        actions = new Actions(driver);
    }
    public void setText(By element, String value){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).sendKeys(value);
    }
    public void clickElement(By element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();
    }
    public boolean verifyUrl(String value){
        waitForPageLoaded();
        return driver.getCurrentUrl().contains(value);
    }
    // Hàm dùng để xác minh xem cái title hay một text đặc trưng của page đã đúng chưa
    public boolean verifyText(By element, String value){
        /*waitForPageLoaded();*/
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        return driver.findElement(element).getText().trim().toString().equals(value);
    }
    // Handle dropdown tĩnh
    public void selectDropdownByText(By element, String text){
        select = new Select(driver.findElement(element));
        // không nên để hàm chờ ở đây vì sẽ xảy ra lỗi
        // wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        select.selectByVisibleText(text);
    }
    public void selectDropdownByValue(By element, String value){
        select = new Select(driver.findElement(element));
        // wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        select.selectByValue(value);
    }
    public void selectDropdownByIndex(By element, int index){
        select = new Select(driver.findElement(element));
        // wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        select.selectByIndex(index);
    }
    // Hàm kiểm tra xem tổng các lựa chọn có bằng số lựa chọn thực tế không
    // multiply để xem tổng số option có bằng tổng option thực tế không
    public void verifyOptionTotal(By element, int total){
        select = new Select(driver.findElement(element));
        Assert.assertEquals(total, select.getOptions().size());
    }
    // Hàm xử lý load trang
    public void waitForPageLoaded(){
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>(){
            @Override
            public Boolean apply(WebDriver driver){
                try {
                    return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
                } catch (Exception e){
                    return true;
                }
            }
        };
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor)driver).executeScript("return document.readyState").toString().equals("complete");
            }
        };
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutWaitForPageLoad));
            wait.until(jQueryLoad);
            wait.until(jsLoad);
        }catch (Throwable error){
            Assert.fail("Quá thời gian load trang");
        }
    }
    // Handle khi sendkey dropdown
    public void setSendKeysEnter(By element, String text){
        /*waitForPageLoaded(); dùng khi để verify search*/
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).sendKeys(text);
        actions.sendKeys(Keys.ENTER).build().perform();
    }
    // Hàm verify các giá trị khi search
    public void verifySearch(int colum, String value){
        // Lấy xpath này là lấy toàn phân vùng các giá trị mà khi search tìm ra
        List<WebElement> row = driver.findElements(By.xpath("//table//tbody/tr"));
        int rowTotal = row.size();
        for (int i = 1; i <= rowTotal; i++){
            // Xpath này lấy đúng cột có giá trị cần kiểm tra và thực hiện chạy từ đầu đến cuối
            WebElement elementCheck = driver.findElement(By.xpath("//table//tbody/tr["+i+"]/td["+colum+"]"));
            // Hàm này là chuyển về chữ hoa và so sánh xem giá trị của những cột search ra có chứa ký tự search hay không
            Assert.assertTrue(elementCheck.getText().toUpperCase().contains(value.toUpperCase()),"Không chứa giá trị cần tìm");
        }
    }
    public void verifyHighLight(By element, String attribute, String value){
        // Kiểm tra xem element Dashboard có được chọn hay chưa, nếu được chọn thì sẽ có active
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        Assert.assertTrue(driver.findElement(element).getAttribute(attribute).contains(value),"Thẻ chưa được chọn");
    }
    // Hàm này khó verify do các element checkbox khó check
    public void verifyButtonSelected(By element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        Assert.assertTrue(driver.findElement(element).isSelected(),"Checkbox chưa được chọn");
    }
}
