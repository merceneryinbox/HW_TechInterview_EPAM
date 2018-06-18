import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public MainStringPatternMatcher(String givenPattern, String givenStringToMatchExamine) {
        this.givenPattern = givenPattern;
        this.givenStringToMatchExamine = givenStringToMatchExamine;
    }

    public static void main(String[] args) {
        // needed behavior

        int howMatchIsMatchesInGivenString = giveMeNumberOfMatches();

    }

    private static int giveMeNumberOfMatches() {
        if (checkIncomes(givenPattern, givenStringToMatchExamine)) {

            char[] patternCharArray = givenPattern.toCharArray();

            List<char[]> devidedToCharArrrayStringList = devideExamineStringIntoArrays(givenStringToMatchExamine);
            for (char[] testSubArr : devidedToCharArrrayStringList) {
                if (givenPattern.equals(Arrays.toString(testSubArr))) {
                    numOfMatches++;
                }
            }
        }

        return numOfMatches;
    }

    private static List<char[]> devideExamineStringIntoArrays(String givenString) {
        List<char[]> backListCharArray = new ArrayList<>();
        for (int i = 0; i < givenString.length(); i++) {
            backListCharArray.add((givenString.substring(i, i + givenPattern.length())).toCharArray());
        }
        return null;
    }

    private static boolean checkIncomes(String givenPattern, String givenStringToMatchExamine) {

        return givenPattern.length() <= givenStringToMatchExamine.length();
    }
}
