import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;


public class SearchEngine implements URLHandler {
    
    ArrayList<String> strings = new ArrayList<String>();

    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return String.format(strings.toString());
        }
        else if (url.getPath().contains("/add")) {
            String[] newString = url.getQuery().split("=");
            strings.set(strings.size(), newString[0]);
            return String.format(strings.toString());
        }
        else if (url.getPath().contains("/search")) {
            String toFind = url.getQuery().split("=")[0];
            ArrayList<String> contains = new ArrayList<>();
            for (int i = 0; i < strings.size(); i++) {
                if (strings.get(i).contains(toFind)) {
                    contains.set(contains.size(), strings.get(i));
                }
            }
            return contains.toString();
        }
        return strings.toString();
    }
}
