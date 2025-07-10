package com.itersdesktop.javatechs.callapis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class UrlHttpConnectionDemo {
    private static final Logger LOGGER = LoggerFactory.getLogger(UrlHttpConnectionDemo.class);

    public static void main(String[] args) throws IOException {
        String content;
        content = hit(Helpers.API_URL, 1, null);
        Helpers.extracted(content);
    }

    private static String hit(final String strURL, final int op, final Proxy proxy) throws IOException {
        URL url = new URL(strURL);
        String result;
        HttpURLConnection conn = null;
        try {
            if (proxy != null) {
                conn = (HttpURLConnection) url.openConnection(proxy);
            } else {
                conn = (HttpURLConnection) url.openConnection();
            }

            conn.setConnectTimeout(15000);
            conn.setReadTimeout(30000);
            conn.connect();
            if (conn.getResponseCode() < 400) {
                if (op == 0) {
                    result = String.valueOf(conn.getResponseCode());
                } else {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    String line;
                    StringBuilder content = new StringBuilder();
                    // reading from the UrlHttpConnection using the buffered reader
                    while ((line = bufferedReader.readLine()) != null) {
                        content.append(line).append("\n");
                    }
                    bufferedReader.close();
                    result = content.toString();
                }
            } else {
                result = String.valueOf(conn.getResponseCode());
                LOGGER.error("Couldn't fetch data from the resource {} due to {}", strURL, conn.getResponseMessage());
            }
        } catch (SocketTimeoutException ste) {
            assert conn != null;
            result = String.valueOf(conn.getResponseCode());
            LOGGER.error("Error while trying to retrieve data from {} due to {}", strURL, conn.getResponseMessage());
        } catch (IllegalArgumentException iae) {
            assert conn != null;
            result = String.valueOf(conn.getResponseCode());
            LOGGER.error("The proxy setting cannot be null or {}", iae.getMessage());
        } catch (FileNotFoundException exception) {
            assert conn != null;
            result = String.valueOf(conn.getResponseCode());
            LOGGER.error("File Not Found {}", exception.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            assert conn != null;
            if (conn.getResponseCode() < 400)  {
                conn.getInputStream().close();
            }
        }
        return result;
    }
}
