package DChatSocket;

import DChatUtilities.DNetWork;
import DChatUtilities.DataBase;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import java.net.ServerSocket;

public class DServer {
    int DEFAULT_PORT = 666;
    int VOICE_CALL_PORT = 333;

    private DataOutputStream messageWriter;
    private DataInputStream messageReader;

    public Connection listenForCon() throws IOException {
        var ss = new ServerSocket(DEFAULT_PORT);
        var c = ss.accept();

        messageReader = new DataInputStream(c.getInputStream());
        messageWriter = new DataOutputStream(c.getOutputStream());

        var clientDNumber = DNetWork.parseToDNumber(c.getInetAddress().getHostAddress());

        var key = "";
        var salt = "";

        if(!DataBase.isExist(clientDNumber)) {
            key = messageReader.readUTF();
            salt = messageReader.readUTF();
        } else {
            key = DataBase.loadKey(clientDNumber);
            salt = DataBase.loadSalt(clientDNumber);
        }

        var port = messageReader.readInt();
        ss.close();

        var server = new ServerSocket(port);
        var client = server.accept();

        return new Connection(client.getInputStream(), client.getOutputStream(), clientDNumber, key, salt);
    }
}


