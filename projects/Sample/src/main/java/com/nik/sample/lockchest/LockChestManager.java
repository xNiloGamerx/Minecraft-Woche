package com.nik.sample.lockchest;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class LockChestManager {
    private final HashMap<Location, Lockchest> lockchests;

    public LockChestManager() {
        lockchests = new HashMap<>();
    }

    public boolean isChestLocked(Location location) {
        Lockchest lockchest = lockchests.get(location);
        if (lockchest == null) {
            return false;
        }
        return lockchest.isLocked();
    }

    public void addLockChest(Location location, String passwordHash, Player creator) {
        lockchests.put(location, new Lockchest(location, passwordHash, creator));
    }

    public void addLockChest(Location location, String passwordHash, boolean locked, Player creator) {
        lockchests.put(location, new Lockchest(location, passwordHash, locked, creator));
    }

    public Lockchest getLockchest(Location location) {
        return lockchests.get(location);
    }

    public boolean isRightPassword(Location location, String passwordHash) {
        Lockchest lockchest = getLockchest(location);
        return lockchest.isRightHash(passwordHash);
    }

    public boolean unlockChest(Location location, String passwordHash) {
        if (isRightPassword(location, passwordHash)) {
            lockchests.remove(location);
            return true;
        }
        else {
            return false;
        }
    }
}
