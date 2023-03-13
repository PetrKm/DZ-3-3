import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String productName[] = {"Пшено", "Овсянка", "Рис", "Чечевица", "Гречка"};
        int productPrice[] = {30, 165, 100, 190, 150};
        double cart[] = new double[productName.length];

        System.out.println("Список возможных товаров для покупки:");
        for (int i = 0; i < productName.length; i++) {
            System.out.println((i + 1) + "." + productName[i] + " " + productPrice[i] + " " + "руб за кг.");
        }

        while (true) {
            System.out.println("Введите номер товара и количество товара, через пробел или введите end");
            String order = scanner.nextLine();
            if (order.equals("end")) {
                double sum = 0;
                for (int i = 0; i < productName.length; i++) {     // Расчет общей суммы.
                    sum += cart[i] * productPrice[i];
                }
                System.out.println("Ваша корзина:");     // Вывод информации о корзине.
                for (int i = 0; i < productName.length; i++) {
                    if (cart[i] == 0) continue;
                    System.out.println(productName[i] + " " + cart[i] + " кг. по цене: " + productPrice[i] + " руб., Итог: " + cart[i] * productPrice[i]);
                }
                System.out.println("Общая сумма: " + sum + "руб.");
                break;
            }
            String[] orderSplit = order.split(" ");
            if (orderSplit.length != 2) {  // Проверка на корректный ввод
                System.out.println("Некорректный ввод.");
                continue;
            } else if (Integer.parseInt(orderSplit[0]) > productName.length) {
                System.out.println("Номера с таким товаром нет.");
                continue;
            }
            int productNumber = Integer.parseInt(orderSplit[0]);
            double productQuantity = Double.parseDouble(orderSplit[1]);
            cart[productNumber - 1] = cart[productNumber - 1] + productQuantity;
        }
    }
}