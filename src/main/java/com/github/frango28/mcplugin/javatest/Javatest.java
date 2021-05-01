package com.github.frango28.mcplugin.javatest;

import org.bukkit.plugin.java.JavaPlugin;

public final class Javatest extends JavaPlugin {
    public static JavaPlugin plugin=null;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin=this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
