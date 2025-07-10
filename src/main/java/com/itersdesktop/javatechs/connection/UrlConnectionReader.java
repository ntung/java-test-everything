package com.itersdesktop.javatechs.connection;//package com.itersdesktop;

import java.net.*;
import java.io.*;

public class UrlConnectionReader {
    public static void main(String[] args) {
        String theUrl = "https://rest.kegg.jp/get/C12345";
        theUrl = "https://www.ebi.ac.uk/biomodels/model/download/BIOMD0000000758.3?filename=Babbs2012.xml";
        String output = getUrlContents(theUrl);
        System.out.println(output);
    }

    public static String getUrlContents(String theUrl) {
        StringBuilder content = new StringBuilder();
        // Use try and catch to avoid the exceptions
        try {
            URL url = new URL(theUrl); // creating a url object
            URLConnection urlConnection = url.openConnection(); // creating an urlconnection object

            // wrapping the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            // reading from the urlconnection using the bufferedreader
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}
