package DChatSocket;

import DChatUtilities.Decrypter;
import DChatUtilities.Encrypter;

import java.io.*;

public class Connection {
    private DataOutputStream messageWriter;
    private DataInputStream messageReader;

    private Encrypter encrypter;
    private Decrypter decrypter;

    private String fromDNumber;

    private long fileSize = 0;

    public Connection(DataInputStream dIS, DataOutputStream dOS, String fromDNumber, String key, String salt) {

        messageReader = dIS;
        messageWriter = dOS;

        this.fromDNumber = fromDNumber;

        setKeyandSalt(key, salt);
    }

    public Connection(InputStream inputStream, OutputStream outputStream, String dNumber, String key, String salt) {
        messageWriter = new DataOutputStream(outputStream);
        messageReader = new DataInputStream(inputStream);

        fromDNumber = dNumber;

        setKeyandSalt(key, salt);
    }

    public boolean isFileData() throws IOException {
        return  messageReader.readBoolean();
    }

    public String readString() throws IOException {
        return decrypter.decryptString(messageReader.readUTF());
    }

    public void writeString(String message) throws IOException {
        messageWriter.writeBoolean(false);
        messageWriter.writeUTF(encrypter.encryptString(message));
        messageWriter.flush();
    }

    public void writeFile(File file, String fileName, String fileExt) throws IOException {
        messageWriter.writeBoolean(true);

        var fileReader = new DataInputStream(new FileInputStream(file));
        var fileData = new byte[fileReader.available()];

        messageWriter.writeInt(fileReader.available());
        messageWriter.flush();

        fileReader.readFully(fileData);

        messageWriter.write(fileData);
        messageWriter.flush();

        messageWriter.writeUTF(fileName);
        messageWriter.flush();

        messageWriter.writeUTF(fileExt);
        messageWriter.flush();
    }

    public void readFile() throws IOException {
        var fileSize = messageReader.readInt();
        var fileData = new byte[fileSize];

        messageReader.read(fileData, 0, fileSize);

        var fileName = messageReader.readUTF();
        var fileExt = messageReader.readUTF();

        var file = new File(fileName+"."+fileExt);
        file.createNewFile();

        new FileOutputStream(file).write(fileData);
    }

    public void skipFile() throws IOException {
        if(fileSize !=0 )
            messageReader.skipNBytes(fileSize);
    }
    public String getFromDNumber() {
        return fromDNumber;
    }

    public void setKeyandSalt(String key, String salt) {
        encrypter = new Encrypter(key, salt);
        decrypter = new Decrypter(key, salt);
    }
}
