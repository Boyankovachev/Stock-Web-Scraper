import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class WebScraper {

    private Data data = new Data();
    public Data get_data(){
        return data;
    }

    private List<Stock> web_scrape_data(String string, int j){
        try {
            Document document;
            if(j==-1){
                document = Jsoup.connect(string).get();
            }
            else {
                document = Jsoup.connect(string + j).get();
            }
            Elements rows = document.select("table.table.table-small tbody tr");
            List<Stock> data = new ArrayList<>();
            int i;
            for (i = 1; i < rows.size(); i++) {

                //Selecting the data
                String name = rows.get(i).select("td:nth-child(1) > a").text();
                String price = rows.get(i).select("td:nth-child(2)").text();
                String change = rows.get(i).select("td:nth-child(5) > span:nth-child(3)").text();
                String _3_month_change = rows.get(i).select("td:nth-child(8) > span:nth-child(3)").text();
                String _6_month_change = rows.get(i).select("td:nth-child(9) > span:nth-child(3)").text();
                String _12_month_change = rows.get(i).select("td:nth-child(10) > span:nth-child(3)").text();

                //Transforming the data to doubles and removing unnecessary chars
                String [] prices = price.split(" ");
                price = prices[0];
                price = price.replace(",", "");
                double price_double = Double.parseDouble(price);
                change = change.replace("%","");
                _3_month_change = _3_month_change.replace("%","");
                _6_month_change = _6_month_change.replace("%","");
                _12_month_change = _12_month_change.replace("%","");
                double change_double = Double.parseDouble(change);
                double  _3_month_change_double = Double.parseDouble(_3_month_change);
                double _6_month_change_double = Double.parseDouble(_6_month_change);
                double _12_month_change_double = Double.parseDouble(_12_month_change);

                Stock stock = new Stock(name,price_double,change_double,_3_month_change_double,_6_month_change_double,_12_month_change_double);
                data.add(stock);
            }
            return data;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void read_snp500_data(){
        String string = "https://markets.businessinsider.com/index/components/s&p_500?p=";
        int j;
        for(j=1; j<=10; j++){
            data.add_stocks(web_scrape_data(string, j));
        }
    }

    public void read_dow_jones_data(){
        String string = "https://markets.businessinsider.com/index/components/dow_jones";
        int j = -1;
        data.add_stocks(web_scrape_data(string, j));
    }

    public void read_nasdaq100_data(){
        String string = "https://markets.businessinsider.com/index/components/nasdaq_100?p=";
        int j;
        for(j=1; j<=2; j++){
            data.add_stocks(web_scrape_data(string, j));
        }
    }

    public void read_ftse100_data(){
        String string = "https://markets.businessinsider.com/index/components/ftse_100?p=";
        int j;
        for(j=1; j<=3; j++){
            data.add_stocks(web_scrape_data(string, j));
        }
    }

    public void read_estoxx_data(){
        String string = "https://markets.businessinsider.com/index/components/euro_stoxx_50";
        int j = -1;
        data.add_stocks(web_scrape_data(string, j));
    }

    public void read_dax_data(){
        String string = "https://markets.businessinsider.com/index/components/dax";
        int j = -1;
        data.add_stocks(web_scrape_data(string, j));
    }
}

