class ResistorColorTrio {
    public static final String OHMS = "ohms";
    public static final String SPACE = " ";

//    Integer.MAX_VALUE = 2,147,483,647   9 Zeros
//    Long.MAX_VALUE = 9,223,372,036,854,775,807  18 Zeros
    String label(String[] colors) {
        // Get the value for first two colors
        int value = value(colors );

        long result = 0;
        String label = "";
        int zeros = colorCode(colors[2]);

        //Get the label depending on how many zeros has the value
        result = (long) value * (int) Math.pow(10, zeros);
        if (result < 1000) {            // <- this is to avoid mod % flow if result is zero
            return result + " " + OHMS;
        } else if (result % 1000000000 == 0) {
            result = result / 1000000000;
            label = "giga";
        } else if (result % 1000000 == 0) {
            result = result / 1000000;
            label = "mega";
        } else if (result % 1000 == 0) {
            result = result / 1000;
            label = "kilo";
        }
        return result + " " + label + OHMS;
    }

    int value(String[] colors) {

        int pos=1;  // Only take first two positions of the array
        int exp = 0;
        int resistorValue = 0;

        while(pos >= 0) {
            if (colorCode(colors[pos]) != 0) {
                resistorValue += colorCode(colors[pos]) * (int) Math.pow(10, exp);
            }
            pos--;
            exp++;
        }

        return resistorValue;
    }

    int colorCode(String color) {
        int code = 0;

        switch (color) {
            case "black":
                code = 0;
                break;
            case "brown":
                code = 1;
                break;
            case "red":
                code = 2;
                break;
            case "orange":
                code = 3;
                break;
            case "yellow":
                code = 4;
                break;
            case "green":
                code = 5;
                break;
            case "blue":
                code = 6;
                break;
            case "violet":
                code = 7;
                break;
            case "grey":
                code = 8;
                break;
            case "white":
                code = 9;
                break;
            default : code = -1;
        };
        return code;
    }
}
