import javafx.scene.control.Tab;

import javax.print.DocFlavor;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.IOException;
import java.util.HashMap;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Table {

    HashMap<String, Double> kursy = new HashMap<>();

    Table(){}

    public HashMap<String, Double> getKursy() {
        return kursy;
    }

    public void setKursy(String s1, String s2) {
        try{
            this.kursy.put(s1, Double.parseDouble(s2));
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
