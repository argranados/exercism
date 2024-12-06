import java.util.*;

class Sieve {
    int maxPrime;

    Sieve(int maxPrime) {
        this.maxPrime = maxPrime;
    }

    List<Integer> getPrimes() {
        List<Integer> primes = createRage();
        Set<Integer> notPrimes = new HashSet<>();
        var numbers = createRage();

        if (numbers.isEmpty()) {
            return primes;
        }

        //skip first number in list (skip number 2)
        int size = numbers.size();
        int lastDigit = numbers.get(numbers.size()-1);
        for (int i = 0; i < size; i++) {
            int count = 2;
            int current = numbers.get(i);
//            System.out.println("current value "+current);
            while (current * count <= lastDigit ) {
                if (notPrimes.contains(current)){
                    break;
                }
//                System.out.println(current * count);
                notPrimes.add(current * count);  // add multiple
                count++;
            }
        }
        for (Integer n : notPrimes){ // remove not primes from primes array
            primes.remove(n);
        }

        return primes;
    }

    List<Integer> createRage() {
        List<Integer> range = new ArrayList<>();
        for (int i = 2; i <= maxPrime ; i++) {
            range.add(i);
        }
        return range;
    }

}
