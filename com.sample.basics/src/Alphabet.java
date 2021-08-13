public class Alphabet {

    static final String word="java language";

    public static String concatMethod() {
        // word="Hi"; //Final variable can't change
        String newWord = word.concat(".");
        return newWord;
	}

    public String subStringMethodWithIndex(){
        return word.substring(5);
    }
    
    public String subStringMethodWithTwoIndex(){
        return word.substring(5,8);
    }

	public String trimMethod() {
		return " java language  ".trim();
	}

	public char charAtMethod(int index) {
		return word.charAt(index);
	}

	public boolean equalsMethod(String string) {
		return word.equals(string);
	}

	public String replaceMethod(String oldWord, String newWord) {
		return word.replace(oldWord, newWord);
	}

    public String[] splitMethod() {
        String sentence="hi how are you";
        String[] sentenceArray=sentence.split(" ",3);
		return sentenceArray;
	}

}
