package com.company;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try {
            URL u = new URL("http://api.nbp.pl/api/exchangerates/tables/a/");
            HttpURLConnection hr = (HttpURLConnection) u.openConnection();
 //           System.out.println(hr.getResponseCode());
            if(hr.getResponseCode()==200){
                InputStream in = hr.getInputStream();
  //              StringBuffer sb = new StringBuffer();
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String line = br.readLine();
                while(line!=null){
                    System.out.println(line);
                    try(BufferedWriter writer = Files.newBufferedWriter(Paths.get("Wynik_kursy.csv"))){
                        writer.write(line);
                    }
                    line = br.readLine();
                }
            }

//            hr.setRequestMethod("GET");
//            System.out.println(hr.getHeaderField(1));


        }catch (Exception e){
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }
}
