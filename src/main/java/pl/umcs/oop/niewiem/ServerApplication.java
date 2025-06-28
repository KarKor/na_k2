package pl.umcs.oop.niewiem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApplication extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        BorderPane pane = new BorderPane();
        Window window = new Window();
        pane.setCenter(window);
        window.draw();
        Point currentCenter = window.getCenter();

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("Nie Wiem");
        stage.show();

        // Uruchom serwer w osobnym wątku
        new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(5000)) {
                System.out.println("Server listening on port " + serverSocket.getLocalPort());
                while (true) {
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("Connected to client: " + clientSocket.getInetAddress());
                    // Obsługa klienta w osobnym wątku
                    new Thread(new ClientHandler(clientSocket, window)).start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();


    }

    public static void main(String[] args) {
        launch();
    }
}