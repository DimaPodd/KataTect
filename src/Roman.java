import java.util.Arrays;

public enum Roman {

    ONE("1", "I"),
    TWO("2", "II"),
    THREE("3", "III"),
    FOUR("4", "IV"),
    FIVE("5", "V"),
    SIX("6", "VI"),
    SEVEN("7", "VII"),
    EIGHT("8", "VIII"),
    NINE("9", "IX"),
    TEN("10", "X");

    private String number;
    private String romanNumber;

    Roman(String number, String romanNumber) {
        this.number = number;
        this.romanNumber = romanNumber;
    }

    public static String resultNumberToRoman(int input) {
        String s = "";
        while (input == 100) {
            s += "C";
            input -= 100;
        }
        while (input >= 90) {
            s += "XC";
            input -= 90;
        }
        while (input >= 50) {
            s += "L";
            input -= 50;
        }
        while (input >= 40) {
            s += "XL";
            input -= 40;
        }
        while (input >= 10) {
            s += "X";
            input -= 10;
        }
        while (input >= 9) {
            s += "IX";
            input -= 9;
        }
        while (input >= 5) {
            s += "V";
            input -= 5;
        }
        while (input >= 4) {
            s += "IV";
            input -= 4;
        }
        while (input >= 1) {
            s += "I";
            input -= 1;
        }
        return s;
    }


    public static String romanToNumber(String romanNumber) {
        return Arrays.stream(Roman.values())
                .filter(roman -> roman.romanNumber.equals(romanNumber))
                .findFirst().get().number;
    }

    public static boolean isRoman(String input) {
        return input.matches("^[IVXLCivxlc]+$");
    }

}
