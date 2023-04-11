import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        ProductsList productsList = new ProductsList();
        Calc calc = new Calc();
        Format format = new Format();

        int inputCount;
        Scanner scanner = new Scanner(System.in);




        System.out.println("На сколько персон вы бы хотели разделить ваш счет ?");
        while(true) {
            if(!scanner.hasNextInt()) {

                System.out.println("Неправильный ввод количества человек, повторите попытку ввода");
                scanner.next();

            } else {
                inputCount = scanner.nextInt();
                if(inputCount > 1) {
                    break;
                }
                System.out.println("Неправильное значение для рассчета");
            }
        }
        System.out.println("Счет необходимо разделить на " + inputCount + " персон");

        calc.personCounter = inputCount;
        while(true) {
            System.out.println("Введите название товара или команду Завершить");
            productsList.prodName = scanner.next();

            if (productsList.prodName.equalsIgnoreCase("Завершить")) {
                break;
            }
            System.out.println("Введите стоимость блюда");
            while(!scanner.hasNextDouble()) {

                System.out.println("Неправильный ввод данных, повторите попытку");
                scanner.next();

            }
            productsList.prodPrice = scanner.nextDouble();

            while(productsList.prodPrice <= 0) {

                System.out.println("Некорректная цена блюда, введите корректную цену");

                while(!scanner.hasNextDouble()) {

                    System.out.println("Неправильный ввод данных, повторите попытку");
                    scanner.next();

                }

                productsList.prodPrice = scanner.nextDouble();

            }


            calc.allPrice = calc.allPrice + productsList.prodPrice;


            productsList.totalPrice = productsList.addProduct(productsList.prodName, productsList.prodPrice);



            System.out.println("Блюдо добавлено в ваш счет");
        }

        if (calc.allPrice <= 0) {
            System.out.println("Вы ничего не заказывали, для оплаты нужно что то заказать");
        } else {

            System.out.println("Добавленные товары: \n" + productsList.totalPrice);
            System.out.println(
                            "Каждый человек должен заплатить по: "
                            + format.roundingAll(calc.calcPersonPrice(calc.personCounter, calc.allPrice))
                            + format.formatRuble(calc.calcPersonPrice(calc.personCounter, calc.allPrice))
            );
        }
        scanner.close();
    }
}