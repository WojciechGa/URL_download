import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;

public class ReadRates {

    public static void main(String[] args) {
        readCurrentNBPRatesToXML();
    }

    private static void readCurrentNBPRatesToXML(){
        Calendar calendar = Calendar.getInstance();
        try{
        URL url = new URL("http://api.nbp.pl/api/exchangerates/tables/a/?format=xml");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        System.out.println(httpURLConnection.getResponseCode());
        if(httpURLConnection.getResponseCode()==200){
            InputStream in = httpURLConnection.getInputStream();
            Files.copy(in, Paths.get(String.format("%1tF_nbp_rates.xml",calendar)));
            System.out.println("coping file");
        }

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
