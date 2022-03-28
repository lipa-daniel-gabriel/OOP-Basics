package BubbleSort;

import java.util.List;

public class SalesRepresentative {
    private String name;
    private int numberOfSales;
    private int worthOfSales;
    private int quota;

    public SalesRepresentative(String name, int numberOfSales, int worthOfSales, int quota) {
        this.name = name;
        this.numberOfSales = numberOfSales;
        this.worthOfSales = worthOfSales;
        this.quota = quota;
    }

    /**
     * method that bubbleSortOurList
     * @param salesRepresentativeList
     */
    public static void bubbleSort(List<SalesRepresentative> salesRepresentativeList) {
        int size = salesRepresentativeList.size();

        for (int i = 0; i < size - 1; i++)
            for (int j = 0; j < size - i - 1; j++)

                if (salesRepresentativeList.get(j).worthOfSales > salesRepresentativeList.get(j + 1).worthOfSales) {
                    SalesRepresentative salesRepresentative = salesRepresentativeList.get(j);
                    salesRepresentativeList.set(j, salesRepresentativeList.get(j + 1));
                    salesRepresentativeList.set(j + 1, salesRepresentative);
                }
    }

    @Override
    public String toString() {
        return "SalesRepresentative{" +
                "name='" + name + '\'' +
                ", numberOfSales=" + numberOfSales +
                ", worthOfSales=" + worthOfSales +
                ", quota=" + quota +
                '}';
    }
}
