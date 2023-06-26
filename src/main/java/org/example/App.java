package org.example;
//test

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        HttpServer server = null;
        try {
            server = HttpServer.create(new InetSocketAddress(8765), 0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        server.createContext("/", new MioHandler());
        server.setExecutor(null);
        server.start();
    }
}
