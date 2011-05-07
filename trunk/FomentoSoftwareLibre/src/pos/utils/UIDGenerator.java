package pos.utils;

import java.security.SecureRandom;

public class UIDGenerator {
    private static UIDGenerator guidgen;
    private SecureRandom random;

    private UIDGenerator() {
        this.random = new SecureRandom();
    }

    public static synchronized UIDGenerator getInstance() {
        if (guidgen == null) {
            guidgen = new UIDGenerator();
        }
        return guidgen;
    }

    public Integer getKey() {
        Integer key =random.nextInt();
        return key;
    }
}