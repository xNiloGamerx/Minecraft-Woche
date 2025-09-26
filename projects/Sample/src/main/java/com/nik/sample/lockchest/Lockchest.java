package com.nik.sample.lockchest;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;


public class Lockchest {
    private final Location location;
    private final String passwordHash;
    private boolean locked;
    private Player creator;

    public Lockchest(Location location, String passwordHash, Player creator) {
        this.location = location;
        this.passwordHash = passwordHash;
        this.locked = true;
        this.creator = creator;
    }

    public Lockchest(Location location, String passwordHash, boolean locked, Player creator) {
        this.location = location;
        this.passwordHash = passwordHash;
        this.locked = locked;
        this.creator = creator;
    }

    public Location getLocation() {
        return location;
    }

    public String getPasswordHash() {
        return passwordHash;
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

    public boolean isRightHash(String hash) {
        return hash.equals(this.passwordHash);
    }

    public Player getCreator() {
        return creator;
    }
}
