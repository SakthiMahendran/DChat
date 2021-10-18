package DChat;

import DChatUI.MainUi;
import DChatUtilities.DataBase;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        checkConfigurations();
        MainUi.main();
    }

    public static void checkConfigurations() throws IOException {
        var file = new File(DataBase.keyFileName);

        if ((!file.isFile()) || (!file.exists()))
            file.createNewFile();

    }
}
/*
    public static void startServer() {
        var serverThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        new ConnectionHandler(new DServer().listenForCon());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "ServerThread");

        serverThread.start();
    }

    public static void startClient(String dNumber) {
        var clientThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    new ConnectionHandler(new DClient().dialTo(dNumber));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }, "ClientThread");

        clientThread.start();
    }

    public static void checkLatestMessage() {

    }

}
*/