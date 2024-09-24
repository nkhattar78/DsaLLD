

public class LexicalComparison {
    static int fn(String str1, String str2) {
        for (int i=0; i<str1.length() && i<str2.length();i++) {
            int diff = (int)str1.charAt(i) - (int)str2.charAt(i);
            if (diff !=0) {
                return diff;
            }
        }

        int diffLength = str1.length()-str2.length();
        return diffLength;
    }

}
