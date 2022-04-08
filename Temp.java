import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Temp {
    List<Double> tempList = new ArrayList<>();
    double lowest;
    double highest;
    double total = 0;

    public Temp() throws Exception {
        readFile();
        if (tempList.size() > 0){
            lowest = tempList.get(0);
            highest = tempList.get(0);
        } else {
            throw new Exception("List is empty"); // This does currently not take into account if the list does not contain doubles
        }
        for (double theTemp:tempList) {
            if (lowest > theTemp) {
                lowest = theTemp;
            }
            if (highest < theTemp){
                highest = theTemp;
            }
            total += theTemp;
            System.out.println(theTemp);
        }
        System.out.println("-----------------------------");
        System.out.println("Highest: " + highest);
        System.out.println("Lowest: " + lowest);
        System.out.println("Average: " + total / tempList.size());
    }

    public void readFile(){
        String tempLine;
        try (BufferedReader bufIn = new BufferedReader(new FileReader
                ("Temp.txt"));){
            while((tempLine = bufIn.readLine()) != null){
                tempList.add(Double.parseDouble(tempLine));
            }
        }
        catch (Exception e){
            System.out.println("File could not be found");
        }
    }
}
