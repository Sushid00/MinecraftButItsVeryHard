package sushi.mcbut;

import org.bukkit.Sound;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;

public class SoundEvents implements Listener {

    @EventHandler
    public void onsoundmake(EntityDeathEvent e){
        if(e.getEntity() instanceof Cow){
            e.getEntity().getWorld().playSound(e.getEntity().getLocation(), Sound.ENTITY_PIG_DEATH, 5, 0);
        }else if(e.getEntity() instanceof Pig){
            e.getEntity().getWorld().playSound(e.getEntity().getLocation(), Sound.ENTITY_BLAZE_DEATH, 5, 0);
        }else if(e.getEntity() instanceof Sheep){
            e.getEntity().getWorld().playSound(e.getEntity().getLocation(), Sound.ENTITY_CHICKEN_DEATH, 5, 0);
        }else if(e.getEntity() instanceof Chicken){
            e.getEntity().getWorld().playSound(e.getEntity().getLocation(), Sound.ENTITY_SHEEP_DEATH, 5, 0);
        }


    }
}
