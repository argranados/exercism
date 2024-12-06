import java.util.stream.IntStream;

class DifferenceOfSquaresCalculator {

    int computeSquareOfSumTo(int input) {
        IntStream it = IntStream.range(0,input+1);

        return (int) Math.pow(it.sum(), 2);
    }

    int computeSumOfSquaresTo(int input) {
        IntStream it = IntStream.range(0,input+1);

        return (int) it.mapToDouble(x -> Math.pow(x,2)).sum();
    }

    int computeDifferenceOfSquares(int input) {
        return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);
    }

}
