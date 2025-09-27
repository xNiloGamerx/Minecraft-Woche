package com.nik.sample.lockchest;

import com.nik.sample.Main;
import com.nik.sample.config.Config;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.*;

public class LockChestManager {
    private final HashMap<Location, Lockchest> lockchests;

    public LockChestManager() {
        lockchests = new HashMap<>();
    }

    private String generateLocationString(Location loc) {
        String locString = loc.getWorld().getName() + "," +
                loc.getX() + "," +
                loc.getY() + "," +
                loc.getZ() + "," +
                loc.getYaw() + "," +
                loc.getPitch();
        return locString;
    }

    private Location generateLocationFromString(String locationString) {
        String[] parts = locationString.split(",");

        World world = Bukkit.getWorld(parts[0]);
        double x = Double.parseDouble(parts[1]);
        double y = Double.parseDouble(parts[2]);
        double z = Double.parseDouble(parts[3]);
        float yaw = Float.parseFloat(parts[4]);
        float pitch = Float.parseFloat(parts[5]);

        return new Location(world, x, y, z, yaw, pitch);
    }

    public void saveChests() {
        FileConfiguration config = Main.getInstance().getConfiguration().getConfig();

        List<Integer> ids = new ArrayList<>();
        int currentId = 0;
        for (Location location : lockchests.keySet()) {
            ids.add(currentId);
            config.set("lockchest.lockchests." + currentId + ".location", generateLocationString(location));
            config.set("lockchest.lockchests." + currentId + ".passwordHash", lockchests.get(location).getPasswordHash());
            config.set("lockchest.lockchests." + currentId + ".isLocked", lockchests.get(location).isLocked());
            config.set("lockchest.lockchests." + currentId + ".creatorUuid", lockchests.get(location).getCreatorUuid().toString());
            currentId++;
        }
        config.set("lockchest.ids", ids);
    }

    public void loadChests() {
        FileConfiguration config = Main.getInstance().getConfiguration().getConfig();

        List<Integer> ids = config.getIntegerList("lockchest.ids");
        for (int id : ids) {
            Location location =  generateLocationFromString(config.getString("lockchest.lockchests." + id + ".location"));
            String passwordHash = config.getString("lockchest.lockchests." + id + ".passwordHash");
            boolean isLocked = config.getBoolean("lockchest.lockchests." + id + ".isLocked");
            String playerUUID = config.getString("lockchest.lockchests." + id + ".creatorUuid");

            assert playerUUID != null;
            lockchests.put(location, new Lockchest(location, passwordHash, isLocked, UUID.fromString(playerUUID)));
        }
    }

    public boolean isChestLocked(Location location) {
        Lockchest lockchest = lockchests.get(location);
        if (lockchest == null) {
            return false;
        }
        return lockchest.isLocked();
    }

    public void addLockChest(Location location, String passwordHash, UUID creatorUuid) {
        lockchests.put(location, new Lockchest(location, passwordHash, creatorUuid));
    }

    public void addLockChest(Location location, String passwordHash, boolean locked, UUID creatorUuid) {
        lockchests.put(location, new Lockchest(location, passwordHash, locked, creatorUuid));
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
            FileConfiguration config = Main.getInstance().getConfiguration().getConfig();
            config.set("lockchest.lockchests", null);
            lockchests.remove(location);

            return true;
        }
        else {
            return false;
        }
    }
}
