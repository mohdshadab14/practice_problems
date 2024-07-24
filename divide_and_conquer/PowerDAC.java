package divide_and_conquer;

public class PowerDAC {
    public int getPowerOfAnElement(int base, int exponent) {

        if (exponent == 0) {
            return 1;
        } else {

            int half = getPowerOfAnElement(base, exponent / 2);

            // If exponent is even
            if (exponent % 2 == 0) {
                return half * half;
            } else {
                // If exponent is odd
                return base * half * half;
            }
        }
    }
}
