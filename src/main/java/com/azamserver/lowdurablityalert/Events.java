
/*
File Name: Events.java
Part of package: com.azamserver.lowdurablityalert
Description: This file alerts the plugin on what to do when an item goes down in durability
*/

// Declare package name
package com.azamserver.lowdurablityalert;

// Import all needed libraries
import org.bukkit.ChatColor;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemDamageEvent;

// Start java class
public class Events implements Listener
{
    // Declare all needed variables
    private static final String messageStart = "" + ChatColor.BOLD + "" + ChatColor.GREEN + "[" + ChatColor.RED + "LowDurabilityAlert" + ChatColor.GREEN + "]: ";

    // Run code when an item goes down in durability
    @EventHandler
    public void onItemDamage(PlayerItemDamageEvent event)
    {
        // When an item goes down in durability, check the player who has the item's permissions
        if(event.getPlayer().isOp() || event.getPlayer().hasPermission("lowdurabilityalert.alert"))
        {

            // If the player has the correct permissions, check what the durability of the item is
            if(event.getItem().getType().getMaxDurability() - ((Damageable)event.getItem().getItemMeta()).getDamage() - 1 <= 10 && event.getItem().getType().getMaxDurability() - ((Damageable)event.getItem().getItemMeta()).getDamage() - 1 != 0)
            {
                // If the durability of the item is less than 10 and not 0, save the item's name the variable "itemName"
                String itemName;
                if(event.getItem().getItemMeta().hasDisplayName())
                    itemName = event.getItem().getItemMeta().getDisplayName();
                else
                    itemName = "Your " + event.getItem().getType().name().replace("_", " ").toLowerCase();

                // Alert the player who has the item that their item has a durability below 10
                event.getPlayer().sendMessage(messageStart + itemName + " has " + (event.getItem().getType().getMaxDurability() - ((Damageable)event.getItem().getItemMeta()).getDamage() - 1) + " durability left");
                event.getPlayer().sendMessage(messageStart + "Please repair " + itemName + " soon otherwise it will break!");

            }
        }
    }
}
