package main;

import networking.Server;

public class ServerExe {

    public static void main(String[] args){
        //just starts a server to connect to
        Server server = new Server();
        server.start();
    }
}
