import java.util.HashSet;
import java.util.Set;

class SumOfMultiples {
    int [] set;
    int level;

    SumOfMultiples(int number, int[] set) {
        this.set = set;
        this.level = number;
    }

    int getSum() {
        int sumTotal=0;
        Set<Integer> multiplesSet = new HashSet<>();
        for (int current : set) {
            int sum=0;
            int multiplier = 1;
            if (current == 0 ) continue;;

            while ((current * multiplier) < level) {
                multiplesSet.add(current * multiplier);  // add multiple
//                System.out.println("current  "+current + " * " + multiplier + " " + (current * multiplier) + "  sum: "+sum + "  "+ level);
                multiplier++;
            }
            sumTotal = multiplesSet.stream().reduce( 0, (a,b) -> a + b);
        }

        return sumTotal;
    }

}
