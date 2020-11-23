package org.myJava.leetcode;

/**
 * @author gongwenzhou@hellobike.com
 * @description 最长回文子串
 * @created 2020/10/13 8:44 上午
 **/
public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(myLongestPalindrome("1213121"));
        System.out.println(longestPalindrome("1213121"));
        palindrome1("1213121");
    }

    public static String myLongestPalindrome(String s) {
        String longestStr = "";
        String nextChar = "";
        int nextIndex = 0;
        if (s.length() <= 1) {
            return s;
        }

        for (int i = 0; i < s.length(); i++) {
            if (longestStr.equals("")) {
                longestStr += s.charAt(i);
            } else if (longestStr.length() == 1) {
                longestStr += s.charAt(i);
                nextChar = String.valueOf(longestStr.charAt(nextIndex));
            } else {
                char c = s.charAt(i);
                if (String.valueOf(c).equals(nextChar)) {
                    nextIndex++;
                    nextChar = String.valueOf(longestStr.charAt(nextIndex));
                    longestStr += s.charAt(i);
                }
            }
        }

        return longestStr;
    }

    public static String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int l = 0; l < n; ++l) {
            for (int i = 0; i + l < n; ++i) {
                int j = i + l;
                if (l == 0) {
                    dp[i][j] = true;
                } else if (l == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                if (dp[i][j] && l + 1 > ans.length()) {
                    ans = s.substring(i, i + l + 1);
                }
            }
        }
        return ans;
    }

    public static void palindrome1(String str) {

        if (str == null || str.length() == 0){
            return;
        }
        char chs[] = str.toCharArray();
        int max_len = 0;
        boolean[][] f = new boolean[chs.length][chs.length];
        for (int j = 0; j < str.length(); j++) {
            int i = 0;
            f[j][j] = true;
            //一个元素肯定是回文串。
            for (; i < j; i++) {
                f[i][j] = (chs[j] == chs[i] && (j - i < 2 || j > 0 && f[i + 1][j - 1]));
                //如果chs[j]==chs[i]当串的长度小于等于2时，肯定是回文子串，如 1，1，就是回文串。
                //如果长度大于2时，则需要判断f[i+1][j-1]是不是回文。
                if (f[i][j]) {
                    max_len = Math.max(max_len, j - i + 1);
                }
                //max_len保存最大回文子串的长度。
            }
        }
        System.out.println(max_len);
    }
}
