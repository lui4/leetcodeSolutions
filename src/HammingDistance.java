public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;

        int differentBitCount = 0;
        while(xor != 0) {
            if((1 & xor) == 1) differentBitCount++;
            xor = xor >> 1;
        }
        return differentBitCount;
    }
}
