package com.nik.sample.lockchest.listener;

import com.nik.sample.Main;
import com.nik.sample.lockchest.LockChestManager;
import com.nik.sample.lockchest.Lockchest;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BreakBlockListener implements Listener {
    @EventHandler(ignoreCancelled = true)
    public void onBlockBreak(BlockBreakEvent event) {
        Location location = event.getBlock().getLocation();
        LockChestManager lockChestManager = Main.getInstance().getLockChestManager();

        Lockchest lockchest = lockChestManager.getLockchest(location);
        if (lockchest != null && lockchest.isLocked()) {
            event.setCancelled(true);
        }
    }

}
