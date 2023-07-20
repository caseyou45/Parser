package Crawler;

import java.io.IOException;

import BaseClasses.Element;
import BaseClasses.HtmlTag;
import Parser.Parser;
import Services.Analysis;
import Services.AnchorAnalysis;
import Services.ImageAnalysis;
import Web.Web;


import java.util.*;


public class Crawler implements Runnable {
    public static int runningThreads = 1;
    private final String baseURL;
    private final String pageURL;
    private final Set<String> syncSetForURLS;
    private final Map<HtmlTag, List<Element>> parentElementMap;
    private String testHTML;

    public Crawler(String baseURL, String pageURL, Set<String> syncSetForURLS, Map<HtmlTag, List<Element>> parentElementMap) {
        this.baseURL = baseURL;
        this.pageURL = pageURL;
        this.syncSetForURLS = syncSetForURLS;
        this.parentElementMap = parentElementMap;

    }

    public Crawler(String baseURL, String pageURL, Set<String> syncSetForURLS, Map<HtmlTag, List<Element>> parentElementMap, String testHTML) {
        this.baseURL = baseURL;
        this.pageURL = pageURL;
        this.syncSetForURLS = syncSetForURLS;
        this.testHTML = testHTML;
        this.parentElementMap = parentElementMap;
    }


    public void run() {
        crawl();
        try {
            Thread.sleep(0);
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
            Parser parser = new Parser(html);
            Map<HtmlTag, List<Element>> elementMap = parser.getElementMap();


            for (Map.Entry<HtmlTag, List<Element>> thisThreadElement : elementMap.entrySet()) {
                HtmlTag keyToBePut = thisThreadElement.getKey();
                List<Element> listFromParent = parentElementMap.getOrDefault(keyToBePut, new ArrayList<>());
                listFromParent.addAll(thisThreadElement.getValue());
                parentElementMap.put(keyToBePut, listFromParent);

            }


            if (elementMap.get(HtmlTag.A) != null) {
                Set<String> anchorHrefs = new AnchorAnalysis(baseURL, elementMap.get(HtmlTag.A)).getAnchorHrefs();

                if (syncSetForURLS.size() < 20) {
                    for (String newPageURL : anchorHrefs) {
                        if (!newPageURL.isEmpty()) {
                            syncSetForURLS.add(newPageURL);

                            Crawler crawler = new Crawler(baseURL, newPageURL, syncSetForURLS, parentElementMap);
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


}