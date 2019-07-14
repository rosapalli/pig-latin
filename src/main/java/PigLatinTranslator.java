import java.util.ArrayList;
import java.util.Arrays;

class PigLatinTranslator {

    public String translate(String inputString) {

        ArrayList<String> sList = new ArrayList<String>(Arrays.asList(inputString.split("")));
        String[] vowels = {"a", "e", "i", "o", "u","xr", "yt", "rhy"};
        String[] consonants = {"b", "c", "ch", "d", "f", "g", "gh", "h", "j", "k", "l", "ll", "m", 
        "n", "p", "ph", "q", "qu", "r", "s", "sh", "sch", "t", "th", "trh", "v", "w", "x", "y", "z"};

        if (sList.get(0).equals("x") && sList.get(1).equals("r") || sList.get(0).equals("y") && sList.get(1).equals("t")){
            sList.add("ay");     
        }
        
        for (String letter: vowels) {
            if (sList.get(0).equals(letter)) {
                sList.add("ay");
            }
        }

        for(String letter:consonants) {
            if (sList.get(0).equals(letter)) {
                String firstLetter = sList.get(0);
                sList.remove(0);
                sList.add(firstLetter);
                sList.add("ay");
            }
        }
 
        if (sList.get(1).equals("q") && sList.get(2).equals("u")) {
            String firstThreeLetters = sList.get(0) + sList.get(1) + sList.get(2);
            sList.remove(0);
            sList.remove(0);
            sList.remove(0);
            sList.add(firstThreeLetters + "ay");
        }



        String pigLatinString =  String.join("", sList); 
        return pigLatinString;

    }
}