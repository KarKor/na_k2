package pl.umcs.oop.niewiem;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static Socket socket;
    public static void main(String[] args) {

        try{
            socket = new Socket("localhost", 5000);
            System.out.println("connected successfully");

            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            Scanner scanner = new Scanner(System.in);

            while (true){
                System.out.println("Insert message (color or coordinates)");
                String  message = scanner.nextLine();
                out.println(message);
                out.flush();
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }


}
