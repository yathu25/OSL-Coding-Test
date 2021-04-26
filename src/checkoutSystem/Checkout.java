package checkoutSystem;

import java.math.BigDecimal;
import java.util.Map;

import Models.Product;
import Models.ProductTypes;


public class Checkout {
	 private Basket basket = new Basket();
	    private Map<ProductTypes, PricingRule> pricingRules;
	    private Store store;

	    public Checkout(Map<ProductTypes, PricingRule> pricingRules) {
	        this.pricingRules = pricingRules;
	    }

	    public void scan (ProductTypes type) throws ProductDoesNotExistException {
	        if (type == null) {
	            throw new ProductDoesNotExistException("Supplied product does not exist in catalogue");
	        }

	        Product item = store.getCatalogue().newItem(type);
	        basket.addCartItem(item);

	        PricingRule rule = pricingRules.get(type);
	        if (rule != null) {
	            rule.applySpecificRule(basket);
	        }
	    }

	    public BigDecimal total() {
	        return basket.getTotal();
	    }

	    public void setStore(Store store) {
	        this.store = store;
	    }
}

 class ProductDoesNotExistException extends Exception {
    public ProductDoesNotExistException(String message) {
        super(message);
    }
}
