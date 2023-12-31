package Services;

import BaseClasses.Element;
import BaseClasses.HtmlAttribute;
import Classes.Image;
import DTOs.DTO;
import DTOs.ImageDTO;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ImageAnalysis {

    private final List<Element> images;
    private final List<String> terms;
    private final String baseURL;
    private final String pageURL;
    private final Set<ImageDTO> imageDTOS;

    public ImageAnalysis(List<Element> images, String termsAsString, String baseURL, String pageURL) {
        this.images = images;
        this.terms = convertTermsStringToArrayList(termsAsString);
        this.baseURL = baseURL;
        this.pageURL = pageURL;
        this.imageDTOS = new HashSet<>();


        findImagesThatFitTerms();
    }

    private void findImagesThatFitTerms() {
        for (Element el : images) {
            Image im = (Image) el;
            for (String val : el.getAttributes().values()) {
                for (String term : terms) {
                    if (val.toLowerCase().contains(term.toLowerCase())) {
                        ImageDTO imageDTO = new ImageDTO();
                        imageDTO.setBaseURL(baseURL);
                        imageDTO.setPageURL(pageURL);
                        imageDTO.setSrc(URLTransform.cleanUpURL(baseURL, im.getAttributes().get(HtmlAttribute.SRC)));
                        imageDTO.setSrc(URLTransform.cleanUpURL(baseURL, im.getAttributes().get(HtmlAttribute.ALT)));

                        imageDTOS.add(imageDTO);


                    }
                }

            }
        }
    }

    private List<String> convertTermsStringToArrayList(String words) {
        return Arrays.asList(words.toLowerCase().split(" "));
    }

    public Set<ImageDTO> getImageDTOS() {
        return imageDTOS;
    }


}
