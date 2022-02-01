
/*
File Name: Main.java
Part of package: com.azamserver.lowdurablityalert
Description: This file is the root of the plugin and tells the plugins what to do on enabling and disabling
*/

// Declare package name
package com.azamserver.lowdurablityalert;

// Import all needed libraries
import org.bukkit.plugin.java.JavaPlugin;

// Start java class
public final class Main extends JavaPlugin
{
    // Code will run on plugin enable
    @Override
    public void onEnable() {
        // Allow plugin to run code when an item goes down in durability
        getServer().getPluginManager().registerEvents(new Events(), this);
    }

    // Code will run on plugin disable
    @Override
    public void onDisable() {
        // Since there isn't anything for the plugin to do on disable, this has been left empty
    }
}
