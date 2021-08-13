import java.util.regex.*;


public class Sample {
    public static void main(String[] args) {
        // Pattern pattern1=Pattern.compile("[\\_a-z]+d");
        // Matcher matcher=pattern1.matcher("_a");
        // boolean matches=matcher.matches();

        //boolean pattern = Pattern.matches("^[a-z0-9+\\_\\.\\,\\-]+@[a-z]+\\.[a-z]+$", "mohanraaaj34@gmail.com");
        // while(matcher.find()){
        //     System.out.println("starting point :"+matcher.start()+" ending point :"+matcher.end());
        // // }
        // System.out.println(pattern);
        // System.out.println(matches);
        // System.out.println(matcher.groupCount());
        Pattern pattern1=Pattern.compile("java");
        Matcher matcher=pattern1.matcher("language");
        // boolean matches=matcher.matches();

        while(matcher.find()){
            System.out.println(matcher.group());
        }
        
    }
}
