import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class NaturalNumber {
    int naturalNumber;

    NaturalNumber(int number) {
        this.naturalNumber = number;
        if (naturalNumber < 1) {
            throw new IllegalArgumentException("You must supply a natural number (positive integer)");
        }
    }

    Classification getClassification() {
        int aliquotSum = getAliquotSum(naturalNumber);

        if (aliquotSum == naturalNumber){
            return Classification.PERFECT;
        } else if (aliquotSum < naturalNumber) {
            return Classification.DEFICIENT;
        } else
            return Classification.ABUNDANT;
    }

    private int getAliquotSum(int num) {
        List<Integer> resultList = new ArrayList<>();

        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                resultList.add(i);
            }
        }
        System.out.println(resultList);
        return resultList.stream().mapToInt(x -> x.intValue()).sum();
    }
}
