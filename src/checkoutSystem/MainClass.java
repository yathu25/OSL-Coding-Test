package checkoutSystem;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

import Models.ProductTypes;
import static Models.ProductTypes.*;



public class MainClass {
	

	public static void main(String[] args) throws IOException, ProductDoesNotExistException {
		
		Store store = new Store();
		Map<ProductTypes, PricingRule> pricingRules = store.getPricingRules();
		Checkout co = new Checkout(pricingRules);
		co.setStore(store);
		System.out.println("Test");

		co.scan(MBP);
        co.scan(VGA);
        co.scan(IPD);

	  BigDecimal total = co.total();
	  System.out.println(" Expected(249.00) Total: "+total);
	  
	  
	}
}
