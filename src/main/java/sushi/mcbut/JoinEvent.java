package sushi.mcbut;

import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;

public class JoinEvent implements Listener {

    private Mcbut main;

    public JoinEvent(Mcbut main) {
        this.main = main;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = (Player) e.getPlayer();
        p.getWorld().setTime(18000);
        p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 240, 10, true));
        p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 240, 10, true));
        Objects.requireNonNull(p.getAttribute(Attribute.GENERIC_ATTACK_SPEED)).setBaseValue(2.7);
        int timeInSeconds = 1;
        int timeInTicks = 20 * timeInSeconds;
        new BukkitRunnable() {
            @Override
            public void run() {
                p.sendMessage(ChatColor.GREEN + "Hello, and welcome to the worst time of your life!");
                p.sendMessage(ChatColor.GREEN + "Just try to beat the game!");
            }
        }.runTaskLater(main, timeInTicks);
    }
}
