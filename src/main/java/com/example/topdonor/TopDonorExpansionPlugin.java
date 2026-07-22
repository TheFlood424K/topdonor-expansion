package com.example.topdonor;

import org.bukkit.plugin.java.JavaPlugin;

public final class TopDonorExpansionPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        new TopDonorExpansion(this).register();
    }
}