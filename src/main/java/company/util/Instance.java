package company.util;

import lombok.experimental.UtilityClass;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;

@UtilityClass
public class Instance {

    public static String getHostAddress() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            return UUID.randomUUID().toString();
        }
    }
}
