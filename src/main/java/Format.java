public class Format {

    double allPrice;

    public String formatRuble(double allPrice) {

        this.allPrice = (int)allPrice;

        if((this.allPrice % 100 >= 11) && (this.allPrice % 100 <= 14)) {

            return " рублей";

        } else {

            switch ((int)this.allPrice % 10) {
                case 1:
                    return " рубль";
                case 2:
                case 3:
                case 4:
                    return " рубля";
                default:
                    return " рублей";
            }
        }
    }

    String roundingAll(double price) {
        return String.format("%.2f", price);
    }
}
