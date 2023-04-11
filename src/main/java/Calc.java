public class Calc {

    int personCounter;

    double allPrice;
    double personalPrice;


    double calcPersonPrice(int personCounter, double allPrice) {

        this.allPrice = allPrice;
        this.personCounter = personCounter;
        personalPrice = this.allPrice / this.personCounter;

        return personalPrice;

    }
}
