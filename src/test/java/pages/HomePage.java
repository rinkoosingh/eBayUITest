package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage{
 private WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(className = "gh-tb")
    private WebElement searchTextBox;

    @FindBy(id = "gh-btn")
    private WebElement searchButton;

    @FindBys( {
            @FindBy(className = "s-item__link")
    } )
    private List<WebElement> itemLinks;


    @FindBy(id="atcRedesignId_btn")
    private WebElement addToCartButton;

    @FindBy(xpath = "/button[contains(text(),'Add plan')]")
    private WebElement addOnButton;

    @FindBy(id = "gh-cart-n")
    private WebElement itemInCart;

    public void searchItem(String item) {
        searchTextBox.sendKeys(item);
        searchButton.click();
    }

    public void clickOnFirstSearchedItem(){
        itemLinks.stream().findFirst().get().click();
    }

    public void clickOnSelectedIndexedItem(int index){
        itemLinks.get(index-1).click();
    }

    public void addToCart(){
        waitTillElementClickable(addToCartButton);
        addToCartButton.click();
    }

    @FindBy(className = "addonBtn")
    private WebElement buttonClass;

    public void clickOnNoThanksAddOn(){
        try{
            buttonClass.findElements(By.tagName("button")).stream().filter(item->item.getText().matches("No thanks"))
                    .findFirst().get().click();
        }

        catch(Exception e){
            //No Add on ...handled
        }
    }

    public String getItemInCart(){
        waitTillElementVisible(By.id("gh-cart-n"));
        return itemInCart.getText();
    }

    @FindBy(id = "sbin-gxo-btn")
    private WebElement continueAsGuestButton;

    public void continueAsGuest(){
        continueAsGuestButton.click();
    }

    @FindBy(xpath = "//span[contains(text(),'Go to cart')]")
    private WebElement goToCartButton;

    public void goToCartConfirmation(){
        waitTillElementClickable(goToCartButton);
        goToCartButton.click();
    }

    @FindBy(id = "gh-cart")
    private WebElement cartIcon;
    public void openCart() {
        cartIcon.click();
    }
}
