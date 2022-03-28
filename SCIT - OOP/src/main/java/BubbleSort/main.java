package BubbleSort;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        SalesRepresentative seller1 = new SalesRepresentative("Mihai", 10, 5000, 500);
        SalesRepresentative seller2 = new SalesRepresentative("George", 7, 5600, 800);

        /**
         * Interface that help us create a list
         * @add add element to the list
         */

        List<SalesRepresentative> salesRepresentativeList = new ArrayList<>();
        salesRepresentativeList.add(seller1);
        salesRepresentativeList.add(seller2);

        /**
         * Method that help us sort SalesRepresentaives via worth of sales
         * @sout displays the list after sorting
         */

        SalesRepresentative.bubbleSort(salesRepresentativeList);
        System.out.println("List sorted via worth of sales in descending order: " + salesRepresentativeList);
    }
}
