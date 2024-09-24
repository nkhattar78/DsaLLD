package dynamicProgramming;

public class LongestCommonSubsequence {
    static final String STR1 = "aebcbda";
    static final String STR2 = "adbcbea";
    static int[][] dp = new int[STR1.length()+1][STR2.length()+1];
    public static void mainFn() {
        int LCS = LCSrecursive(STR1.length(), STR2.length());
        System.out.println("LCS: " + LCS);

        LCS = LCSMemoization();
        System.out.println("LCS using memoization: " + LCS);

        resetDPMatrix();
        LCS = LCStabulation();
        System.out.println("LCS using Tabulation/Top-Down: " + LCS);

        resetDPMatrix();
        printLCStabulation();
    }
    private static int LCSrecursive(int n, int m) {
        /** If either of the string is of length 0 then LCS will be 0*/
        if(m==0||n==0) {
            return 0;
        }

        /** If both the chars are equal then call function for next element for both the strings*/
        if(STR1.charAt(n-1) == STR2.charAt(m-1)) {
            return 1 + LCSrecursive(n-1, m-1);
        } else{
            /** Call recursive function for:
             * 1. Consider char from STR1 processed
             * 2. Consider char from STR2 processed
             Take MAX of 1 and 2*/
            return Math.max(LCSrecursive(n-1, m), LCSrecursive(n, m-1));
        }
    }

    private static void resetDPMatrix(){
        for (int i =0; i<=STR1.length();i++) {
            for (int j =0; j<=STR2.length(); j++) {
                dp[i][j] = 0;
            }
        }
    }

    private static int LCStabulation() {
        /** If first String length is 0 then LCS will be 0*/
        for (int i=0;i<=STR2.length();i++) {
            dp[0][i] = 0;
        }

        /** If 2nd String length is 0 then also LCS will be 0*/
        for (int i=0;i<=STR1.length();i++) {
            dp[i][0] = 0;
        }
        for (int i =1; i<=STR1.length();i++) {
            for (int j =1; j<=STR2.length(); j++) {
                if (STR1.charAt(i-1)==STR2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) ;
                }
            }
        }
        return dp[STR1.length()][STR2.length()];
    }

    private static void printLCStabulation() {
        String[][] dp = new String[STR1.length()+1][STR2.length()+1];
        /** Initialize the whole matrix with empty string */
        for (int i = 0; i<=STR1.length();i++) {
            for (int j = 0; j <= STR2.length(); j++) {
                dp[i][j] = "";
            }
        }

        /** If first String length is 0 then LCS will be 0*/
        for (int i=0;i<=STR2.length();i++) {
            dp[0][i] = "";
        }

        /** If 2nd String length is 0 then also LCS will be 0*/
        for (int i=0;i<=STR1.length();i++) {
            dp[i][0] = "";
        }

        for (int i =1; i<=STR1.length();i++) {
            for (int j =1; j<=STR2.length(); j++) {
                if (STR1.charAt(i-1) == STR2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + STR1.charAt(i-1);
                } else {
                    dp[i][j] = dp[i-1][j].length()> dp[i][j-1].length() ? dp[i-1][j]:dp[i][j-1];
                }
            }
        }
        System.out.println("LCS String " + dp[STR1.length()][STR2.length()]);;
    }

    private static int LCSMemoization() {
        for (int i =0; i<=STR1.length();i++) {
            for (int j =0; j<=STR2.length();j++) {
                dp[i][j] = -1;
            }
        }
        return LCSMemoization(STR1.length(), STR2.length());
    }

    private static int LCSMemoization(int n, int m) {
        if (n==0 || m==0) {
            return 0;
        }
        if (dp[n][m] !=-1) {
            return dp[n][m];
        }

        if (STR1.charAt(n-1) == STR2.charAt(m-1)) {
            dp[n][m] = 1 + LCSMemoization(n-1, m-1);
        } else {
            dp[n][m] = Math.max(LCSMemoization(n-1, m), LCSMemoization(n, m-1));
        }
        return dp[n][m];
    }

}
