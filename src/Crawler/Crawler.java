package Crawler;

import java.io.File;
import java.io.IOException;

import BaseClasses.Element;
import BaseClasses.Elements;
import Classes.ImageDTO;
import Parser.Parser;
import Services.AnchorAnalysis;
import Services.ImageAnalysis;
import Web.Web;
import File.FileHandler;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static File.FileHandler.*;


public class Crawler implements Runnable {
    public static int runningThreads = 1;
    private final String baseURL;
    private final String pageURL;
    private final String terms = "COVID Corona Virus Vaccination Delta variant isolation mask masks";
    private final Set<String> syncSetForURLS;
    private final Set<ImageDTO> syncSetForImageDTOs;
    private String testHTML;

    public Crawler(String baseURL, String pageURL, Set<String> syncSetForURLS, Set<ImageDTO> syncSetForImageDTOs) {
        this.baseURL = baseURL;
        this.pageURL = pageURL;
        this.syncSetForURLS = syncSetForURLS;
        this.syncSetForImageDTOs = syncSetForImageDTOs;

    }

    public Crawler(String baseURL, String pageURL, Set<String> syncSetForURLS, Set<ImageDTO> syncSetForImageDTOs, String testHTML) {
        this.baseURL = baseURL;
        this.pageURL = pageURL;
        this.syncSetForURLS = syncSetForURLS;
        this.syncSetForImageDTOs = syncSetForImageDTOs;
        this.testHTML = testHTML;
    }


    public void run() {
        crawl();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void crawl() {
        List<Thread> threads = new ArrayList<>();


        String html = null;

        if (testHTML != null && !testHTML.isEmpty()) {
            html = testHTML;
        } else {
            try {
                html = Web.sendGET(pageURL);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        if (html != null && !html.isEmpty()) {
            Parser parser = new Parser(html, baseURL, pageURL);
            Map<Elements, List<Element>> elementMap = parser.getElementMap();

            if (elementMap.get(Elements.IMAGE) != null) {
                Set<ImageDTO> imagesFromPage = new ImageAnalysis(elementMap.get(Elements.IMAGE), terms, baseURL, pageURL).getImageDTOS();
                syncSetForImageDTOs.addAll(imagesFromPage);

            }
            if (elementMap.get(Elements.ANCHOR) != null) {
                Set<String> anchorHrefs = new AnchorAnalysis(baseURL, elementMap.get(Elements.ANCHOR)).getAnchorHrefs();

                if (syncSetForURLS.size() < 100) {
                    for (String newPageURL : anchorHrefs) {
                        if (!newPageURL.isEmpty() && !syncSetForURLS.contains(newPageURL)) {
                            syncSetForURLS.add(newPageURL);
                            Crawler crawler = new Crawler(baseURL, newPageURL, syncSetForURLS, syncSetForImageDTOs);
                            Thread thread = new Thread(crawler);
                            threads.add(thread);
                            thread.start();


                        }
                    }

                }
            }


        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }


//    private void logImageIfNotAlready(Set<ImageDTO> imagesFromPage) {
//        for (ImageDTO imageDTO : imagesFromPage) {
//            if (!syncSetForImageDTOs.contains(imageDTO)) {
//                syncSetForImageDTOs.add(imageDTO);
//            }
//        }
//    }

}