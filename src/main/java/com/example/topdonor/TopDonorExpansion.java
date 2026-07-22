package com.example.topdonor;

import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;

public final class TopDonorExpansion extends PlaceholderExpansion {

    @Override
    public boolean canRegister() {
        return true;
    }

    @Override
    public boolean persist() {
        // Keep this expansion registered across /papi reload
        return true;
    }

    @Override
    public String getIdentifier() {
        // Use %topdonor_<params>% (e.g. %topdonor_1%)
        return "topdonor";
    }

    @Override
    public String getAuthor() {
        return "Floods"; // adjust as needed
    }

    @Override
    public String getVersion() {
        return "1.0.0";
    }

    @Override
    public String onRequest(OfflinePlayer player, String params) {
        // params is the suffix after "topdonor_"
        // %topdonor_1% => params = "1"
        if (params == null || !params.matches("\\d+")) {
            return null;
        }

        String raw = PlaceholderAPI.setPlaceholders(player,
                "%craftingstore_donator_" + params + "%");
        if (raw == null || raw.isBlank()) {
            return "";
        }

        int colon = raw.indexOf(':');
        return (colon >= 0 ? raw.substring(0, colon) : raw).trim();
    }
}
