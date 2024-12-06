import java.util.List;

class DiamondPrinter {

    List<String> printToList(char a) {
        printRow(a);
        return null;
    }

    void printRow(char letter) {
        int times = 0;
        String star = "*";
        int totalRow = ( letter - 65 ) * 2 +1 ;
        for (int i = 65; i <= letter; i++) {
            times = letter - i;

            System.out.println("totalRow " + totalRow);
//            System.out.println( star.repeat(times) + (char) i);
//            int afterStars = totalRow - times -times - 1;
            String halfRow = star.repeat(times) + (char) i ;
            String row = halfRow + mirror(halfRow);
            System.out.println(halfRow);
        }
        for (int i = letter - 1 ; i >= 65; i--) {
            times = letter - i;
            System.out.println( star.repeat(times) + (char) i);
        }

    }

    private String mirror(String halfRow) {
        return new StringBuilder(halfRow).reverse().toString();
    }

}
