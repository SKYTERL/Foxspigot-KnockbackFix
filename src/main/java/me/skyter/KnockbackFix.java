package me.skyter;

import ga.strikepractice.events.DuelStartEvent;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import pt.foxspigot.jar.knockback.KnockbackModule;
import pt.foxspigot.jar.knockback.KnockbackProfile;

public final class KnockbackFix extends JavaPlugin implements Listener {

    @EventHandler
    public void onDuelStart(final DuelStartEvent e) {
        final KnockbackProfile knockback = KnockbackModule.INSTANCE.profiles.get(e.getKit().getName());
        final CraftPlayer craftPlayer1 = (CraftPlayer)e.getPlayer1();
        final CraftPlayer craftPlayer2 = (CraftPlayer)e.getPlayer2();
        craftPlayer1.getHandle().setKnockback(knockback);
        craftPlayer2.getHandle().setKnockback(knockback);
    }

    @Override
    public void onEnable() { Bukkit.getPluginManager().registerEvents(this, this); }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
