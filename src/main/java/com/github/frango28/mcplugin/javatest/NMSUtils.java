package com.github.frango28.mcplugin.javatest;

import net.minecraft.server.v1_16_R3.EntityFallingBlock;
import net.minecraft.server.v1_16_R3.PacketPlayOutEntityMetadata;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_16_R3.block.data.CraftBlockData;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class NMSUtils {
    public void  setFakeBlock(Player p, Location loc, Block b){
        Bukkit.getScheduler().runTaskAsynchronously(Javatest.plugin,new Runnable(){

            @Override
            public void run() {
                EntityFallingBlock entity=new EntityFallingBlock(((CraftWorld)loc.getWorld()).getHandle(),loc.getBlockX()+0.5,loc.getBlockY(),loc.getBlockZ()+0.5,((CraftBlockData)b.getBlockData()).getState());
                entity.setNoGravity(true);
                ((CraftPlayer)p).getHandle().playerConnection.sendPacket(entity.P());
                ((CraftPlayer)p).getHandle().playerConnection.sendPacket(new PacketPlayOutEntityMetadata(entity.getId(), entity.getDataWatcher(), true));
            }
        });
    }


}
