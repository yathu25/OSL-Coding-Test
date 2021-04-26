package checkoutSystem;



import java.math.BigDecimal;
import java.util.List;

import Models.Product;
import Models.ProductTypes;

public class FreeVgaDiscount implements PricingRule {

    private ProductTypes sku;
    private ProductTypes freeItem;

    public FreeVgaDiscount(ProductTypes pt, ProductTypes skuFreeItem) {
        sku = pt;
        freeItem = skuFreeItem;
    }

    @Override
    public void applySpecificRule(Basket basket) {
        List<Product> items = basket.getByProductType(sku);
        List<Product> itemsFree = basket.getByProductType(freeItem);
        for (int i = 0; i < itemsFree.size(); i++) {
            if (i < items.size() ) {
                Product product = itemsFree.get(i);
                product.changePrice(new BigDecimal(0));
            }
        }
    }
}
