import java.util.ArrayList;
import java.util.List;

/*
 * My strategy was to generate all possible combinations of items and then iterate over them
 * to find the one with the maximum value and weight less than or equal to the maximum weight.
 * I used a recursive helper function to generate all combinations of items,
 * found this helper function on Deep Seek web site and adapted it to my needs (sorry copilot).
 */
class Knapsack {

    int maximumValue(int maximumWeight, List<Item> items) {

        List<List<Item>> allCombinations = generateCombinations(items);

        // Iterate all combinations and find total value and total weight for each combination
        // winner item is the one with weight equal or less that maximumWeight
        int maximumValue = 0;
        for (List<Item> combination : allCombinations) {            
            // System.out.println(combination);
            int totalCurrentValue = 0;
            int totalCurrentWeight = 0;
            for (Item item : combination) {
                totalCurrentValue += item.value;
                totalCurrentWeight += item.weight;
            }
            // System.out.println("Current Item: " + currentItem + " Current Value: " + totalCurrentValue + " Current Weight: " + totalCurrentWeight);
            if (totalCurrentWeight <= maximumWeight && totalCurrentValue > maximumValue) {
                maximumValue = totalCurrentValue;
            }
        }
        // System.out.println("Winner Item: " + winnerItem);

        return maximumValue;

    }

    public static List<List<Item>> generateCombinations(List<Item> items) {
        List<List<Item>> result = new ArrayList<>();
        generateCombinationsHelper(items, new ArrayList<>(), 0, result);
        return result;
    }

    private static void generateCombinationsHelper(List<Item> items, List<Item> current, int start, List<List<Item>> result) {
        // Add the current combination to the result
        result.add(new ArrayList<>(current));

        // Generate combinations by adding one item at a time
        for (int i = start; i < items.size(); i++) {
            current.add(items.get(i)); // Include the current item
            generateCombinationsHelper(items, current, i + 1, result); // Recur for the next items
            current.remove(current.size() - 1); // Backtrack (remove the last item)
        }
    }


}