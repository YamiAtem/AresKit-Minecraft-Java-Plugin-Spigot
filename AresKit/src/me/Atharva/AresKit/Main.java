package me.Atharva.AresKit;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Chest;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin implements Listener {
	
	@Override
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(this, this);
		Bukkit.addRecipe(AresKit());
	}

	@Override
	public void onDisable() {

	}
	
	public ShapedRecipe AresKit() {
		
		ItemStack item = new ItemStack(Material.ENCHANTED_BOOK);
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "ARES KIT");
		
		item.setItemMeta(meta);
		
		List<String> lore = new ArrayList<String>();
		
		lore.add("");
		lore.add(ChatColor.RED+ "" + ChatColor.ITALIC + "The Armor and Tools of the Legendary God Ares");
		
		meta.setLore(lore);
		
		NamespacedKey key = new NamespacedKey(this, "ares_kit");
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("   ", " BI", "   ");
		
		recipe.setIngredient('B', Material.NETHERITE_BLOCK);
		recipe.setIngredient('I', Material.NETHERITE_INGOT);
		
		return recipe;
	}
	
	@EventHandler
	public void onClicked(PlayerInteractEvent event) {
		if (event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.ENCHANTED_BOOK) ) {
			if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasDisplayName()) {
				Player player = (Player) event.getPlayer();
				
				if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
					this.dropChest(player, AresKit2());
					player.getInventory().setItemInMainHand(new ItemStack(Material.AIR));
				}
			}
		}
	}
	
	private void dropChest(Player player, ItemStack[] items) {
		Location chest = null;
		if (player.getFacing() == BlockFace.NORTH)
			chest = player.getLocation().add(0, 0, -1);
		
		if (player.getFacing() == BlockFace.SOUTH)
			chest = player.getLocation().add(0, 0, 1);
		
		if (player.getFacing() == BlockFace.EAST)
			chest = player.getLocation().add(1, 0, 0);
			
		if (player.getFacing() == BlockFace.WEST)
			chest = player.getLocation().add(-1, 0, 0);
		
		if (chest.getBlock().getType() != Material.AIR) {
			player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "CANNOT PLACE CHEST HERE");
			return;
		}
		
		Block block = chest.getBlock();
		block.setType(Material.CHEST);
		
		Chest c = (Chest) block.getState();
		c.getInventory().addItem(items);
	}
	
	private ItemStack[] AresKit2() {
		ItemStack item = new ItemStack(Material.NETHERITE_HELMET);
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "ARES HELMET");
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
		meta.addEnchant(Enchantment.PROTECTION_FIRE, 5, true);
		meta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 5, true);
		meta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 5, true);
		meta.addEnchant(Enchantment.DURABILITY, 5, true);
		meta.addEnchant(Enchantment.WATER_WORKER, 5, true);
		meta.addEnchant(Enchantment.OXYGEN, 5, true);
		
		item.setItemMeta(meta);
		
		ItemStack item2 = new ItemStack(Material.NETHERITE_CHESTPLATE);
		ItemMeta meta2 = item.getItemMeta();
		
		meta2.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "ARES CHESTPLATE");
		meta2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
		meta2.addEnchant(Enchantment.PROTECTION_FIRE, 5, true);
		meta2.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 5, true);
		meta2.addEnchant(Enchantment.PROTECTION_PROJECTILE, 5, true);
		meta2.addEnchant(Enchantment.THORNS, 5, true);
		meta2.addEnchant(Enchantment.DURABILITY, 5, true);
		
		item2.setItemMeta(meta2);
		
		ItemStack item3 = new ItemStack(Material.NETHERITE_LEGGINGS);
		ItemMeta meta3 = item.getItemMeta();
		
		meta3.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "ARES LEGGINGS");
		meta3.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
		meta3.addEnchant(Enchantment.PROTECTION_FIRE, 5, true);
		meta3.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 5, true);
		meta3.addEnchant(Enchantment.PROTECTION_PROJECTILE, 5, true);
		meta3.addEnchant(Enchantment.THORNS, 5, true);
		meta3.addEnchant(Enchantment.DURABILITY, 5, true);

		item3.setItemMeta(meta3);
		
		ItemStack item4 = new ItemStack(Material.NETHERITE_BOOTS);
		ItemMeta meta4 = item.getItemMeta();
		
		meta4.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "ARES BOOTS");
		meta4.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
		meta4.addEnchant(Enchantment.PROTECTION_FIRE, 5, true);
		meta4.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 5, true);
		meta4.addEnchant(Enchantment.PROTECTION_PROJECTILE, 5, true);
		meta4.addEnchant(Enchantment.DURABILITY, 5, true);
		meta4.addEnchant(Enchantment.DEPTH_STRIDER, 5, true);
		meta4.addEnchant(Enchantment.PROTECTION_FALL, 5, true);
		
		item4.setItemMeta(meta4);
		
		ItemStack item5 = new ItemStack(Material.NETHERITE_SWORD);
		ItemMeta meta5 = item5.getItemMeta();
		
		meta5.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "ARES SWORD");
		meta5.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
		meta5.addEnchant(Enchantment.DAMAGE_ARTHROPODS, 5, true);
		meta5.addEnchant(Enchantment.DAMAGE_UNDEAD, 5, true);
		meta5.addEnchant(Enchantment.DURABILITY, 5, true);
		meta5.addEnchant(Enchantment.FIRE_ASPECT, 5, true);
		meta5.addEnchant(Enchantment.LOOT_BONUS_MOBS, 5, true);
		
		item5.setItemMeta(meta5);
		
		ItemStack item6 = new ItemStack(Material.BOW);
		ItemMeta meta6 = item6.getItemMeta();
		
		meta6.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "ARES BOW");
		meta6.addEnchant(Enchantment.ARROW_INFINITE, 5, true);
		meta6.addEnchant(Enchantment.ARROW_FIRE, 5, true);
		meta6.addEnchant(Enchantment.ARROW_KNOCKBACK, 5, true);
		meta6.addEnchant(Enchantment.DURABILITY, 5, true);
		
		item6.setItemMeta(meta6);
		
		ItemStack item7 = new ItemStack(Material.SHIELD);
		ItemMeta meta7 = item6.getItemMeta();
		
		meta7.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "ARES SHIELD");
		meta7.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
		meta7.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 5, true);
		meta7.addEnchant(Enchantment.PROTECTION_FIRE, 5, true);
		meta7.addEnchant(Enchantment.PROTECTION_PROJECTILE, 5, true);
		meta7.addEnchant(Enchantment.DURABILITY, 5, true);
		
		item7.setItemMeta(meta7);
	
		ItemStack[] items = {item, item2, item3, item4, item5, item6, item7};
		return items;
	}
}
