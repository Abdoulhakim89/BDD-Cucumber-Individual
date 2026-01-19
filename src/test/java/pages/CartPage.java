package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage{
    private By qtyInput = By.cssSelector(".qty");
    private WebElement trow;
    private By proceedToCheckoutButton =By.className("checkout-button");


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName(String product){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[td[a[contains(text(),'"+product+"')]]]")));
        trow = driver.findElement(By.xpath("//tr[td[a[contains(text(),'"+product+"')]]]"));
        return trow.findElement(By.xpath("//a[contains(text(),'"+product+"')]")).getText();
    }
    public int getProductQuantity(){
        return  Integer.parseInt(trow.findElement(qtyInput).getAttribute("value"));

    }
    public void proceedToCheckout(){
        driver.findElement(proceedToCheckoutButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("place_order")));
    }
}
