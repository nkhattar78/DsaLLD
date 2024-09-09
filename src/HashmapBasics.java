import java.util.HashMap;

public class HashmapBasics {
    void basicOperations() {
        HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
        hashMap.put(1, "abc");
        hashMap.put(2, "def");

        //Printing all the elements of the hashmap
        System.out.println(hashMap);

        //Access value of hashmap entry using key
        System.out.println(hashMap.get(1));

        // Iterate over hashmap
        System.out.println("Iterating over hashmap using key");
        for (int i: hashMap.keySet()) {
            System.out.println("Key: " + i + " value: " + hashMap.get(i));
        }

        System.out.println("Iterating over hashmap using value");
        for (String str: hashMap.values()) {
            System.out.println(" value: " + str);
        }

        //Checking if an entry with the key is present
        if (hashMap.containsKey(5))
            System.out.println("Entry with key as 5 present in the map");
        else
            System.out.println("Entry with key as 5 is NOT present in the map");

        //Checking if an entry with the value is present
        if (hashMap.containsValue("abc"))
            System.out.println("Entry with value as abc present in the map");
        else
            System.out.println("Entry with value as abc is NOT present in the map");

        //Updating hashmap value, function put is used for it. If the key is present then it updates its value else creates a new entry
        for (int i: hashMap.keySet()){
         hashMap.put(i, hashMap.get(i) + " value updated");
            System.out.println("Key: " + i + " value: " + hashMap.get(i));
        }
    }
}
