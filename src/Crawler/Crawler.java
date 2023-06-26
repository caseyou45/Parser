package Crawler;

import java.io.IOException;

import BaseClasses.Element;
import BaseClasses.Elements;
import Classes.Anchor;
import Classes.ImageDTO;
import Parser.Parser;
import Services.AnchorAnalysis;
import Services.ImageAnalysis;
import Web.Web;


import java.util.List;
import java.util.Map;
import java.util.Set;


public class Crawler implements Runnable {
    private final String baseURL;
    private final String pageURL;
    private final String terms = "COVID 19 Corona Virus Safety Prevention Guidelines Mask Handwashing Sanitization Social distancing Vaccination Symptoms Testing Quarantine Isolation Stay home Ventilation Health Hygiene Awareness Public health Delta variant";
    private final Set<String> syncSet;

    public Crawler(Set<String> syncSet, String baseURL, String pageURL) {
        this.baseURL = baseURL;
        this.syncSet = syncSet;
        this.pageURL = pageURL;

    }


    public void run() {

        String html = null;

        try {
            html = Web.sendGET(pageURL);
        } catch (IOException e) {
            e.printStackTrace();
        }


        if (html != null && !html.isEmpty()) {
            Parser parser = new Parser(html, baseURL, pageURL);
            Map<Elements, List<Element>> elementMap = parser.getElementMap();
            Set<ImageDTO> imagesFromPage = new ImageAnalysis(elementMap.get(Elements.IMAGE), terms, baseURL, pageURL).getImageDTOS();
            Set<String> anchorHrefs = new AnchorAnalysis(baseURL, elementMap.get(Elements.ANCHOR)).getAnchorHrefs();
            System.out.println(anchorHrefs);
//
//            if (!newPageURL.isEmpty() && !syncSet.contains(newPageURL)) {
//                if (syncSet.size() < 500) {
//                    Crawler crawler = new Crawler(syncSet, baseURL, newPageURL);
//                    Thread thread = new Thread(crawler);
//                    thread.start();
//                    syncSet.add(newPageURL);
//                }
//
//            }
        }


    }
}