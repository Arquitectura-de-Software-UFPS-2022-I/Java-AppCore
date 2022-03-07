/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import models.FileDto;

/**
 *
 * @author USUARIO
 */
public class ServiceHttp {

    static final ResourceBundle RB = ResourceBundle.getBundle("resources.parametros");
    static final String BASE = RB.getString("BASE");
    static final String LINE_FEED = "\r\n";
    static final String BOUNDARY = "===***===";

    public static <T> List<T> HttpGetList(String url, Class<T[]> type) {
        String result = HttpGet(url);
        if (result != null) {
            try {
                return Arrays.asList(new Gson().fromJson(result, type));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static <T> T HttpGetOne(String url, Class<T> type) {
        String result = HttpGet(url);
        if (result != null) {
            return (T) new Gson().fromJson(result, type);
        }
        return null;
    }

    public static String HttpGet(String url) {
        try {

            HttpURLConnection conn = (HttpURLConnection) new URL(BASE + url).openConnection();

            conn.setRequestProperty("Content-Type", "application/json; utf-8");

            BufferedReader br;
            if (100 <= conn.getResponseCode() && conn.getResponseCode() <= 399) {
                br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {
                br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }

            return br.lines().collect(Collectors.joining());

        } catch (IOException ex) {
            Logger.getLogger(ServiceHttp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String HttpDelete(String url) {
        try {

            HttpURLConnection conn = (HttpURLConnection) new URL(BASE + url).openConnection();

            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setRequestMethod("DELETE");

            BufferedReader br;
            if (100 <= conn.getResponseCode() && conn.getResponseCode() <= 399) {
                br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {
                br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }

            return br.lines().collect(Collectors.joining());

        } catch (IOException ex) {
            Logger.getLogger(ServiceHttp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String HttpPut(String url, String params) {
        return HttpPostOrPut(url, params, "PUT");
    }

    public static String HttpPost(String url, String params) {
        return HttpPostOrPut(url, params, "POST");
    }

    public static <T> T HttpPut(String url, Class<T> type, T model) {
        String params = model.toString();        
        String result = HttpPostOrPut(url, params, "PUT");
        
        if (result != null) {
            return new Gson().fromJson(result, type);
        }
        return null;
    }

    public static <T> T HttpPost(String url, Class<T> type, T model) {
        String params = model.toString();        
        String result = HttpPostOrPut(url, params, "POST");
        if (result != null) {
            return new Gson().fromJson(result, type);
        }
        return null;
    }

    private static String HttpPostOrPut(String url, String params, String type) {
        try {

            HttpURLConnection conn = (HttpURLConnection) new URL(BASE + url).openConnection();

            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestMethod(type);
            conn.setDoOutput(true);
            try (OutputStream os = conn.getOutputStream()) {
                os.write(params.getBytes("UTF-8"));
            }

            BufferedReader br;
            if (100 <= conn.getResponseCode() && conn.getResponseCode() <= 399) {
                br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {
                br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }

            return br.lines().collect(Collectors.joining());

        } catch (IOException ex) {
            Logger.getLogger(ServiceHttp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static FileDto HttpPost(String url, String name, File file) {
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(BASE + url).openConnection();

            conn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + BOUNDARY);
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setUseCaches(false);
            OutputStream outputStream;
            PrintWriter writer;
            outputStream = conn.getOutputStream();
            writer = new PrintWriter(new OutputStreamWriter(outputStream, "UTF-8"), true);

            AddFilePart("file", file, writer, outputStream);
            AddFormField("name", name, writer);

            BufferedReader br;
            if (100 <= conn.getResponseCode() && conn.getResponseCode() <= 399) {
                br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {
                br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }

            return new Gson().fromJson(br.lines().collect(Collectors.joining()), FileDto.class);

        } catch (IOException ex) {
            Logger.getLogger(ServiceHttp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private static void AddFormField(String name, String value, PrintWriter writer) {
        writer.append("--" + BOUNDARY).append(LINE_FEED);
        writer.append("Content-Disposition: form-data; name=\"" + name + "\"")
                .append(LINE_FEED);
        writer.append("Content-Type: text/plain; charset=" + "UTF-8").append(
                LINE_FEED);
        writer.append(LINE_FEED);
        writer.append(value).append(LINE_FEED);
        writer.flush();
    }

    private static void AddFilePart(String fieldName, File uploadFile, PrintWriter writer, OutputStream outputStream)
            throws IOException {
        String fileName = uploadFile.getName();
        writer.append("--" + BOUNDARY).append(LINE_FEED);
        writer.append("Content-Disposition: form-data; name=\"" + fieldName
                + "\"; filename=\"" + fileName + "\"")
                .append(LINE_FEED);
        writer.append("Content-Type: "
                + URLConnection.guessContentTypeFromName(fileName))
                .append(LINE_FEED);
        writer.append("Content-Transfer-Encoding: binary").append(LINE_FEED);
        writer.append(LINE_FEED);
        writer.flush();

        try (FileInputStream inputStream = new FileInputStream(uploadFile)) {
            byte[] buffer = new byte[4096];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.flush();
        }
        writer.append(LINE_FEED);
        writer.flush();
    }

}
