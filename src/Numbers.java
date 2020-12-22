import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Numbers {

    ArrayList <Integer> listOfNumbers = new ArrayList();
    ArrayList <Integer> querySumsList = new ArrayList();
    ArrayList <Integer> dublicates = new ArrayList();


    public void findNumbersDivideOn(int numberFrom, int numberTo, int divideOn) {
        for (int i = numberFrom; i <= numberTo; i++) {
            if (i%divideOn == 0) {
                listOfNumbers.add(i);
            }
        }
    }

    public int querSum(int number) {
        int sum = 0;
        while (0 != number) {
            // addiere die letzte ziffer der uebergebenen zahl zur summe
            sum = sum + (number % 10);
            // entferne die letzte ziffer der uebergebenen zahl
            number = number / 10;
        }
        return sum;
    }
    
    public void saveAllQuerySums(){
        for (int i = 0; i < listOfNumbers.size(); i++) {
            querySumsList.add(querSum(listOfNumbers.get(i)));
        }
    }
    
    public void getMatchesOfQuerySums(){
        copyListWithoutDublicates();
        for (int i = 0; i < dublicates.size(); i++) {
            int matches = 0;
            for (int j = 0; j < querySumsList.size(); j++) {
                if (dublicates.get(i)==querySumsList.get(j)) matches++;
            }
            System.out.println("The number " + dublicates.get(i) + " matches " + matches + " times.");
        }
    }

    public void copyListWithoutDublicates(){
        for (int i = 0; i < querySumsList.size(); i++) {
            dublicates.add(querySumsList.get(i));
        }
        Set<Integer> set = new HashSet<>(dublicates);
        dublicates.clear();
        dublicates.addAll(set);
    }

    public void toStringArrayList(){
        System.out.println(listOfNumbers.toString());
        System.out.println(querySumsList.toString());
        System.out.println(dublicates.toString());
    }



    public static void main(String[] args) {
        Numbers numbers = new Numbers();
        numbers.findNumbersDivideOn(102, 999, 3);
        numbers.saveAllQuerySums();
        numbers.getMatchesOfQuerySums();
        numbers.copyListWithoutDublicates();
        numbers.toStringArrayList();
    }
}
