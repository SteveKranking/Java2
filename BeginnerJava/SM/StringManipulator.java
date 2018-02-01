public class StringManipulator {
    public String trimAndConcat(String string1, Strincdg string2) {
 
        string1 = string1 .trim();
        string2 = string2 .trim();

        String newString = string1 + string2;

        return newString; 

    }

    public int getIndexOrNull(String input, char letter) {

        int index = input.indexOf(letter);
        
        return index;
            
    }

    public int getSubStringOrNull(String word, String subString) {
       
        int index = word.indexOf(subString);

        return index;

    }

    public String concatSubstring(String word, int start, int end, String word2) {
        
        String sub = word.substring(start, end); 

        String newString = sub + word2; 
        

        return newString;

    } 
}