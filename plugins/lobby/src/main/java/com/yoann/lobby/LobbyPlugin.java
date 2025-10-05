package com.yoann.lobby;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class LobbyPlugin extends JavaPlugin {
    private Location spawn;

    @Override
    public void onEnable() {
        World w = Bukkit.getWorlds().get(0);
        double x = getConfig().getDouble("spawn.x", w.getSpawnLocation().getX());
        double y = getConfig().getDouble("spawn.y", w.getSpawnLocation().getY());
        double z = getConfig().getDouble("spawn.z", w.getSpawnLocation().getZ());
        float yaw = (float) getConfig().getDouble("spawn.yaw", w.getSpawnLocation().getYaw());
        float pitch = (float) getConfig().getDouble("spawn.pitch", w.getSpawnLocation().getPitch());
        spawn = new Location(w, x, y, z, yaw, pitch);
        saveDefaultConfig();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("lobby")) {
            if (!(sender instanceof Player)) return true;
            Player p = (Player) sender;
            if (spawn != null) p.teleport(spawn);
            return true;
        }
        if (command.getName().equalsIgnoreCase("setspawn")) {
            if (!(sender instanceof Player)) return true;
            if (!sender.hasPermission("lobby.setspawn")) return true;
            Player p = (Player) sender;
            spawn = p.getLocation();
            getConfig().set("spawn.x", spawn.getX());
            getConfig().set("spawn.y", spawn.getY());
            getConfig().set("spawn.z", spawn.getZ());
            getConfig().set("spawn.yaw", spawn.getYaw());
            getConfig().set("spawn.pitch", spawn.getPitch());
            saveConfig();
            return true;
        }
        return false;
    }
}
