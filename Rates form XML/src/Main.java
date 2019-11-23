import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.nio.file.Paths;
import java.util.regex.Matcher;

public class Main {

    public static void main(String[] args) {
        Table table = XMLFileReade("myRates.xml");
        System.out.println(table.kursy);

/*        Table table = new Table();
        table.kursy.put("EUR", 4.2898);
        table.kursy.put("USD", 3.9854);
        table.kursy.put("GBP", 4.9898);

        writeToXML(table, "myRates.xml");*/

    }

    public static void writeToXML (Table array, String fileName){
        File file = new File(fileName);
        try{
            JAXBContext jaxbContext = JAXBContext.newInstance(Table.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(array, file);

        }catch(JAXBException e){
            System.out.println(e);
        }
    }

    public static Table XMLFileReade(String fileName){
        File file = new File(fileName);
        Table table = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Table.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            table = (Table) unmarshaller.unmarshal(file);

        }catch (JAXBException e){
            System.out.println(e);
        }
        return table;
    }
}
