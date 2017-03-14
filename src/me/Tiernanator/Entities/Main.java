package me.Tiernanator.Entities;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.Tiernanator.SQL.SQLServer;
import me.Tiernanator.SQL.MySQL.MySQL;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {

//		initialiseSQL();

		registerCommands();
		registerEvents();

		try {
			CustomEntityType.registerEntities();
		} catch (IllegalArgumentException | IllegalAccessException
				| SecurityException | NoSuchFieldException e) {
			
			e.printStackTrace();
		}
//		ItemStack helmet = new ItemStack(Material.IRON_HELMET);
//		ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE);
//		ItemStack leggings = new ItemStack(Material.IRON_LEGGINGS);
//		ItemStack boots = new ItemStack(Material.IRON_BOOTS);
//		ItemStack sword = new ItemStack(Material.IRON_SWORD);
//		ItemStack stick = new ItemStack(Material.STICK);
//		
//		World world = getServer().getWorld("world");
//		Location location = new Location(world, -105.5, 66, 247.5);
//		
//		
//		CustomEntityZombie zombie = new CustomEntityZombie(((CraftWorld) world).getHandle());
//		CustomEntityIronGolemPet golemPet = new CustomEntityIronGolemPet(((CraftWorld) world).getHandle());
//		
//		CustomEntityType.spawnEntity((LivingEntity) zombie.getBukkitEntity(), location, sword, stick, helmet, chestplate, leggings, boots);
//		CustomEntityType.spawnEntity((LivingEntity) golemPet.getBukkitEntity(), location);
	}
	
	
	
	//Spawning custom entity stuff:
	//{
//  World targetWorld = getServer().getWorld("world");
//	CraftWorld handle = (CraftWorld) targetWorld;
//	CustomEntitySkeleton skeleton = new CustomEntitySkeleton(handle.getHandle());
//
//	org.bukkit.inventory.ItemStack boots = new org.bukkit.inventory.ItemStack(Material.DIAMOND_BOOTS);
//	org.bukkit.inventory.ItemStack helmet = new org.bukkit.inventory.ItemStack(Material.DIAMOND_HELMET);
//	org.bukkit.inventory.ItemStack chestplate = new org.bukkit.inventory.ItemStack(Material.DIAMOND_CHESTPLATE);
//	org.bukkit.inventory.ItemStack legs = new org.bukkit.inventory.ItemStack(Material.DIAMOND_LEGGINGS);
//	org.bukkit.inventory.ItemStack sword = new org.bukkit.inventory.ItemStack(Material.DIAMOND_SPADE);
//	
//	EntityEquipment eq = ((LivingEntity) skeleton.getBukkitEntity()).getEquipment();
//	eq.clear();
//	eq.setBoots(boots);
//	eq.setChestplate(chestplate);;
//	eq.setHelmet(helmet);
//	eq.setLeggings(legs);
//	eq.setItemInMainHand(null);
//	eq.setItemInMainHand(sword);
//	eq.setItemInOffHand(sword);
//	
//	skeleton.setLocation(-103.5, 66, 253.5, 0, 0);
//	
//	handle.getHandle().addEntity(skeleton, SpawnReason.NATURAL);
	//}
	
	
	@Override
	public void onDisable() {
//		try {
//			getSQL().closeConnection();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}

	public void registerCommands() {
		// getCommand("portal-create").setExecutor(new PortalCreate(this));
	}

	@SuppressWarnings("unused")
	public void registerEvents() {
		PluginManager pm = getServer().getPluginManager();

		// pm.registerEvents(new PortalDestroy(this), this);
	}

	private static MySQL mySQL;

	@SuppressWarnings("unused")
	private void initialiseSQL() {
		mySQL = new MySQL(SQLServer.HOSTNAME, SQLServer.PORT, null,
				SQLServer.USERNAME, SQLServer.PASSWORD);

		String query = "CREATE DATABASE IF NOT EXISTS ;";

		Connection connection = null;
		try {
			connection = mySQL.openConnection();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			statement.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		query = "USE ;";

		statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			statement.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		query = "CREATE TABLE IF NOT EXISTS Portals ( "
				+ "Name varchar(30) NOT NULL,"
				+ "DestinationName varchar(30) NOT NULL,"
				+ "FrameMaterial varchar(255)" + ");";

		statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			statement.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static MySQL getSQL() {
		return mySQL;
	}

	public static Connection getSQLConnection() {

		try {
			if (!getSQL().checkConnection()) {
				return getSQL().openConnection();
			} else {
				return getSQL().getConnection();
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
