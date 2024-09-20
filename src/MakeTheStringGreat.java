public class MakeTheStringGreat {
    public String makeGood(String s) {
        StringBuilder stack = new StringBuilder();
        for (char c: s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.append(c);
                continue;
            }
            if (Character.isUpperCase(c)) {
                if (stack.charAt(stack.length() - 1) == c + 32) {
                    stack.deleteCharAt(stack.length() - 1);
                    continue;
                }
            } else {
                if (stack.charAt(stack.length() - 1) == c - 32) {
                    stack.deleteCharAt(stack.length() - 1);
                    continue;
                }
            }
            stack.append(c);
        }

        return String.join("", stack);
    }

    public static void main(String[] args) {
        MakeTheStringGreat mtsg =  new MakeTheStringGreat();
        System.out.println(mtsg.makeGood("leEeetcode"));
        System.out.println(mtsg.makeGood("abBAcC"));
        System.out.println(mtsg.makeGood("s"));
    }
}
