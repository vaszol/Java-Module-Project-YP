public class Product {
    private String name;
    private Double price = (double) -1;

    public Product(String product) {
        this.name = product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void print() {
        System.out.println(name + " по цене " + price + " успешно добавлен");
    }
}
