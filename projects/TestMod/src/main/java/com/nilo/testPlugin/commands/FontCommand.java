package com.nilo.testPlugin.commands;

import com.destroystokyo.paper.profile.PlayerProfile;
import com.destroystokyo.paper.profile.ProfileProperty;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.tree.LiteralCommandNode;
import com.nilo.testPlugin.tags.Tag;
import com.nilo.testPlugin.tags.TagManager;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.object.ObjectContents;
import net.kyori.adventure.text.object.PlayerHeadObjectContents;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.Set;

public class FontCommand {
    public static LiteralCommandNode<CommandSourceStack> getCommand() {
        return Commands.literal("font")
                .executes(ctx -> {
                    CommandSender sender = ctx.getSource().getSender();
                    Entity executor = ctx.getSource().getExecutor();
                    if (!(sender instanceof Player player)) return Command.SINGLE_SUCCESS;

                    Set<ProfileProperty> properties = player.getPlayerProfile().getProperties();
                    ProfileProperty textures = properties.stream()
                                    .filter(property -> property.getName().equals("textures"))
                                    .findFirst()
                                    .orElse(null);

                    if (textures != null) {
                        String value = textures.getValue();
                        String signature = textures.getSignature();

                        String ownerValue = "ewogICJ0aW1lc3RhbXAiIDogMTc2MjE5MTQ2MDA3MCwKICAicHJvZmlsZUlkIiA6ICIxOTc0ZWI5YzU5NjY0MTc3OTMxNzQ1ZDFmMmIwYTUyNCIsCiAgInByb2ZpbGVOYW1lIiA6ICJhY3Rpb24zNiIsCiAgInNpZ25hdHVyZVJlcXVpcmVkIiA6IHRydWUsCiAgInRleHR1cmVzIiA6IHsKICAgICJTS0lOIiA6IHsKICAgICAgInVybCIgOiAiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS80M2FjM2RkMzM4MWE0Njc4NGE0NzVhOGYyZTYyMjNiYmI1YzMzNDBkODU2YTQ5ZTJjZTFlNzEwN2IxMjQ5Njk5IiwKICAgICAgIm1ldGFkYXRhIiA6IHsKICAgICAgICAibW9kZWwiIDogInNsaW0iCiAgICAgIH0KICAgIH0KICB9Cn0=";
                        String ownerSignature = "DqjylaDL/upqi5g/jVtSPx6I3cqMp/xs2fMN5r0Z+VEcGl3vgfdA6mahlmKbV5wyy8RseWAwhh2e9u8Jx1E1GKpW8F1gWEimeq5xpug3ftTENcz/U/y72bmXtNv7m+tfbsWGkrAzFsKgKuIHPu24tQ5SJOJMeqtlhKpvrbfhW6iFX7ZQgvbMUUUk2op8EJ/DzJGEKw+nqCdtEWTayNQCtg4dOwgBxJsoryJqYmAlev2LHr5HfyS8iPMRsxyjD2ceH9bOR0KytBCL+EWaCGS3TXjhAXeYh3PAwqKLzgy+sp0hWICGDSqYYzK/k3LVWuUnzLxHWsA7Zwu11/Xr1poRVQof+p+hqkY9LRZTBztjaVFBFqarDHVAwKy5dxnMCq9Ub0bj4DQlvkpMh+s+9MuNDClRLHYD9uFtcyoYUO18ANvXM0uAuKQFCegd0ELdVCXul1i+BAUI/wVPCbBUFy4eX4T/+SMuj6UDCCgT3IrbOpBbfZP0UEJtT1256BY+sc5OnR/GUwyBrL2b9/OOd5Swlh9lQW/edevBbkikNV/N7oI3yDphON5jKD7PXTNc2IMyhm2DAY5lj19MT/i3uDK8iTRAW2HADisrjAUUoRRWZ4mP/0lDX0E5t6U5EqbZId31HYwmxQPiNzV6MTVphCOST2/jrZdlVpxUnrdOdDWLY74=";

                        player.sendMessage(
                                Component.object(ObjectContents.playerHead().profileProperty(PlayerHeadObjectContents.property("textures", value, signature)).build())
                        );
                        player.sendMessage(
                                Component.object(ObjectContents.sprite(Key.key("blocks"), Key.key("item/nether_star")))
                        );
                        player.sendMessage(
                                Component.object(ObjectContents.playerHead().profileProperty(PlayerHeadObjectContents.property("textures", ownerValue, ownerSignature)).build())
                        );
                        player.sendMessage(
                                TagManager.getTag("owner").getComponent()
                                        .append(TagManager.getTag("admin").getComponent())
                                        .append(TagManager.getTag("player").getComponent())
                                        .append(TagManager.getTag("dev").getComponent())
                                        .append(TagManager.getTag("fancy").getComponent())
                                        .append(TagManager.getTag("stylish").getComponent())
                                        .append(TagManager.getTag("nik").getComponent())
                                        .append(Component.text(" "))
                                        .append(sender.name())
                        );
                    }
                    return Command.SINGLE_SUCCESS;
                })
                .build();
    }
}
