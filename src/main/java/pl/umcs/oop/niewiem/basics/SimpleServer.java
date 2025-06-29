package pl.umcs.oop.niewiem.basics;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    public static void main(String[] args) {
        int port = 12345; // przykładowy port
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Serwer nasłuchuje na porcie " + port);
            Socket clientSocket = serverSocket.accept();
            System.out.println("Połączono z klientem: " + clientSocket.getInetAddress());
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}