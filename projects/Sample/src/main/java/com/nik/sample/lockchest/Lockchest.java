package com.nik.sample.lockchest;

import javax.xml.stream.Location;

public class Lockchest {
    private final Location location;
    private final String passwordHash;
    private boolean locked;

    Lockchest(Location location, String passwordHash) {
        this.location = location;
        this.passwordHash = passwordHash;
        this.locked = true;
    }

    Lockchest(Location location, String passwordHash, boolean locked) {
        this.location = location;
        this.passwordHash = passwordHash;
        this.locked = locked;
    }

    public Location getLocation() {
        return location;
    }

    public boolean isLocked() {
        return locked;
    }

    public boolean lock(String inputHash) {
        return false;
    }

    public boolean unlock(String inputHash) {
        return false;
    }

    public boolean updatePassword(String oldHash, String newHash) {
        return false;
    }
}
