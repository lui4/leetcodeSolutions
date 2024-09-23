import java.util.Stack;

public class OnlineStockSpan {
    Stack<Tupel> stack;

    public class Tupel {
        int dayPrice;
        int daySpan;
        public Tupel(int dayPrice, int daySpan) {
            this.dayPrice = dayPrice;
            this.daySpan = daySpan;
        }
    }
    public OnlineStockSpan() {
        this.stack = new Stack<>();
    }

    public int next(int price) {
        int currentSpan = 1;
        while (!stack.isEmpty() && stack.peek().dayPrice <= price) {
            currentSpan += stack.pop().daySpan;
        }
        stack.push(new Tupel(price,currentSpan));

        return currentSpan;
    }

    public static void main(String[] args) {
        OnlineStockSpan oss = new OnlineStockSpan();
        System.out.println(oss.next(100));
        System.out.println(oss.next(80));
        System.out.println(oss.next(60));
        System.out.println(oss.next(70));
        System.out.println(oss.next(60));
        System.out.println(oss.next(75));
        System.out.println(oss.next(85));
    }
}
