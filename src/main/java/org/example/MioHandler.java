package org.example;


import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.net.URI;
import java.util.ArrayList;

public class MioHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        InputStream is = exchange.getRequestBody();

        URI uri = exchange.getRequestURI();
        System.out.println(uri);

        String method = exchange.getRequestMethod();
        System.out.println(method);

        String s = read(is);
        System.out.println(s);

        String myAnswer = response(uri.toString());
        String response = "<!doctype html>\n" +
                "<html lang=en>\n" +
                "<head>\n" +
                "<meta charset=utf-8>\n" +
                "<title>MyExam</title>\n" +
                "</head>\n" +
                "<body style='margin-left: 35%'>\n" +
                "<h1 style='color: green'> ilPlataHotelManagement </h1> \n" +
                "</br>query result:" +
                "<table style='border-style: solid'>\n" +
                "<tr style='border-style: solid'>\n" +
                "<th style='border-style: solid'>" + "Description" + "</th>" +
                "<th style='border-style: solid'>" + "Id" + "</th>" +
                "<th style='border-style: solid'>" + "Name" + "</th>" +
                "<th style='border-style: solid'>" + "Price" + "</th>" +
                "<th style='border-style: solid'>" + "Is it Suite?" + "</th>" +
                "</tr>\n" +
                myAnswer +
                "</table>\n" +
                "</body>\n" +
                "</html>\n";

        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
    private String read(InputStream is) {
        BufferedReader br = new BufferedReader( new InputStreamReader(is) );
        System.out.println("\n");
        String received = "";
        while (true) {
            String s = "";
            try {
                if ((s = br.readLine()) == null) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(s);
            received += s;
        }
        return received;
    }

    public String response(String uri) {
        String[] res = uri.split("[/?" +
                "" +
                "&]");
        ArrayList<String> ls = new ArrayList<>();
        if (res.length == 0) {
            return "No data";
        }

        for (String r : res) {
            if (r.contains("cmd")) {
                ls.add(r);
            }
        }

        String answer = "";
        String[] s;
        if (ls.get(0).contains("cmd")) {
            s = ls.get(0).split("=");
            answer = RequestHandler.getInstance().getAction(s[1]);
        }

        return answer;
    }


}
