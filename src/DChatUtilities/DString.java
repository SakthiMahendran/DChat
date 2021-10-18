package DChatUtilities;

public class DString {

    public static String insertString(String originalStr, String strToBeInsertred, int[] at) {
        var insertedString = "";

        for (int i = 0; i<originalStr.length(); i++) {
            if(isMatches(i, at))
                insertedString += strToBeInsertred;

            insertedString += originalStr.charAt(i);
        }
        return insertedString;
    }

    private static boolean isMatches(int number, int[] numberArray) {
        for (int i : numberArray) {
            if (number == i)
                return true;
        }
        return false;
    }
}
