class RotationalCipher {
    int shifKey;

    RotationalCipher(int shiftKey) {
        this.shifKey = shiftKey;
//        char letter;
//        for (letter = 'A'; letter <= 'Z'; letter++) {
//            System.out.print(letter + " ");
//        }
//        System.out.println();
    }

    String rotate(String data) {
        StringBuilder shiftedStr = new StringBuilder();

        for (char c : data.toCharArray()) {
            shiftedStr.append(shiftChar(c));
        }

        return shiftedStr.toString();
    }

    char shiftChar(char letter) {
        int shifted = 0;
        char alpha = 'a';
        char zeta = 'z';

        if (!Character.isLetter(letter)){
            return letter;
        }

        if (Character.isUpperCase(letter)){
            alpha = 'A';
            zeta = 'Z';
        }

        if (letter + shifKey > zeta) {
            shifted = letter + shifKey - (zeta - alpha) - 1;
//            System.out.println((char) shifted);
        } else {
            shifted = letter + shifKey;
        }

        return (char) shifted;
    }

}
