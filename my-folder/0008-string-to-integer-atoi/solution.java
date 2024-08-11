class Solution {
   public static int myAtoi(String s) {
        long res = 0;
        int flag = 1;
        int i = 0;
        int n = s.length();

        // Remove leading whitespace
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Check if the string is empty after trimming whitespace
        if (i == n) {
            return 0;
        }

        // Check for optional sign
        if (s.charAt(i) == '-') {
            flag = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }

        // Convert characters to number
        while (i < n) {
            char cha = s.charAt(i);
            if (cha < '0' || cha > '9') {
                break;
            }
            int digit = cha - '0';

            // Check for overflow before updating res
            if (res > (Integer.MAX_VALUE - digit) / 10) {
                return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            res = res * 10 + digit;
            i++;
        }

        return (int) (res * flag);
    }
}
