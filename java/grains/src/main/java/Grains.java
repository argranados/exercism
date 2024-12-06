import java.math.BigInteger;

class Grains {

    BigInteger grainsOnSquare(final int square) {
        int count = 1;
        BigInteger total = BigInteger.ONE;

        if (square == 1) {
            return BigInteger.ONE;
        } else if (square < 1 || square > 64) {
            throw new IllegalArgumentException("square must be between 1 and 64");
        }

        while ( count != square) {
            total =  total.multiply(BigInteger.TWO);
            count++;
        }

        return total;
    }

    BigInteger grainsOnBoard() {
        int count = 1;
        BigInteger total = BigInteger.ZERO;
        while ( count < 65) {
            total = total.add(grainsOnSquare(count++));
        }
        return total;
    }

}
        