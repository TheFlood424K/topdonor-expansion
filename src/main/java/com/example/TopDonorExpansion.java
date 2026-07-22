package com.example.topdonor;

import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.java.JavaPlugin;

public final class TopDonorExpansion extends PlaceholderExpansion {

    private final JavaPlugin plugin;

    public TopDonorExpansion(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean canRegister() {
        return Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null;
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public String getIdentifier() {
        return "topdonor";
    }

    @Override
    public String getAuthor() {
        return String.join(", ", plugin.getDescription().getAuthors());
    }

    @Override
    public String getVersion() {
        return plugin.getDescription().getVersion();
    }

    @Override
    public String onRequest(OfflinePlayer player, String params) {
        if (params == null || !params.matches("\\d+")) return null;

        String raw = PlaceholderAPI.setPlaceholders(player,
                "%craftingstore_donator_" + params + "%");
        if (raw == null || raw.isBlank()) return "";

        int colon = raw.indexOf(':');
        return (colon >= 0 ? raw.substring(0, colon) : raw).trim();
    }
}