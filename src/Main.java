import Crawler.Crawler;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Main {
    private static final String pageURL = "https://www.ou.edu/campussafety/covid-19-information";
    private static final String base = "https://www.ou.edu";


    public static void main(String[] args) {
        Set<String> syncSet = Collections.synchronizedSet(new HashSet<>());
        Crawler crawler = new Crawler(syncSet, base, pageURL);
        Thread initialThread = new Thread(crawler);
        initialThread.start();
    }


}
