package xyz.szymon3ek.armortrimclasses;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.ShulkerBox;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityToggleSwimEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.*;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ArmorMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.trim.ArmorTrim;
import org.bukkit.inventory.meta.trim.TrimMaterial;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.util.Vector;
import org.bukkit.entity.Entity;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static org.bukkit.inventory.meta.trim.TrimMaterial.*;

@MinecraftExperimental
public final class ArmorTrimClasses extends JavaPlugin implements Listener, CommandExecutor {

    @Override
    public void onEnable() {
        getLogger().info("Plugin zostal wlaczony!");
        getServer().getPluginManager().registerEvents(this, this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("klasy")) {
            Player player = (Player) sender;
            Inventory menu = Bukkit.createInventory(null, 18, "§cKlasy");

            // ==========

            ItemStack emerald = new ItemStack(Material.EMERALD);
            ItemMeta emeraldMeta = emerald.getItemMeta();
            emeraldMeta.setDisplayName("§a§lEMERALD");

            List<String> emeraldlore = new ArrayList<>(); emeraldlore.add("§8Przyobrazasz sie w slime!"); emeraldlore.add("§a+ §7Wysokie skakanie §aIII"); emeraldlore.add("§a+ §7Nie otrzymujesz obrazen z upadku");
            emeraldMeta.setLore(emeraldlore);
            emerald.setItemMeta(emeraldMeta);

            // ==========

            ItemStack zloto = new ItemStack(Material.GOLD_INGOT);
            ItemMeta zlotoMeta = emerald.getItemMeta();
            zlotoMeta.setDisplayName("§e§lZLOTO");

            List<String> zlotolore = new ArrayList<>(); zlotolore.add("§8Stajesz sie najlepszym gornikiem!"); zlotolore.add("§e+ §7Haste §eI"); zlotolore.add("§e+ §7Ponizej §e20 §7blokow widzisz w ciemnosci");
            zlotoMeta.setLore(zlotolore);
            zloto.setItemMeta(zlotoMeta);

            // ==========

            ItemStack quartz = new ItemStack(Material.QUARTZ);
            ItemMeta quartzMeta = quartz.getItemMeta();
            quartzMeta.setDisplayName("§f§lQUARTZ");

            List<String> quartzlore = new ArrayList<>(); quartzlore.add("§8Stajesz sie szybkim jak wiatr!"); quartzlore.add("§f+ §7Szybkosc §fII"); quartzlore.add("§f+ §7Kucasz z taka sama szybkoscia jak chodzisz");
            quartzMeta.setLore(quartzlore);
            quartz.setItemMeta(quartzMeta);

            // ==========

            ItemStack lapis = new ItemStack(Material.LAPIS_LAZULI);
            ItemMeta lapisMeta = lapis.getItemMeta();
            lapisMeta.setDisplayName("§9§lLAPIS");

            List<String> lapislore = new ArrayList<>(); lapislore.add("§8Stajesz sie twardy jak kamien!"); lapislore.add("§9+ §7Ochrona §9I"); lapislore.add("§9+ §7Jak kucniesz stajesz sie jak kamien!");
            lapisMeta.setLore(lapislore);
            lapis.setItemMeta(lapisMeta);

            // ==========

            ItemStack ametyst = new ItemStack(Material.AMETHYST_SHARD);
            ItemMeta ametystMeta = ametyst.getItemMeta();
            ametystMeta.setDisplayName("§5§lAMETYST");

            List<String> ametystlore = new ArrayList<>(); ametystlore.add("§8Niewiedzialem ze umiesz w magie!"); ametystlore.add("§5+ §7Wysokie skakanie §5I"); ametystlore.add("§5+ §7Pod shiftem zaczynasz latac i sie swiecic!");
            ametystMeta.setLore(ametystlore);
            ametyst.setItemMeta(ametystMeta);

            // ==========

            ItemStack redstone = new ItemStack(Material.REDSTONE);
            ItemMeta redstoneMeta = redstone.getItemMeta();
            redstoneMeta.setDisplayName("§c§lREDSTONE");

            List<String> redstonelore = new ArrayList<>(); redstonelore.add("§8Zycie jest dla ciebie bezcenne!"); redstonelore.add("§c+ §7Regeneracja §cI"); redstonelore.add("§c+ §7Zlote jablka daja ci §c+2 §7serca wiecej i szybkosc §cIII\n§7Zaklete zlote jablko daje ci §c+4 §7serca wiecej i szybkosc §cIII\n§7Zwykle jedzenie daje ci szybkosc §cI");
            redstoneMeta.setLore(redstonelore);
            redstone.setItemMeta(redstoneMeta);

            // ==========

            ItemStack iron = new ItemStack(Material.IRON_INGOT);
            ItemMeta ironMeta = iron.getItemMeta();
            ironMeta.setDisplayName("§f§lZELAZO");

            List<String> ironlore = new ArrayList<>(); ironlore.add("§8Zamieniasz sie w orla!"); ironlore.add("§f+ §7Szybkosc §fI"); ironlore.add("§f+ §7Pod shiftem zaczynasz spadac wolniej oraz zaczynasz sie swiecic");
            ironMeta.setLore(ironlore);
            iron.setItemMeta(ironMeta);

            // ==========

            ItemStack netherite = new ItemStack(Material.NETHERITE_INGOT);
            ItemMeta netheriteMeta = netherite.getItemMeta();
            netheriteMeta.setDisplayName("§4§lNETHERITE");

            List<String> netheritelore = new ArrayList<>(); netheritelore.add("§8Stajesz sie bogiem piekla!"); netheritelore.add("§4+ §7Sila §4I"); netheritelore.add("§4+ §7W netherze otrzymujesz regeneracje §4II §7sile §42 §7oraz odpornosc na ogien");
            netheriteMeta.setLore(netheritelore);
            netherite.setItemMeta(netheriteMeta);

            // ==========

            ItemStack copper = new ItemStack(Material.COPPER_INGOT);
            ItemMeta copperMeta = copper.getItemMeta();
            copperMeta.setDisplayName("§6§lMIEDZ");

            List<String> copperlore = new ArrayList<>(); copperlore.add("§8Stajesz sie odporny na ogien!"); copperlore.add("§6+ §7Odpornosc na ogien §6I"); copperlore.add("§6+ §7W ogniu otrzymujesz regeneracje §6I §7a w lawie regeneracje §6II");

            copperMeta.setLore(copperlore);
            copper.setItemMeta(copperMeta);

            // ==========

            ItemStack diament = new ItemStack(Material.DIAMOND);
            ItemMeta diamentMeta = diament.getItemMeta();
            diamentMeta.setDisplayName("§b§lDIAMENT");

            List<String> diamentlore = new ArrayList<>(); diamentlore.add("§8Stajesz sie krolem oceanu!"); diamentlore.add("§b+ §7Moc conduita §bI"); diamentlore.add("§b+ §7Gracja delfinow §bII"); diamentlore.add("§b+ §7Woda daje ci regeneracje §bI §7oraz sile §bII");

            diamentMeta.setLore(diamentlore);
            diament.setItemMeta(diamentMeta);


            menu.setItem(1, new ItemStack(emerald));
            menu.setItem(2, new ItemStack(zloto));
            menu.setItem(3, new ItemStack(quartz));
            menu.setItem(4, new ItemStack(lapis));
            menu.setItem(5, new ItemStack(ametyst));
            menu.setItem(6, new ItemStack(netherite));
            menu.setItem(12, new ItemStack(redstone));
            menu.setItem(13, new ItemStack(iron));
            menu.setItem(14, new ItemStack(diament));
            menu.setItem(7, new ItemStack(copper));



            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 1, 1);
            player.openInventory(menu);

            return true;
        }
    return false;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Inventory clickedInventory = event.getClickedInventory();
        if (clickedInventory != null && event.getView().getTitle().equals("§cKlasy")) {
            event.setCancelled(true);
        }
    }

    public boolean checkTrimArmor(Player player, TrimMaterial material) {

        if(player.getInventory().getBoots() == null || player.getInventory().getLeggings() == null || player.getInventory().getChestplate() == null || player.getInventory().getHelmet() == null) {
            return false;
        }

        ItemStack buty = player.getInventory().getBoots();
        ItemStack spodnie = player.getInventory().getLeggings();
        ItemStack klata = player.getInventory().getChestplate();
        ItemStack helm = player.getInventory().getHelmet();

        ArmorMeta metabuty = (ArmorMeta) buty.getItemMeta();
        ArmorMeta metaspodnie = (ArmorMeta) spodnie.getItemMeta();
        ArmorMeta metaklata = (ArmorMeta) klata.getItemMeta();
        ArmorMeta metahelm = (ArmorMeta) helm.getItemMeta();

        assert metabuty != null;
        assert metaspodnie != null;
        assert metaklata != null;
        assert metahelm != null;

        return Objects.requireNonNull(metabuty.getTrim()).getMaterial() == material && Objects.requireNonNull(metahelm.getTrim()).getMaterial() == material && Objects.requireNonNull(metaklata.getTrim()).getMaterial() == material && Objects.requireNonNull(metaspodnie.getTrim()).getMaterial() == material;
    }


    @EventHandler
    private void efekty(PlayerJoinEvent event) {

        new BukkitRunnable() {
            @Override
            public void run() {


                Player player = event.getPlayer();

                //emeraldowy secik (jump
                if (checkTrimArmor(player, EMERALD)) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 25, 2, false, false));
                }

                if(checkTrimArmor(player, AMETHYST)) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 25, 0, false, false));
                }

                if(checkTrimArmor(player, LAPIS)) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 25, 0, false, false));
                }

                //zloty secik (haste)
                if (checkTrimArmor(player, GOLD)) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 25, 0, false, false));
                }
                //kwarcowy set (speed)
                if (checkTrimArmor(player, QUARTZ)) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 25, 1, false, false));
                }


                if (checkTrimArmor(player, REDSTONE)) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 25, 0, false, false));
                }

                if (checkTrimArmor(player, DIAMOND)) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.CONDUIT_POWER, 25, 0, false, false));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.DOLPHINS_GRACE, 25, 1, false, false));
                }

                if (checkTrimArmor(player, COPPER)) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 25, 0, false, false));
                }

                if (checkTrimArmor(player, IRON)) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 25, 0, false, false));
                }
                if (checkTrimArmor(player, NETHERITE)) {
                        if (player.getWorld().getName().equals("world_nether")) {
                            player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 25, 1, false, false));
                            player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 25, 1, false, false));
                            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 25, 1, false, false));
                        } else {
                            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 25, 0, false, false));
                        }

                }


                if (player.isSneaking()) {
                    //lapisowy set (invisible
                    if (checkTrimArmor(player, LAPIS)) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 25, 1, false, false));
                        player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 25, 255, false, false));
                        player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 25, 1, false, false));

                        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 25, 255, false, false));
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 25, 255, false, false));
                        player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 25, 100, false, false));
                        player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 25, 255, false, false));
                    }
                    //ametystowy set (latanie)
                    if (checkTrimArmor(player, AMETHYST)) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 25, 1, false, false));
                        player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 25, 1, false, false));

                    }

                    if (checkTrimArmor(player, IRON)) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 25, 1, false, false));
                        player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 25, 1, false, false));

                    }
                }


            }

        }.runTaskTimer(this, 0L, 20L);
    }

    @EventHandler
    private void copperArmor(PlayerMoveEvent event) {

        Player cos = event.getPlayer();

        if (checkTrimArmor(cos, COPPER)) {
            if (cos.getLocation().getBlock().getType() == Material.LAVA) {
                cos.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 25, 1, false, true));
            } else if (cos.getLocation().getBlock().getType() == Material.FIRE) {
                cos.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 25, 0, false, true));
            }
        }
    }

    @EventHandler
    private void diamondArmor(PlayerMoveEvent event) {
        Player player = event.getPlayer();


        if (checkTrimArmor(player, DIAMOND)) {
            if (player.getLocation().getBlock().getType() == Material.WATER) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 25, 0, false, true));
                player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 25, 1, false, true));
            }
        }

    }

    @EventHandler
    private void quartzArmor(PlayerMoveEvent event) {
        Player player = (Player) event.getPlayer();

        if (checkTrimArmor(player, QUARTZ)) {
            if (player.isSneaking()) {
                player.setWalkSpeed(0.5f);
            }

            if (!player.isSneaking()) {
                player.setWalkSpeed(0.2f);
            }
        }
    }

    @EventHandler
    private void redstoneArmor(PlayerItemConsumeEvent event) {

        Player player = event.getPlayer();

        if(checkTrimArmor(player, REDSTONE)) {
             if(event.getItem().getType() == Material.GOLDEN_APPLE) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 2400, 1, false, false));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 2, false, false));
             } else if(event.getItem().getType() == Material.ENCHANTED_GOLDEN_APPLE) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 2400, 5, false, false));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 2, false, false));
             } else {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 1, false, false));

             }
        }

    }

    @EventHandler
    private void emeraldArmor(EntityDamageEvent event) {
        Entity entity = event.getEntity();

        if(entity instanceof Player) {
            Player player = (Player) entity;

            if (checkTrimArmor(player, EMERALD)) {
                if (event.getCause() == DamageCause.FALL) {
                    event.setCancelled(true);
                }
            }

        } else {
            return;
        }

    }
    @EventHandler
    private void goldArmor(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        if (checkTrimArmor(player, GOLD)) {
            if (player.getLocation().getBlockY() <= 20) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 400, 4, false, false));
            }
        }
    }



}





