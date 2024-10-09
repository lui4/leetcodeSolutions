public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if(s.length() == 1) return s;

        String answer = "";

        for (int i = 0; i < s.length() - 1; i++) {

            String oddSpread = expand(i,i, s);

            answer = oddSpread.length() > answer.length() ? oddSpread : answer;

            String evenSpread = expand(i, i+1, s);

            answer = evenSpread.length() > answer.length() ? evenSpread : answer;
        }
        return answer;
    }

    public String expand(int i, int j, String s) {
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }

        int diff = i - j + 1;

        if(diff == 1) {
            return String.valueOf(s.charAt(i));
        } else if (diff == 2) {
            return s.substring(i, j+1);
        } else {
            return s.substring(i+1, j);
        }
    }

}
