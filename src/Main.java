import Classes.ImageDTO;
import Crawler.Crawler;
import File.FileHandler;
import JSON.JSON;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import static Crawler.Crawler.runningThreads;
import static File.FileHandler.*;


public class Main {
    private static final String base = "https://www.ou.edu";


    public static <JsonObject> void main(String[] args) {
        String testHTML = FileHandler.FileToString("src/Test/STLEVENTS.html");


        Set<String> syncSetForURLS = Collections.synchronizedSet(new HashSet<>());
        Set<ImageDTO> syncSetForImageDTOs = Collections.synchronizedSet(new HashSet<>());

//        Crawler crawler = new Crawler(base, base, syncSetForURLS, syncSetForImageDTOs, testHTML);
        if (!fileExists("OU.json")) {
            createFile("OU.json");
//            writeFile("OU.json", "OU");
        }

        Crawler crawler = new Crawler(base, base, syncSetForURLS, syncSetForImageDTOs);

        Thread initialThread = new Thread(crawler);
        initialThread.start();
        try {
            initialThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        JSON json = new JSON(syncSetForImageDTOs);

        String result = json.getString();


        appendToFile("OU.json", result);

    }


}
