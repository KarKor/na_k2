package pl.umcs.oop.niewiem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private final Socket clientSocket;
    private final Window window;
    private String currentColor = "000000";

    public ClientHandler(Socket socket, Window window) {
        this.clientSocket = socket;
        this.window = window;
    }

    @Override
    public void run() {

        try(BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()))){
            String message;
            while((message = in.readLine())!= null) {
                // Sprawdź, czy to kolor czy współrzędne
                if (/*message.matches("[09AFaf]{6}")*/ message.length()==6) {
                    currentColor = message;
                    window.draw();
                } else {//if (message.matches("(-?\\d+(\\.\\d+)?\\s+){3}-?\\d+(\\.\\d+)?")) {
                    String[] parts = message.split("\\s+");
                    double x1 = Double.parseDouble(parts[0]);
                    double y1 = Double.parseDouble(parts[1]);
                    double x2 = Double.parseDouble(parts[2]);
                    double y2 = Double.parseDouble(parts[3]);
                    window.addToList(x1, y1, x2, y2, currentColor);
                    window.draw();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                // Tutaj obsługa komunikacji z klientem
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}