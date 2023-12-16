public class Formatter {

    public String formatPrice(double total) {
        return String.format("%.2f", total);
    }

    public Object formatCurrency(double total) {
        switch ((int) Math.floor(total)) {
            case 1:
                return "рубль";
            case 2:
            case 3:
            case 4:
                return "рубля";
            default:
                return "рублей";
        }
    }
}
