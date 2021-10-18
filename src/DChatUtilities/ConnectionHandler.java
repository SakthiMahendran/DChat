package DChatUtilities;

import DChatSocket.Connection;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ConnectionHandler {
    private Connection con;

    public ConnectionHandler(Connection con) throws FileNotFoundException {
        this.con = con;

        handleMessageReading();
        handleMessageWriting();
    }

    private void handleMessageReading(){
        var messageReadingThread = new Thread(new Runnable() {
            @Override
            public void run() {
                var consoleScanner = new Scanner(System.in);
                var console = System.out;
                while (true) {
                    try {
                        if(con.isFileData()) {
                            console.print("File Sent do u want to receive (y/n): ");
                            if(consoleScanner.nextLine().equalsIgnoreCase("y"))
                                con.readFile();
                            else
                                con.skipFile();
                        }
                        System.out.println(con.getFromDNumber()+": "+con.readString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "MessageReadingThread");

        messageReadingThread.start();
    }

    private void handleMessageWriting() {
        var messageWritingThread = new Thread(new Runnable() {
            @Override
            public void run() {
                var consoleScanner = new Scanner(System.in);
                while (true) {
                    var messageFromYou = consoleScanner.nextLine();
                    try {
                        con.writeString(messageFromYou);
                        System.out.println("You: "+messageFromYou);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "MessageWritingThread");

        messageWritingThread.start();
    }

    private String[] requestKeyandSalt() {
        return new String[2];
    }
}
