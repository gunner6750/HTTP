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
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleHTTPServer {

    public static void main(String[] args) throws Exception {
        final ServerSocket server = new ServerSocket(8080);
        System.out.println("Listening for connection on port 8080 ....");
        while (true) { // spin forever } } }
            Socket clientSocket = server.accept();
            InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
            BufferedReader reader = new BufferedReader(isr);
            String line = reader.readLine();
            while (!line.isEmpty()) {
                System.out.println(line);
                line = reader.readLine();
            }
        }
    }
}
