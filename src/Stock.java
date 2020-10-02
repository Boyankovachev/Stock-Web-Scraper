public class Stock {
    private final String name;
    private final double price;
    private final double one_day_change;
    private final double three_month_change;
    private final double six_month_change;
    private final double twelve_month_change;

    Stock(String name, double price, double one_day_change, double three_month_change, double six_month_change, double twelve_month_change){
        this.name = name;
        this.price = price;
        this.one_day_change = one_day_change;
        this.three_month_change = three_month_change;
        this.six_month_change = six_month_change;
        this.twelve_month_change = twelve_month_change;
    }
    public String get_name(){
        return name;
    }
    public double get_price(){
        return price;
    }
    public double get_one_day_change(){
        return one_day_change;
    }
    public double get_three_month_change(){
        return three_month_change;
    }
    public double get_six_month_change(){
        return six_month_change;
    }
    public double get_twelve_month_change(){
        return twelve_month_change;
    }

    public void print_stock(){
        System.out.println(this.name + "  " + this.price + "  " + this.one_day_change + "  " +
                this.three_month_change + "  " + this.six_month_change + "  " + this.twelve_month_change);
    }
}

