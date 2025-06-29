package pl.umcs.oop.niewiem.basics;

import java.io.IOException;
import java.net.Socket;

public class ClientHandlerB implements Runnable{//najprostszy, funkcjonalny clienthandler
    private final Socket clientSocket;

    public ClientHandlerB(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run(){
        try{
            clientSocket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
