public class MinimumAddToMakeParanthesesValid {
    public int minAddToMakeValid(String s) {
        int openParantheses = 0;
        int moves = 0;

        for(int i = 0; i< s.length();i++) {
            if(s.charAt(i) == '(') {
                openParantheses++;
            } else {
                if(openParantheses == 0) moves++;
                else openParantheses = openParantheses - 1;
            }
        }
        return Math.abs(openParantheses + moves);
    }
}
