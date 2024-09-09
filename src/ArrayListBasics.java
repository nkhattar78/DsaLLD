import java.util.ArrayList;
import java.util.Collections;

public class ArrayListBasics {

    void basicOperations(){
        ArrayList<String> list = new ArrayList<String>();
        list.add("def");
        list.add("abc");


        for (int i= 0; i<list.size(); i++) {
            list.set(i, list.get(i) + " updated value"); // updating list item value
            System.out.println("List element at position " + i + " is: " + list.get(i));
        }

        //Sorting the list. Here we use Collections class
        Collections.sort(list);
        for (int i= 0; i<list.size(); i++) {
            System.out.println("List element at position " + i + " is: " + list.get(i));
        }
    }

}
