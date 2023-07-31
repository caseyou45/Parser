package Web;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Web {

//    public static String sendGETSelenium(String searchURL) throws IOException {
//
//        Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("headless");
//
//        WebDriver driver = new ChromeDriver(options);
//
//        driver.get(searchURL);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(100));
//        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
//
//        String htmlContent = driver.getPageSource();
//
//        driver.quit();
//        return htmlContent;
//
//    }

    public static String sendGET(String searchURL) throws IOException {

        try {
            URL obj = new URL(searchURL);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.addRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:109.0) Gecko/20100101 Firefox/114.0");
            int responseCode = con.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                return response.toString();

            } else {
                // System.out.println("Fail Get. Response Code" + responseCode + ".URL: " + searchURL);
            }
        } catch (Exception e) {
            //  System.out.println("Fail." + e.getMessage() + ".URL: " + searchURL);

        }

        return "";

    }
}
