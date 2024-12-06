class ResistorColor {
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

    String[] colors() {
        return new String[] {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
    }
}
