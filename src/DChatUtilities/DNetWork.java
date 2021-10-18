package DChatUtilities;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class DNetWork {
    public static boolean isConnected() throws UnknownHostException {
        if (getMyIp().equals("127.0.0.1"))
            return false;
        else
            return true;
    }

    public static String parseToIP(String dNumber) throws UnknownHostException {
        return DString.insertString(dNumber, ".", new int[]{3, 6, 8});
    }

    public static String parseToDNumber(String ip) throws UnknownHostException {
        return ip.replace(".", "");
    }

    public static String getMyIp() throws UnknownHostException {
        return InetAddress.getLocalHost().getHostAddress();
    }

    public static String getMyDNumber() throws UnknownHostException {
        return parseToDNumber(getMyIp());
    }
}
