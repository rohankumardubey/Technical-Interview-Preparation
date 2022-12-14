package org.redquark.techinterview.dsa.dynamicprogramming;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a string s, return the longest palindromic substring in s.
 */
public class LongestPalindromicSubstring {

    private static String longestPalindrome(String s) {
        // Special case
        if (s == null || s.isEmpty()) {
            return "";
        }
        // Start and ending pointers
        int start = 0;
        int end = 0;
        // Loop through the string and treat each character
        // as the center and expand around it
        for (int i = 0; i < s.length(); i++) {
            // Case where length is even
            int a = expandFromCenter(s, i, i);
            // Case where length is odd
            int b = expandFromCenter(s, i, i + 1);
            // Maximum length between the two
            int c = Math.max(a, b);
            // Get the length of the longest palindromic substring
            if (c > end - start) {
                start = i - ((c - 1) / 2);
                end = i + c / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandFromCenter(String s, int left, int right) {
        // Base case
        if (s == null || left > right) {
            return 0;
        }
        // Loop until left character is equal to the right character
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            // Move towards left and right from the center
            left--;
            right++;
        }
        return right - left - 1;
    }


    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));

        s = "cbbd";
        System.out.println(longestPalindrome(s));

        s = "a";
        System.out.println(longestPalindrome(s));

        s = "ac";
        System.out.println(longestPalindrome(s));
    }
}
