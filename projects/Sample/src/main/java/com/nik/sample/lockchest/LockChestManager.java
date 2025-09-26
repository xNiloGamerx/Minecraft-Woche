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

        List<String> locations = new ArrayList<>();
        for (Location location : lockchests.keySet()) {
            locations.add(generateLocationString(location));
            config.set("lockchest.lockchests." + generateLocationString(location) + ".passwordHash", lockchests.get(location).getPasswordHash());
            config.set("lockchest.lockchests." + generateLocationString(location) + ".isLocked", lockchests.get(location).isLocked());
            config.set("lockchest.lockchests." + generateLocationString(location) + ".creatorUuid", lockchests.get(location).getCreator().getUniqueId().toString());
        }
        config.set("lockchest.locations", locations);
    }

    public void loadChests() {
        FileConfiguration config = Main.getInstance().getConfiguration().getConfig();

        List<String> locationStrings = config.getStringList("lockchest.locations");
        for (String locationString : locationStrings) {
            Location location = generateLocationFromString(locationString);
            String passwordHash = config.getString("lockchest.lockchests." + locationString + ".passwordHash");
            boolean isLocked = config.getBoolean("lockchest.lockchests." + locationString + ".isLocked");
            String playerUUID = config.getString("lockchest.lockchests." + locationString + ".creatorUuid");

            Player player = Bukkit.getPlayer(UUID.fromString(playerUUID));
            lockchests.put(location, new Lockchest(location, passwordHash, isLocked, player));
        }
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
            FileConfiguration config = Main.getInstance().getConfiguration().getConfig();
            // Config geht nicht richtig
            config.set("lockchest.lockchests", null);

            lockchests.remove(location);

            return true;
        }
        else {
            return false;
        }
    }
}
