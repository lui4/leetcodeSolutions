public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs[0].isEmpty()) return "";

        int index = strs[0].length() - 1;

        for (int i = 1; i < strs.length; i++) {
            if(strs[i].length()-1 < index) index = strs[i].length()-1;
            for (int j = 0; j <= index ; j++) {
                if(strs[i].charAt(j) != strs[0].charAt(j)){
                    index = j-1;
                    break;
                }
            }
        }

        return strs[0].substring(0, index+1);
    }
}
