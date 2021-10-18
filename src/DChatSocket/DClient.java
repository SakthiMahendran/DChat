package DChatSocket;

import DChatUtilities.DNetWork;
import DChatUtilities.DataBase;
import DChatUtilities.Encrypter;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;

public class DClient {

    public static final int PORT = 666;
    public static final int VOICE_CALL_PORT = 333;


    private DataOutputStream messageWriter;
    private DataInputStream messageReader;

    public Connection dialTo(String dNumber) {
        try {
            var ip = DNetWork.parseToIP(dNumber);
            var s = new Socket(ip, PORT);

            messageWriter = new DataOutputStream(s.getOutputStream());
            messageReader = new DataInputStream(s.getInputStream());

            var key = "";
            var salt = "";

            if(!DataBase.isExist(dNumber)) {
                key = Encrypter.generateKey();
                salt = Encrypter.generateSalt();

                System.out.println("k: " + key);
                System.out.println("s: "+ salt);

                messageWriter.writeUTF(key);
                messageWriter.flush();

                messageWriter.writeUTF(salt);
                messageWriter.flush();

                DataBase.register(dNumber, key, salt);
            } else {
                key = DataBase.loadKey(dNumber);
                salt = DataBase.loadSalt(dNumber);
            }
            var port = getFreePort();
            messageWriter.writeInt(port);
            messageWriter.flush();

            var server = new Socket(ip, port);

            return new Connection(server.getInputStream(), server.getOutputStream(), dNumber, key, salt);
        } catch (IOException e) {
            passToNetwork(dNumber, "");
        }
        return null;
    }

    private void passToNetwork(String dNumber, String message) {

    }

    private int getFreePort() throws IOException {
        var sock = new ServerSocket(0);
        int freePort = sock.getLocalPort();
        sock.close();
        return freePort;
    }
}
