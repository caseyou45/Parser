import BaseClasses.Element;
import BaseClasses.HtmlTag;
import Crawler.Crawler;
import File.FileHandler;
import Services.Analysis;
import Services.HtmlConfigParser;

import java.util.*;

import static File.FileHandler.*;


public class Main {
    private static final String base = "https://www.ou.edu/";
    private static final String fileName = base.substring(base.indexOf(".") + 1, base.lastIndexOf(".")) + ".json";
    private static final Map<HtmlTag, List<Element>> parentElementMap = Collections.synchronizedMap(new HashMap<>());
    private static final Set<String> syncSetForURLS = Collections.synchronizedSet(new HashSet<>());
    private static final String testHTML = FileHandler.FileToString("src/Test/STLEVENTS.html");

    public static void main(String[] args) {

        HtmlConfigParser htmlConfigParser = new HtmlConfigParser();


//        Crawler crawler = new Crawler(base, base, syncSetForURLS, parentElementMap, testHTML);
        Crawler crawler = new Crawler(base, base, syncSetForURLS, parentElementMap, htmlConfigParser.getTags());

        if (!fileExists(fileName)) {
            createFile(fileName);
            writeFile(fileName, "");
        }


        Thread initialThread = new Thread(crawler);

        initialThread.start();

        try {
            initialThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


//        JSON json = new JSON(syncSetForImageDTOs);

//        String result = json.getString();

        new Analysis(parentElementMap, htmlConfigParser, "ceo covid smiles molly female");


        appendToFile(fileName, "result");

    }


}
