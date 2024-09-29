public class Maximum69Number {
    public int maximum69Number (int num) {
        String number = String.valueOf(num);
        return Integer.valueOf(number.replaceFirst("6", "9"));
    }
}
