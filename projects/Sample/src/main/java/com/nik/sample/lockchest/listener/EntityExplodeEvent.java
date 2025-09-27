package com.nik.sample.lockchest.listener;

import com.nik.sample.Main;
import com.nik.sample.lockchest.LockChestManager;
import org.bukkit.block.Block;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockExplodeEvent;

public class EntityExplodeEvent implements Listener {
    @EventHandler(ignoreCancelled = true)
    public void onEntityExplode(org.bukkit.event.entity.EntityExplodeEvent event) {
        LockChestManager lockChestManager = Main.getInstance().getLockChestManager();
        for (Block block : event.blockList()) {
            if (lockChestManager.getLockchest(block.getLocation()) != null) {
                event.blockList().remove(block);
            }
        }
    }

    @EventHandler(ignoreCancelled = true)
    public void onBlockExplode(BlockExplodeEvent event) {
        LockChestManager lockChestManager = Main.getInstance().getLockChestManager();
        for (Block block : event.blockList()) {
            if (lockChestManager.getLockchest(block.getLocation()) != null) {
                event.blockList().remove(block);
            }
        }
    }


}
