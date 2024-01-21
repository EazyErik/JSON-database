package client;


import com.beust.jcommander.JCommander;
import server.ServerResponse;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Main {

    static String address = "127.0.0.1";
    static int port = 23456;

    static Socket socket;


    public static void main(String[] args) throws IOException {
        Args arguments = new Args();

        JCommander.newBuilder()
                .addObject(arguments)
                .build()
                .parse(args);


        socket = new Socket(InetAddress.getByName(address), port);

        DataOutputStream output = new DataOutputStream(socket.getOutputStream());


        DataInputStream input = new DataInputStream(socket.getInputStream());
        System.out.println("Client started!");
        output.writeUTF(arguments.toJSON());
        System.out.println("Sent: " + arguments.toJSON());



       System.out.println(input.readUTF());



    }



}
