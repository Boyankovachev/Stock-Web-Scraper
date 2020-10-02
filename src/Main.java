import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static public void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("The list of available stock markets:");
            System.out.println("1: S&P500\n2: DOW JONES\n3: NASDAQ 100\n4: FTSE 100\n5: ESTOXX\n6: DAX\n7: Exit");
            System.out.print("Hello! Please select (1-6): ");
            int index = scanner.nextInt();
            while (index > 7 || index < 0) {
                System.out.print("Hello! Please select (1-6): ");
                index = scanner.nextInt();
            }
            if(index == 7){
                break;
            }
            System.out.println("Choose how you want to view the stocks:");
            System.out.println("1: alphabetically sorted\n2: sorted_by_price_high_to_low" +
                    "\n3: sorted_by_price_low_to_high\n4: sorted_by_daily_change_most_negative_to_most_positive" +
                    "\n5: sorted_by_daily_change_most_positive_to_most_negative");
            System.out.print("Hello! Please select (1-5): ");
            int sort = scanner.nextInt();
            while (sort > 5 || sort < 0) {
                System.out.print("Hello! Please select (1-5): ");
                sort = scanner.nextInt();
            }
            System.out.println("Please wait a second...\n\n");

            WebScraper webScraper = new WebScraper();
            switch (index) {
                case 1 -> webScraper.read_snp500_data();
                case 2 -> webScraper.read_dow_jones_data();
                case 3 -> webScraper.read_nasdaq100_data();
                case 4 -> webScraper.read_ftse100_data();
                case 5 -> webScraper.read_estoxx_data();
                case 6 -> webScraper.read_dax_data();
                default -> webScraper.read_snp500_data();
            }
            switch (sort) {
                case 1 -> webScraper.get_data().print_all_stocks_alphabetically();
                case 2 -> webScraper.get_data().print_all_stocks_sorted_by_price_high_to_low();
                case 3 -> webScraper.get_data().print_all_stocks_sorted_by_price_low_to_high();
                case 4 -> webScraper.get_data().print_all_stocks_sorted_by_daily_change_most_negative_to_most_positive();
                case 5 -> webScraper.get_data().print_all_stocks_sorted_by_daily_change_most_positive_to_most_negative();
                default -> webScraper.get_data().print_all_stocks_alphabetically();
            }

            System.out.println("\n\n1: Browse more\n2: Exit");
            System.out.print("Hello! Please select (1-2): ");
            int exit = scanner.nextInt();
            while (exit > 2 || exit < 1) {
                System.out.print("Hello! Please select (1-2): ");
                exit = scanner.nextInt();
            }
            if(exit == 1){
                System.out.println("\n\n");
            }
            else {
                break;
            }
        }
    }
}