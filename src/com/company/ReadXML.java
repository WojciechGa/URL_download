package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;

public class ReadXML {
    public static void main(String[] args) {

        Calendar cal = Calendar.getInstance();
        Path file = Paths.get(String.format("%1$tF_kursy.walut.XML",cal));
        try{
            URL url = new URL("http://api.nbp.pl/api/exchangerates/tables/a/?format=xml");
            HttpURLConnection hr = (HttpURLConnection) url.openConnection();
            System.out.println(hr.getResponseCode());
            if(!Files.exists(file)){
                try{
                    InputStream in = hr.getInputStream();
                    Files.copy(in, file);
                    System.out.println("I read file");
                }catch (Exception e){
                    System.out.println(e);
                }
            }
        }
        catch (Exception e){

        }
    }
}
