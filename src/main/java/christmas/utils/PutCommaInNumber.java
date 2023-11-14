package christmas.utils;

public class PutCommaInNumber {
    public String putCommaInNumber(int number) {
        StringBuilder result = new StringBuilder();
        String numToStr = Integer.toString(number);
        int maxIndex = numToStr.length();

        for (int i = 0; i < maxIndex; i++) {
            result.append(numToStr.charAt(i));
            if ((maxIndex - i) % 3 == 1 && i != maxIndex - 1) {
                result.append(",");
            }
        }

        return result + "원";
    }
}
