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

		co.scan(ATV);
        co.scan(IPD);
        co.scan(IPD);
		co.scan(ATV);
        co.scan(IPD);
        co.scan(IPD);
        co.scan(IPD);



        

	  BigDecimal total = co.total();
	  System.out.println(" Expected(2718.95) Total: "+total);
	  
	  
	}
}
