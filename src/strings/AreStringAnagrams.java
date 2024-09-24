package strings;

import java.util.HashMap;
import java.util.Map;
public class AreStringAnagrams {
    public static void mainFn() {
        String str1 = "STR1";
        String str2 = "SR1T";
        Boolean areStringAnagrams = checkAnagrams(str1, str2);
        System.out.println("Are strings " + str1 + " and " +  str2 +  " anagrams: " + areStringAnagrams);


    }

    public static boolean checkAnagrams(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        boolean result = false;
        HashMap <Character, Integer> str1Map = getStrMap(str1);
        HashMap <Character, Integer> str2Map = getStrMap(str2);
        return checkStringMaps(str1Map, str2Map);
    }
    private static HashMap<Character, Integer> getStrMap(String str) {
        HashMap <Character, Integer> strMap = new HashMap<>();
        for (int i =0; i< str.length();i++) {
            char ch = str.charAt(i);
            if (strMap.get(ch) != null) {
                strMap.put(ch, strMap.get(ch) +1);
            } else {
                strMap.put(ch, 1);
            }
        }
        return strMap;
    }
    private static boolean checkStringMaps(HashMap<Character, Integer> map1, HashMap<Character, Integer> map2) {
        boolean result = true;
        if (map1.size() != map1.size()) return false;

        for (Map.Entry mapElement:map1.entrySet()) {
            if (mapElement.getValue() != map2.get(mapElement.getKey())) {
                result = false;
                break;
            }
        }
        return result;
    }
}
