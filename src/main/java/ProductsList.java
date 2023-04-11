public class ProductsList {
    String prodName = "";
    double prodPrice;
    String totalPrice = "";

    String addProduct(String prodName, double prodPrice) {

        Format format = new Format();

        this.prodName = prodName;

        this.prodPrice = prodPrice;

        totalPrice = totalPrice + (prodName + ": " + format.roundingAll(prodPrice) + format.formatRuble(prodPrice) + "\n");
        return totalPrice;
    }

}