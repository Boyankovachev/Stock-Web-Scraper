import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Data {
    private List<Stock> stocks = new ArrayList<>();

    public void add_stock(Stock stock){
        this.stocks.add(stock);
    }
    public void add_stocks(List<Stock> stocks_to_add){
        this.stocks.addAll(stocks_to_add);
    }
    public List<Stock> get_stocks(){
        return stocks;
    }

    //they are alphabetically sorted by default
    public void print_all_stocks_alphabetically(){
        for(Stock stock : stocks){
            stock.print_stock();
        }
    }

    public void print_all_stocks_sorted_by_price_high_to_low(){
        List<Stock> list = stocks;
        int i;
        for(i=0; i<list.size()-1; i++) {
            for (int j = 0; j < list.size() - 1; j++) {
                if (list.get(j).get_price() < list.get(j + 1).get_price()) {
                    Collections.swap(list, j, j + 1);
                }
            }
        }
        for(Stock stock: list){
            stock.print_stock();
        }
    }

    public void print_all_stocks_sorted_by_price_low_to_high(){
        List<Stock> list = stocks;
        int i;
        for(i=0; i<list.size()-1; i++) {
            for (int j = 0; j < list.size() - 1; j++) {
                if (list.get(j).get_price() > list.get(j + 1).get_price()) {
                    Collections.swap(list, j, j + 1);
                }
            }
        }
        for(Stock stock: list){
            stock.print_stock();
        }
    }

    public void print_all_stocks_sorted_by_daily_change_most_negative_to_most_positive(){
        List<Stock> list = stocks;
        int i;
        for(i=0; i<list.size()-1; i++) {
            for (int j = 0; j < list.size() - 1; j++) {
                if (list.get(j).get_one_day_change() > list.get(j + 1).get_one_day_change()) {
                    Collections.swap(list, j, j + 1);
                }
            }
        }
        for(Stock stock: list){
            stock.print_stock();
        }
    }

    public void print_all_stocks_sorted_by_daily_change_most_positive_to_most_negative(){
        List<Stock> list = stocks;
        int i;
        for(i=0; i<list.size()-1; i++) {
            for (int j = 0; j < list.size() - 1; j++) {
                if (list.get(j).get_one_day_change() < list.get(j + 1).get_one_day_change()) {
                    Collections.swap(list, j, j + 1);
                }
            }
        }
        for(Stock stock: list){
            stock.print_stock();
        }
    }
}
