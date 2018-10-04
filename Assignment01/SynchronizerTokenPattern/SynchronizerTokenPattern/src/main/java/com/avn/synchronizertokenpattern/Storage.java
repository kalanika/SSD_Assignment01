
package com.avn.synchronizertokenpattern;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author erandi
 */
public class Storage {

    private static Storage storage = new Storage();
    private Map<String, String> storageMap = new HashMap<String, String>();

    public static Storage getStorage() {
        return storage;
    }

    public void addCookie(String sessionId, String token) {
        storageMap.put(sessionId, token);
    }

    public String getCookie(String sessionId) {
        for (Map.Entry<String, String> entry : storageMap.entrySet()) {
            if (sessionId.equals(entry.getKey())) {
                return entry.getValue();
            }
        }
        return null;
    }

    public void printCookie() {
        for (Map.Entry<String, String> entry : storageMap.entrySet()) {
            System.out.println("SessionID" + entry.getKey() + " Token" + entry.getValue());
        }
    }
}
