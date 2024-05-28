/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.http;

/**
 *
 * @author ACER
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class HttpClient {


    public static void main(String[] args) {
        String httpServer = args[0];
        int serverPort = Integer.parseInt(args[1]);
        int timeoutMillis = 10000;
        String httpRequest = "GET / HTTP/1.1";
        String hostHeader = "Host: " + httpServer;
        try (Socket socket = new Socket(httpServer, serverPort)) {
            socket.setSoTimeout(timeoutMillis);
            PrintWriter toServer = new PrintWriter(socket.getOutputStream());
            toServer.println(httpRequest);
            toServer.println(hostHeader);
            toServer.println();
            toServer.flush();
            BufferedReader fromServer
                    = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String str;
            while ((str = fromServer.readLine()) != null) {
                System.out.println(str);
            }
        } catch (IOException e) {
        }
    }
}
