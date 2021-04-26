package checkoutSystem;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import Models.Product;
import Models.ProductTypes;

public class ExtraFreeDiscount implements PricingRule {

    private ProductTypes sku;
    private int baseQuantity;
    private int chargeQuantity;

    public ExtraFreeDiscount(ProductTypes pt, int baseQuantity, int chargeQuantity) {
        sku = pt;
        this.baseQuantity = baseQuantity;
        this.chargeQuantity = chargeQuantity;
    }

    @Override
    public void applySpecificRule(Basket basket) {
        List<Product> items = basket.getByProductType(sku);
        for (int i = 0; i < items.size(); i++) {
            if ( i + 1 == baseQuantity) {
                Product item = items.get(i);
                item.changePrice(new BigDecimal(0));
            }
        }
    }
}
