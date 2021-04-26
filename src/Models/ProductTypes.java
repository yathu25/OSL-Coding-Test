package Models;

public enum ProductTypes {
	IPD ("IPD", "Super iPad"),
    MBP ("MBP", "MacBook Pro"),
    VGA ("VGA", "VGA adapter"),
	ATV ("ATV", "Apple TV");

    
    private final String Name;
    private final String Sku;

    ProductTypes(final String sku, final String name) {
        Sku = sku;
        Name = name;
    }

   
    public String getName(){
        return this.getName();
    }
    
    public ProductTypes getSKU() {
        return this.getSKU();
    }

}
