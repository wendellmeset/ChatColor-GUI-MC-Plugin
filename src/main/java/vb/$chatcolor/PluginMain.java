package vb.$chatcolor;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.event.*;
import org.bukkit.plugin.java.*;

public class PluginMain extends JavaPlugin implements Listener {

	private static PluginMain instance;

	@Override
	public void onEnable() {
		instance = this;
		getServer().getPluginManager().registerEvents(this, this);
		getServer().getPluginManager().registerEvents(GUIManager.getInstance(), this);
		GUIManager.getInstance().register("chatcolorgui", guiPlayer -> {
			try {
				org.bukkit.inventory.Inventory guiInventory = Bukkit.createInventory(new GUIIdentifier("chatcolorgui"),
						((int) (27d)), "Chat Color GUI Yay");
				guiInventory.setItem(((int) (4d)),
						PluginMain.getNamedItem(((org.bukkit.Material) org.bukkit.Material.RED_WOOL),
								ChatColor.translateAlternateColorCodes('&',
										ChatColor.translateAlternateColorCodes('&', "&cRed"))));
				guiInventory.setItem(((int) (11d)),
						PluginMain.getNamedItem(((org.bukkit.Material) org.bukkit.Material.YELLOW_WOOL),
								ChatColor.translateAlternateColorCodes('&',
										ChatColor.translateAlternateColorCodes('&', "&eYellow"))));
				guiInventory.setItem(((int) (13d)),
						PluginMain.getNamedItem(((org.bukkit.Material) org.bukkit.Material.LIME_WOOL),
								ChatColor.translateAlternateColorCodes('&',
										ChatColor.translateAlternateColorCodes('&', "&aGreen"))));
				guiInventory.setItem(((int) (15d)),
						PluginMain.getNamedItem(((org.bukkit.Material) org.bukkit.Material.BLUE_WOOL),
								ChatColor.translateAlternateColorCodes('&',
										ChatColor.translateAlternateColorCodes('&', "&9Blue"))));
				guiInventory.setItem(((int) (22d)),
						PluginMain.getNamedItem(((org.bukkit.Material) org.bukkit.Material.PURPLE_WOOL),
								ChatColor.translateAlternateColorCodes('&',
										ChatColor.translateAlternateColorCodes('&', "&5Dark Purple"))));
				guiInventory.setItem(((int) (9d)),
						PluginMain.getNamedItem(((org.bukkit.Material) org.bukkit.Material.WHITE_WOOL), "White"));
				guiInventory.setItem(((int) (17d)),
						PluginMain.getNamedItem(((org.bukkit.Material) org.bukkit.Material.ORANGE_WOOL),
								ChatColor.translateAlternateColorCodes('&',
										ChatColor.translateAlternateColorCodes('&', "&6Orange"))));
				guiInventory.setItem(((int) (1d)),
						PluginMain.getNamedItem(((org.bukkit.Material) org.bukkit.Material.GREEN_WOOL),
								ChatColor.translateAlternateColorCodes('&',
										ChatColor.translateAlternateColorCodes('&', "&2Dark Green"))));
				guiInventory.setItem(((int) (7d)),
						PluginMain.getNamedItem(((org.bukkit.Material) org.bukkit.Material.PINK_WOOL),
								ChatColor.translateAlternateColorCodes('&',
										ChatColor.translateAlternateColorCodes('&', "&dPink"))));
				guiInventory.setItem(((int) (19d)),
						PluginMain.getNamedItem(((org.bukkit.Material) org.bukkit.Material.LIGHT_BLUE_WOOL),
								ChatColor.translateAlternateColorCodes('&',
										ChatColor.translateAlternateColorCodes('&', "&bAqua, Light Blue Color"))));
				guiInventory.setItem(((int) (25d)),
						PluginMain.getNamedItem(((org.bukkit.Material) org.bukkit.Material.CYAN_WOOL),
								ChatColor.translateAlternateColorCodes('&',
										ChatColor.translateAlternateColorCodes('&', "&3Cyan"))));
				return guiInventory;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}, false);
		getServer().getPluginManager().registerEvents(PlayerDataManager.getInstance(), this);
	}

	@Override
	public void onDisable() {
		PlayerDataManager.getInstance().saveAllData();
	}

	@Override
	public boolean onCommand(CommandSender commandSender, Command command, String label, String[] commandArgs) {
		if (command.getName().equalsIgnoreCase("chatcolor")) {
			try {
				GUIManager.getInstance().open("chatcolorgui", ((org.bukkit.entity.Player) (Object) commandSender));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		}
		return true;
	}

	public static void procedure(String procedure, List procedureArgs) throws Exception {
	}

	public static Object function(String function, List functionArgs) throws Exception {
		return null;
	}

	public static List createList(Object obj) {
		if (obj instanceof List) {
			return (List) obj;
		}
		List list = new ArrayList<>();
		if (obj.getClass().isArray()) {
			int length = java.lang.reflect.Array.getLength(obj);
			for (int i = 0; i < length; i++) {
				list.add(java.lang.reflect.Array.get(obj, i));
			}
		} else if (obj instanceof Collection<?>) {
			list.addAll((Collection<?>) obj);
		} else if (obj instanceof Iterator) {
			((Iterator<?>) obj).forEachRemaining(list::add);
		} else {
			list.add(obj);
		}
		return list;
	}

	public static void createResourceFile(String path) {
		Path file = getInstance().getDataFolder().toPath().resolve(path);
		if (Files.notExists(file)) {
			try (InputStream inputStream = PluginMain.class.getResourceAsStream("/" + path)) {
				Files.createDirectories(file.getParent());
				Files.copy(inputStream, file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static PluginMain getInstance() {
		return instance;
	}

	@EventHandler
	public void onGUIClick(GUIClickEvent event) throws Exception {
		if (event.getID().equalsIgnoreCase("chatcolorgui")) {
			if (PluginMain.checkEquals(((java.lang.Object) (Object) event.getSlot()),
					((java.lang.Object) (Object) (4d)))) {
				PlayerDataManager.getInstance().setData(
						((org.bukkit.OfflinePlayer) (Object) ((org.bukkit.entity.Player) event.getWhoClicked())),
						"chat_color_var", "red");
			} else if (PluginMain.checkEquals(((java.lang.Object) (Object) event.getSlot()),
					((java.lang.Object) (Object) (11d)))) {
				PlayerDataManager.getInstance().setData(
						((org.bukkit.OfflinePlayer) (Object) ((org.bukkit.entity.Player) event.getWhoClicked())),
						"chat_color_var", "yellow");
			} else if (PluginMain.checkEquals(((java.lang.Object) (Object) event.getSlot()),
					((java.lang.Object) (Object) (13d)))) {
				PlayerDataManager.getInstance().setData(
						((org.bukkit.OfflinePlayer) (Object) ((org.bukkit.entity.Player) event.getWhoClicked())),
						"chat_color_var", "green");
			} else if (PluginMain.checkEquals(((java.lang.Object) (Object) event.getSlot()),
					((java.lang.Object) (Object) (15d)))) {
				PlayerDataManager.getInstance().setData(
						((org.bukkit.OfflinePlayer) (Object) ((org.bukkit.entity.Player) event.getWhoClicked())),
						"chat_color_var", "blue");
			} else if (PluginMain.checkEquals(((java.lang.Object) (Object) event.getSlot()),
					((java.lang.Object) (Object) (22d)))) {
				PlayerDataManager.getInstance().setData(
						((org.bukkit.OfflinePlayer) (Object) ((org.bukkit.entity.Player) event.getWhoClicked())),
						"chat_color_var", "dark_purple");
			} else if (PluginMain.checkEquals(((java.lang.Object) (Object) event.getSlot()),
					((java.lang.Object) (Object) (9d)))) {
				PlayerDataManager.getInstance().setData(
						((org.bukkit.OfflinePlayer) (Object) ((org.bukkit.entity.Player) event.getWhoClicked())),
						"chat_color_var", "white");
			} else if (PluginMain.checkEquals(((java.lang.Object) (Object) event.getSlot()),
					((java.lang.Object) (Object) (17d)))) {
				PlayerDataManager.getInstance().setData(
						((org.bukkit.OfflinePlayer) (Object) ((org.bukkit.entity.Player) event.getWhoClicked())),
						"chat_color_var", "orange");
			} else if (PluginMain.checkEquals(((java.lang.Object) (Object) event.getSlot()),
					((java.lang.Object) (Object) (1d)))) {
				PlayerDataManager.getInstance().setData(
						((org.bukkit.OfflinePlayer) (Object) ((org.bukkit.entity.Player) event.getWhoClicked())),
						"chat_color_var", "dark_green");
			} else if (PluginMain.checkEquals(((java.lang.Object) (Object) event.getSlot()),
					((java.lang.Object) (Object) (7d)))) {
				PlayerDataManager.getInstance().setData(
						((org.bukkit.OfflinePlayer) (Object) ((org.bukkit.entity.Player) event.getWhoClicked())),
						"chat_color_var", "pink");
			} else if (PluginMain.checkEquals(((java.lang.Object) (Object) event.getSlot()),
					((java.lang.Object) (Object) (19d)))) {
				PlayerDataManager.getInstance().setData(
						((org.bukkit.OfflinePlayer) (Object) ((org.bukkit.entity.Player) event.getWhoClicked())),
						"chat_color_var", "light_blue_aqua_color");
			} else if (PluginMain.checkEquals(((java.lang.Object) (Object) event.getSlot()),
					((java.lang.Object) (Object) (25d)))) {
				PlayerDataManager.getInstance().setData(
						((org.bukkit.OfflinePlayer) (Object) ((org.bukkit.entity.Player) event.getWhoClicked())),
						"chat_color_var", "cyan");
			}
			return;
		}
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void event1(org.bukkit.event.player.AsyncPlayerChatEvent event) throws Exception {
		if (((boolean) ((org.bukkit.permissions.Permissible) (Object) ((org.bukkit.entity.Player) event.getPlayer()))
				.hasPermission("chatcolorplugin.chatcolorcmd"))) {
			if (!(PlayerDataManager.getInstance().getData(
					((org.bukkit.OfflinePlayer) (Object) ((org.bukkit.entity.Player) event.getPlayer())),
					"chat_color_var") == null)) {
				if (PluginMain.checkEquals(PlayerDataManager.getInstance().getData(
						((org.bukkit.OfflinePlayer) (Object) ((org.bukkit.entity.Player) event.getPlayer())),
						"chat_color_var"), "red")) {
					event.setMessage(ChatColor.translateAlternateColorCodes('&',
							(ChatColor.translateAlternateColorCodes('&', "&c")
									+ ((java.lang.String) event.getMessage()))));
				} else if (PluginMain.checkEquals(PlayerDataManager.getInstance().getData(
						((org.bukkit.OfflinePlayer) (Object) ((org.bukkit.entity.Player) event.getPlayer())),
						"chat_color_var"), "yellow")) {
					event.setMessage(ChatColor.translateAlternateColorCodes('&',
							(ChatColor.translateAlternateColorCodes('&', "&e")
									+ ((java.lang.String) event.getMessage()))));
				} else if (PluginMain.checkEquals(PlayerDataManager.getInstance().getData(
						((org.bukkit.OfflinePlayer) (Object) ((org.bukkit.entity.Player) event.getPlayer())),
						"chat_color_var"), "green")) {
					event.setMessage(ChatColor.translateAlternateColorCodes('&',
							(ChatColor.translateAlternateColorCodes('&', "&a")
									+ ((java.lang.String) event.getMessage()))));
				} else if (PluginMain.checkEquals(PlayerDataManager.getInstance().getData(
						((org.bukkit.OfflinePlayer) (Object) ((org.bukkit.entity.Player) event.getPlayer())),
						"chat_color_var"), "blue")) {
					event.setMessage(ChatColor.translateAlternateColorCodes('&',
							(ChatColor.translateAlternateColorCodes('&', "&9")
									+ ((java.lang.String) event.getMessage()))));
				} else if (PluginMain.checkEquals(PlayerDataManager.getInstance().getData(
						((org.bukkit.OfflinePlayer) (Object) ((org.bukkit.entity.Player) event.getPlayer())),
						"chat_color_var"), "dark_purple")) {
					event.setMessage(ChatColor.translateAlternateColorCodes('&',
							(ChatColor.translateAlternateColorCodes('&', "&5")
									+ ((java.lang.String) event.getMessage()))));
				} else if (PluginMain.checkEquals(PlayerDataManager.getInstance().getData(
						((org.bukkit.OfflinePlayer) (Object) ((org.bukkit.entity.Player) event.getPlayer())),
						"chat_color_var"), "orange")) {
					event.setMessage(ChatColor.translateAlternateColorCodes('&',
							(ChatColor.translateAlternateColorCodes('&', "&6")
									+ ((java.lang.String) event.getMessage()))));
				} else if (PluginMain.checkEquals(PlayerDataManager.getInstance().getData(
						((org.bukkit.OfflinePlayer) (Object) ((org.bukkit.entity.Player) event.getPlayer())),
						"chat_color_var"), "dark_green")) {
					event.setMessage(ChatColor.translateAlternateColorCodes('&',
							(ChatColor.translateAlternateColorCodes('&', "&2")
									+ ((java.lang.String) event.getMessage()))));
				} else if (PluginMain.checkEquals(PlayerDataManager.getInstance().getData(
						((org.bukkit.OfflinePlayer) (Object) ((org.bukkit.entity.Player) event.getPlayer())),
						"chat_color_var"), "pink")) {
					event.setMessage(ChatColor.translateAlternateColorCodes('&',
							(ChatColor.translateAlternateColorCodes('&', "&d")
									+ ((java.lang.String) event.getMessage()))));
				} else if (PluginMain.checkEquals(PlayerDataManager.getInstance().getData(
						((org.bukkit.OfflinePlayer) (Object) ((org.bukkit.entity.Player) event.getPlayer())),
						"chat_color_var"), "light_blue_aqua_color")) {
					event.setMessage(ChatColor.translateAlternateColorCodes('&',
							(ChatColor.translateAlternateColorCodes('&', "&b")
									+ ((java.lang.String) event.getMessage()))));
				} else if (PluginMain.checkEquals(PlayerDataManager.getInstance().getData(
						((org.bukkit.OfflinePlayer) (Object) ((org.bukkit.entity.Player) event.getPlayer())),
						"chat_color_var"), "cyan")) {
					event.setMessage(ChatColor.translateAlternateColorCodes('&',
							(ChatColor.translateAlternateColorCodes('&', "&3")
									+ ((java.lang.String) event.getMessage()))));
				}
			}
		}
	}

	public static org.bukkit.inventory.ItemStack getNamedItem(Material material, String name) {
		org.bukkit.inventory.ItemStack item = new org.bukkit.inventory.ItemStack(material);
		org.bukkit.inventory.meta.ItemMeta itemMeta = item.getItemMeta();
		if (itemMeta != null) {
			itemMeta.setDisplayName(name);
			item.setItemMeta(itemMeta);
		}
		return item;
	}

	public static boolean checkEquals(Object o1, Object o2) {
		if (o1 == null || o2 == null) {
			return false;
		}
		return o1 instanceof Number && o2 instanceof Number
				? ((Number) o1).doubleValue() == ((Number) o2).doubleValue()
				: o1.equals(o2);
	}
}
