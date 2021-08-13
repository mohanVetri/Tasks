import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {

	public boolean isMatch(String regex,String input) {
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(input);
        boolean isMatch=matcher.matches();
        //Another method: boolean isMatch=Pattern.matches(regex,input);
		return isMatch;
	}

	public boolean findMethod(String regex, String input) {
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(input);
		return matcher.find();
	}

	public int startMethod(String regex, String input) {
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(input);
        int index=0;
        if(matcher.find()){
		index= matcher.start();
        }
        return index;
	}

	public int endMethod(String regex, String input) {
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(input);
        int index=0;
        if(matcher.find()){
		index= matcher.end();
        }
        return index;
	}

	public String groupMethod(String regex, String input) {
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(input);
        String matchSequence="";
        if(matcher.find()){
		matchSequence=matcher.group();
        }
        return matchSequence;
	}

	public Object groupCountMethod(String regex, String input) {
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(input);
		return matcher.groupCount();
	}

	public boolean emailIsValid(String regex, String input) {
		Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(input);
        boolean isValid=matcher.matches();
        return isValid;
	}

    public static void main(String[] args) {
        Pattern pattern=Pattern.compile("(java)");
        Matcher matcher=pattern.matcher("javalanguagejava");
        while (matcher.find()) {
           System.out.println(matcher.group());
        }
    }

}
