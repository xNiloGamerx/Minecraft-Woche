package com.nik.sample.lockchest;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.UUID;


public class Lockchest {
    private final Location location;
    private final String passwordHash;
    private boolean locked;
    private final UUID creatorUuid;

    public Lockchest(Location location, String passwordHash, UUID creatorUuid) {
        this.location = location;
        this.passwordHash = passwordHash;
        this.locked = true;
        this.creatorUuid = creatorUuid;
    }

    public Lockchest(Location location, String passwordHash, boolean locked, UUID creatorUuid) {
        this.location = location;
        this.passwordHash = passwordHash;
        this.locked = locked;
        this.creatorUuid = creatorUuid;
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

    public boolean updatePassword(String oldHash, String newHash) {
        return false;
    }

    public boolean isRightHash(String hash) {
        return hash.equals(this.passwordHash);
    }

    public UUID getCreatorUuid() {
        return creatorUuid;
    }

    public Player getCreator() {
        return Bukkit.getPlayer(creatorUuid);
    }
}
