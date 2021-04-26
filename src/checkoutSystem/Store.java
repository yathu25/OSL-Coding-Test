package checkoutSystem;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import Models.Product;
import Models.ProductTypes;
import utils.Menu;


public class Store {
	private Menu menu = new Menu();
    private Map<ProductTypes,PricingRule> pricingRules = new HashMap<>();

    public Store() {
        menu.addProduct(new Product(ProductTypes.IPD,  new BigDecimal("549.99")));
        menu.addProduct(new Product(ProductTypes.MBP, new BigDecimal("1399.99")));
        menu.addProduct(new Product(ProductTypes.VGA,  new BigDecimal("30.00")));
        menu.addProduct(new Product(ProductTypes.ATV,  new BigDecimal("109.50")));
        pricingRules.put(ProductTypes.ATV, new ExtraFreeDiscount(ProductTypes.ATV, 3, 2));
        //The brand new Super iPad will have a bulk discounted applied, where the price will drop to $499.99 each, if someone buys more than 4
        pricingRules.put(ProductTypes.IPD, new DiscountOnBulk(ProductTypes.IPD, 4, new BigDecimal("499.99")));
        //We will bundle in a free VGA adapter free of charge with every MacBook Pro sold
        pricingRules.put(ProductTypes.VGA, new FreeVgaDiscount(ProductTypes.MBP, ProductTypes.VGA));

    }

    public Menu getCatalogue() {
        return menu;
    }

    public Map<ProductTypes, PricingRule> getPricingRules() {
        return pricingRules;
    }
}
