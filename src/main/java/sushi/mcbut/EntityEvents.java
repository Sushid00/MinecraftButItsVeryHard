package sushi.mcbut;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EnderDragonChangePhaseEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.concurrent.ThreadLocalRandom;

public class EntityEvents implements Listener {

    private Player player;

    @EventHandler
    public void onSpawn(EntitySpawnEvent e){
        if(e.getEntity() instanceof Enderman){
            Enderman enderman = (Enderman) e.getEntity();
        }
        if(e.getEntity() instanceof Zombie){
            Zombie zombie = (Zombie) e.getEntity();

            ItemStack sword = new ItemStack(Material.NETHERITE_SWORD);
            ItemMeta swordMeta = sword.getItemMeta();
            swordMeta.setDisplayName(ChatColor.GREEN + "Subscribe to Sushid00 plz");
            sword.addEnchantment(Enchantment.DAMAGE_ALL, 5);
            sword.setItemMeta(swordMeta);

            zombie.getEquipment().setItemInMainHand(sword);
            zombie.getEquipment().setHelmet(new ItemStack(Material.NETHERITE_HELMET));
            zombie.getEquipment().setChestplate(new ItemStack(Material.NETHERITE_CHESTPLATE));
            zombie.getEquipment().setLeggings(new ItemStack(Material.NETHERITE_LEGGINGS));
            zombie.getEquipment().setBoots(new ItemStack(Material.NETHERITE_BOOTS));
            zombie.setBaby(true);

        }
        if(e.getEntity() instanceof Skeleton){
            Skeleton skeleton = (Skeleton) e.getEntity();

            ItemStack sword = new ItemStack(Material.BOW);
            ItemMeta swordMeta = sword.getItemMeta();
            swordMeta.setDisplayName(ChatColor.GREEN + "@Sushid001 on twitter");
            sword.addEnchantment(Enchantment.ARROW_DAMAGE, 5);
            sword.setItemMeta(swordMeta);

            skeleton.getEquipment().setItemInMainHand(sword);
            skeleton.getEquipment().setHelmet(new ItemStack(Material.NETHERITE_HELMET));
            skeleton.getEquipment().setChestplate(new ItemStack(Material.NETHERITE_CHESTPLATE));
            skeleton.getEquipment().setLeggings(new ItemStack(Material.NETHERITE_LEGGINGS));
            skeleton.getEquipment().setBoots(new ItemStack(Material.NETHERITE_BOOTS));

        }
        if(e.getEntity() instanceof Spider){
            Skeleton skeleton = e.getLocation().getWorld().spawn(e.getLocation(), Skeleton.class);
            Spider spider = (Spider) e.getEntity();
            spider.addPassenger(skeleton);
            spider.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 2));
            spider.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 999999, 2));
        }
        if(e.getEntity() instanceof Creeper){
            Creeper creeper = (Creeper) e.getEntity();
            creeper.setExplosionRadius(10);
            creeper.setPowered(true);
            creeper.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 2));


        }
        if(e.getEntity() instanceof Villager){
            Villager villager = (Villager) e.getEntity();
            villager.setProfession(Villager.Profession.NITWIT);
        }
        if(e.getEntity() instanceof Piglin){
            Piglin piglin = (Piglin) e.getEntity();
            piglin.getEquipment().setHelmet(new ItemStack(Material.NETHERITE_HELMET));
            piglin.getEquipment().setChestplate(new ItemStack(Material.NETHERITE_CHESTPLATE));
            piglin.getEquipment().setLeggings(new ItemStack(Material.NETHERITE_LEGGINGS));
            piglin.getEquipment().setBoots(new ItemStack(Material.NETHERITE_BOOTS));
            piglin.getEquipment().setItemInMainHand(new ItemStack(Material.NETHERITE_AXE));
        }
        if(e.getEntity() instanceof PiglinBrute){
            PiglinBrute piglin = (PiglinBrute) e.getEntity();
            piglin.getEquipment().setHelmet(new ItemStack(Material.NETHERITE_HELMET));
            piglin.getEquipment().setChestplate(new ItemStack(Material.NETHERITE_CHESTPLATE));
            piglin.getEquipment().setLeggings(new ItemStack(Material.NETHERITE_LEGGINGS));
            piglin.getEquipment().setBoots(new ItemStack(Material.NETHERITE_BOOTS));
            piglin.getEquipment().setItemInMainHand(new ItemStack(Material.NETHERITE_AXE));
        }
        if(e.getEntity() instanceof Enderman){
            Enderman enderman = (Enderman) e.getEntity();

            for(Player i : Bukkit.getOnlinePlayers()){
                enderman.setTarget(i);
            }
        }
    }
    @EventHandler
    public void onDeath(PlayerDeathEvent e){
        Player p = (Player) e.getEntity();
        p.playSound(p.getLocation(), Sound.ENTITY_GUARDIAN_DEATH_LAND, 5, -1);
    }

    @EventHandler
    public void onEat(PlayerItemConsumeEvent e){
        Player p = (Player) e.getPlayer();
        p.setHealth(p.getHealth()-6);
    }
    @EventHandler
    public void onMove(PlayerMoveEvent e){
        Player p = (Player) e.getPlayer();
        int Random = ThreadLocalRandom.current().nextInt(1000);
        if(Random<1){
            e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENTITY_CREEPER_PRIMED, 10, 1);
        }
        int random = ThreadLocalRandom.current().nextInt(2000);
        if(random<1){
            e.getPlayer().getWorld().createExplosion(e.getPlayer().getLocation(), 20);
            for(Player all : Bukkit.getServer().getOnlinePlayers())
            {
                all.sendMessage(e.getPlayer() + "has decided to end their free trial of life!");
            }
            e.getPlayer().kickPlayer("Self Destructed!");
        }
        int random2 = ThreadLocalRandom.current().nextInt(500);
        if(random2<1){
            PufferFish pf = e.getPlayer().getLocation().getWorld().spawn(e.getPlayer().getLocation(), PufferFish.class);
            pf.setAware(true);
        }

    }
    @EventHandler
    public void onSleep(PlayerBedEnterEvent e){
        e.getBed().getWorld().createExplosion(e.getBed().getLocation(), 25);

    }

    @EventHandler
    public void craftingtableopen(InventoryOpenEvent e){
        if(e.getInventory().getType().equals(InventoryType.CRAFTING)){
            int Random = ThreadLocalRandom.current().nextInt(1000);
            if(Random<1){
                e.getPlayer().getWorld().createExplosion(e.getPlayer().getLocation(), 5);
            }
        }
    }
    @EventHandler
    public void onBlockBreak(BlockBreakEvent e){
        int Random = ThreadLocalRandom.current().nextInt(2000);
        if(Random<1){
            e.getPlayer().getWorld().createExplosion(e.getPlayer().getLocation(), 5);
        }
        int random = ThreadLocalRandom.current().nextInt(1000);
        if(random<1){
            e.getPlayer().getWorld().createExplosion(e.getPlayer().getLocation(), 5);
        }
    }
    @EventHandler
    public void onFill(PlayerBucketFillEvent e){
        int random = ThreadLocalRandom.current().nextInt(100);
        if(random<5){
            e.getPlayer().sendMessage("you spilled your bucket :(");
            e.setCancelled(true);
        }
    }

}
