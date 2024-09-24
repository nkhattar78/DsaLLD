package com.company;

import java.util.*;

public class JavaCollection {
    public static void mainFn() {
        Set<Integer> integerSet = new HashSet<>();
        LinkedHashSet<Integer> integerLinkedHashSet = new LinkedHashSet<>();

        integerSet.add(1);
        integerSet.add(1);
        integerSet.add(2);
        integerSet.add(3);
        integerSet.add(4);


        Iterator itr = integerSet.iterator();

        integerLinkedHashSet.add(1);
        integerLinkedHashSet.add(1);
        integerLinkedHashSet.add(2);
        integerLinkedHashSet.add(2);
        integerLinkedHashSet.add(3);

        System.out.println("Set Size: " + integerSet.size()+ " " + integerSet);
        System.out.println("Set Size: " + integerLinkedHashSet.size()+ " " + integerLinkedHashSet);

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("a");

        Iterator listItr = list.iterator();

        while (listItr.hasNext()) {
            listItr.next();
        }

        for(String str:list) {
            System.out.print(str + " ");
        }

        TreeSet<Integer> integerTreeSet = new TreeSet<>();
        integerTreeSet.add(5);
        integerTreeSet.add(2);

        System.out.println("Integer Tree Set: " + integerTreeSet);

        TreeSet<String> stringTreeSet = new TreeSet<>();
        stringTreeSet.add("def");
        stringTreeSet.add("abc");

        System.out.println("String Tree Set: " + stringTreeSet);

        Hashtable<Integer, String> hashtable = new Hashtable<>();
        hashtable.put(1,"A");
        hashtable.put(1,"B");

        Iterator hastTableItr = hashtable.entrySet().iterator();

        while (hastTableItr.hasNext()) {
            Map.Entry<Integer, String > entry = (Map.Entry<Integer, String>) hastTableItr.next();
        }

        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "A");
        hashMap.put(3, "C");

        for (Map.Entry<Integer, String > entry: hashMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
            hashMap.remove(entry);
        }
    }
}
