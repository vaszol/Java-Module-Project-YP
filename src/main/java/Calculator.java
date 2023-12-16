import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    int count = -1;
    Scanner scanner = new Scanner(System.in);
    List<Product> cart = new LinkedList<>();
    double total;
    Formatter formatter = new Formatter();

    public void start() {
        do {
            System.out.println("на скольких человек необходимо разделить счёт?");
            if (scanner.hasNextInt()) {
                count = scanner.nextInt();
            } else {
                scanner.next();
            }

            if (count == 1) {
                System.out.println("тут ничего считать и делить");
            } else if (count < 1) {
                System.out.println("укажите целое число, больше 1");
            } else {
                setCart();
                result();
            }
        } while (count < 1);
        scanner.close();
    }

    /**
     * Добавление товаров в калькулятор
     */
    private void setCart() {
        while (true) {
            System.out.println("укажите название товара или введите команду \"Завершить\"");
            Product product = new Product(scanner.next());
            if (product.getName().equalsIgnoreCase("Завершить")) {
                break;
            }
            do {
                System.out.println("укажите стоимость " + product.getName());
                if (scanner.hasNextDouble()) {
                    product.setPrice(scanner.nextDouble());
                } else {
                    scanner.next();
                }
            } while (product.getPrice() < 0);
            cart.add(product);
            total = cart.stream().mapToDouble(Product::getPrice).sum();
            product.print();
        }
    }

    private void result() {
        System.out.println("Добавленные товары:");
        cart.forEach(product -> System.out.println(product.getName() + " " + formatter.formatPrice(product.getPrice())));
        System.out.printf("Текущая общая сумма всех товаров %s %s%n", formatter.formatPrice(total), formatter.formatCurrency(total));
        System.out.printf("сумма, которую должен заплатить каждый поровну = %s%n", formatter.formatPrice(total / count));
    }
}
