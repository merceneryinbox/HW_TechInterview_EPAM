import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* Дано:
-) строка - паттерн которая не изменяется.
Сделать:
-) программу , которая берёт любой паттерн составляет из него все возможные комбинации букв
	дальше при передаче ей любой другой строки ищет количество вхождений всех шаблонных паттернов в эту строку
-) ньюансы:
+ проверку что переданное значение - строка
+ длина переданной строки больше , либо равна шаблону
+ составление проверяемых участков начиная с 0 позиции плюс длина шаблона
+ создать массив шаблона
+ создавать временные массивы char для каждого проверяемого участка подстроки
+ создать алгоритм проверки с перестановками символов в массиве подстроки !
* */
public class MainStringPatternMatcher {
    private static String givenPattern;
    private static String givenStringToMatchExamine;
    private static int numOfMatches;
    private static int pointer = 0;

    public MainStringPatternMatcher(String givenPattern, String givenStringToMatchExamine) {
        MainStringPatternMatcher.givenPattern = givenPattern;
        MainStringPatternMatcher.givenStringToMatchExamine = givenStringToMatchExamine;
    }

    // it just for simple test
    public static void main(String[] args) {

        MainStringPatternMatcher mainStringPatternMatcher = new MainStringPatternMatcher("abca", "abcabcabcbacbaabcb");
        int howMatchIsMatchesInGivenString = mainStringPatternMatcher.giveMeNumberOfMatches();
        System.out.println(
                "We have " + howMatchIsMatchesInGivenString + " matches and permutes in " + givenStringToMatchExamine +
                ".");
    }

    private static int giveMeNumberOfMatches() {
        while (hasNextSubArrFromMatchString(givenStringToMatchExamine)) {
            if (checkBoundaries(givenPattern, nextSubArrFromMatchString(givenStringToMatchExamine))) {
                pointer++;
                List<char[]> devidedToCharArrrayStringList = devideExamineStringIntoArrays(givenStringToMatchExamine);
                for (char[] testSubArr : devidedToCharArrrayStringList) {
                    if (givenPattern.equals(Arrays.toString(testSubArr))) {
                        numOfMatches++;
                    } else if (permuteEquality(givenPattern, testSubArr)) {
                        numOfMatches++;
                    }
                }
            }
        }

        return numOfMatches;
    }

    private static boolean hasNextSubArrFromMatchString(String givenStringToMatchExamine) {
        return pointer + givenPattern.length() > givenStringToMatchExamine.length();
    }

    private static String nextSubArrFromMatchString(String givenStringToMatchExamine) {
        return givenStringToMatchExamine.substring(pointer, pointer + givenPattern.length());
    }

    private static boolean permuteEquality(String givenPattern, char[] givenSubStringCharArForExamine) {
        boolean result = false;
        Map<Character, Integer> givenPatternMap = new HashMap();
        Map<Character, Integer> testSubArrMap = new HashMap();
        char[] givenPatternArray = givenPattern.toCharArray();
        fulfillMapFromString((HashMap<Character, Integer>) givenPatternMap, givenPatternArray);
        fulfillMapFromString((HashMap<Character, Integer>) testSubArrMap, givenSubStringCharArForExamine);

        for (char ch : givenSubStringCharArForExamine) {
            if (!givenPatternMap.containsKey(ch)) {
                return false;
            } else if (givenPatternMap.get(ch) != testSubArrMap.get(ch)) {
                return false;
            }
        }
        return result;
    }

    private static void fulfillMapFromString(HashMap<Character, Integer> givenPatternMap, char[] givenPatternArray) {
        for (char testChar : givenPatternArray) {
            if (givenPatternMap.containsKey(testChar)) {
                givenPatternMap.put(testChar, (givenPatternMap.get(testChar) + 1));
            }
        }
    }

    private static List<char[]> devideExamineStringIntoArrays(String givenString) {
        List<char[]> backListCharArray = new ArrayList<>();
        for (int i = 0; i < givenString.length(); i++) {
            int end = i + givenPattern.length();
            if ((i + end) < givenString.length()) {
                backListCharArray.add((givenString.substring(i, i + givenPattern.length())).toCharArray());
            }
        }
        return backListCharArray;
    }

    private static boolean checkBoundaries(String givenPattern, String givenStringToMatchExamine) {

        return givenPattern.length() <= givenStringToMatchExamine.length();
    }
}
