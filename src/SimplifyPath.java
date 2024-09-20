import com.sun.nio.sctp.AbstractNotificationHandler;

import java.util.ArrayList;
import java.util.Objects;

public class SimplifyPath {
    public String simplifyPath(String path) {
        ArrayList<String> stack = new ArrayList<>();
        StringBuilder currentString = new StringBuilder();
        for(char c : path.toCharArray()){
            if (stack.isEmpty()) {
                stack.add("/");
                continue;
            }

            if (c == '/') {
                if (currentString.isEmpty()) {
                    continue;
                }

                if (currentString.toString().equals("..")) {
                    if (stack.size() != 1) {
                        stack.remove(stack.size() - 1);
                    }
                    currentString.setLength(0);
                    continue;
                }

                if (currentString.toString().equals(".")) {
                    currentString.setLength(0);
                    continue;
                }

                currentString.append(c); // appends a /
                stack.add(currentString.toString());
                currentString.setLength(0);
                continue;
            }
            currentString.append(c);
        }

        if (!currentString.isEmpty()) {
            if (currentString.toString().equals("..")) {
                if (stack.size() != 1) {
                    stack.remove(stack.size() - 1);
                }
            } else if (currentString.toString().equals(".")){}
            else {
                stack.add(currentString.toString());
            }
        }

        String result = String.join("", stack);
        if (result.charAt(result.length() - 1) == '/'){
            if (result.length() == 1) {
                return result;
            }
            result = result.substring(0, result.length() - 1);
        }
        return result;
    }
    public static void main(String[] args) {
        SimplifyPath sp = new SimplifyPath();
        System.out.println(sp.simplifyPath("/home//foo/"));
        System.out.println(sp.simplifyPath("/home/user/Documents/../Pictures"));
        System.out.println(sp.simplifyPath("/../"));
        System.out.println(sp.simplifyPath("/.../a/../b/c/../d/./"));
        System.out.println(sp.simplifyPath("/a//b////c/d//././/.."));
    }
}
