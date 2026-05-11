import java.util.*;

class Solution_gfg_41{
    public boolean palindromePair(String[] arr) {
        int n = arr.length;
        if (n < 2) return false;

        // Map string to its index for O(1) lookups
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }

        for (int i = 0; i < n; i++) {
            String s = arr[i];
            int len = s.length();

            // Try splitting the string at every possible position
            for (int j = 0; j <= len; j++) {
                String s1 = s.substring(0, j);
                String s2 = s.substring(j);

                // Check Case: s1 is a palindrome, find reverse of s2
                if (isPalindrome(s1)) {
                    String revS2 = new StringBuilder(s2).reverse().toString();
                    if (map.containsKey(revS2) && map.get(revS2) != i) {
                        return true;
                    }
                }

                // Check Case: s2 is a palindrome, find reverse of s1
                // j < len prevents duplicate checks when j=0
                if (s2.length() > 0 && isPalindrome(s2)) {
                    String revS1 = new StringBuilder(s1).reverse().toString();
                    if (map.containsKey(revS1) && map.get(revS1) != i) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
}
