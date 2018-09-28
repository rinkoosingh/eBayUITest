package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import cucumber.api.java.en.Given;

public class HomePageSteps extends BaseSteps{
    HomePage homePage;
    public HomePageSteps() {
        homePage=new HomePage(getDriverInstance());
    }

    @Given("customer opens the ebay home page and search for (.*)")
    public void customerSearchForItem(String item) {
        homePage.searchItem(item);
    }

    @And("customer click on the (.*) item of product in search page and add to cart")
    public void clickOnFirstSearchedItemAndAddToCart(String count){
        homePage.clickOnSelectedIndexedItem(Integer.parseInt(count));
       // homePage.clickOnFirstSearchedItem();
        homePage.addToCart();
        homePage.goToCartConfirmation();
    }

    @Then("Customer verify (.*) items adds to the cart")
    public void verifyItemInCart(String itemCount){
        Assert.assertEquals(itemCount,homePage.getItemInCart());
    }

    @When("customer open the cart from any page")
    public void clickCart(){
        homePage.openCart();
    }
}
