public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int idx = i;

            while (idx < s.length()) {
                str.append(s.charAt(idx));

                idx += 2*numRows - 2;

                if(i != numRows-1 && i != 0 && idx - 2*i < s.length()) {
                    str.append(s.charAt(idx - 2*i));
                }

            }

        }
        return str.toString();
    }
}
