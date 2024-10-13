import javax.sql.rowset.Predicate;
import java.util.HashMap;
import java.util.HashSet;

public class ValidSquare {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        HashSet<Double> distances = new HashSet<>();

        double d12 = Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2);
        if(d12 == 0) return false;
        distances.add(d12);
        double d13 = Math.pow(p1[0] - p3[0], 2) + Math.pow(p1[1] - p3[1], 2);
        if(d13 == 0) return false;
        distances.add(d13);
        double d14 = Math.pow(p1[0] - p4[0], 2) + Math.pow(p1[1] - p4[1], 2);
        if(d14 == 0) return false;
        distances.add(d14);
        double d23 = Math.pow(p2[0] - p3[0], 2) + Math.pow(p2[1] - p3[1], 2);
        if(d23 == 0) return false;
        distances.add(d23);
        double d24 = Math.pow(p2[0] - p4[0], 2) + Math.pow(p2[1] - p4[1], 2);
        if(d24 == 0) return false;
        distances.add(d24);
        double d34 = Math.pow(p3[0] - p4[0], 2) + Math.pow(p3[1] - p4[1], 2);
        if(d34 == 0) return false;
        distances.add(d34);

        return distances.size() == 2;
    }

    public static void main(String[] args) {
        ValidSquare vs = new ValidSquare();
        System.out.println(vs.validSquare(new int[]{0,0}, new int[]{1,1}, new int[]{1,0}, new int[]{0,1}));
    }
}
