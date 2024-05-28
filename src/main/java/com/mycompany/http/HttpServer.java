/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.http;

/**
 *
 * @author ACER
 */
import java.io.IOException;
import java.io.File;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {

    private static final int LINGER_TIME  = 5000;
    private final File rootDir = new File("www");
    private final int portNo=8080;
    private void serve() {
        try {
            ServerSocket listeningSocket = new ServerSocket(portNo);
            while (true) {
                Socket clientSocket = listeningSocket.accept();
                clientSocket.setSoLinger(true, LINGER_TIME);
                
                Thread handler = new Thread(new RequestHandler(clientSocket, rootDir));
                handler.setPriority(Thread.MAX_PRIORITY);
            handler.start();
            }
        } catch (IOException e) {
            System.err.println("Server failure.");
        }
    }
    public static void main(String[] args) {
        HttpServer server = new HttpServer();
        server.parseArguments(args);
        server.serve();
    }

    private void parseArguments(String[] arguments) {
        if (arguments.length > 0) {
            
        }
    }
}
