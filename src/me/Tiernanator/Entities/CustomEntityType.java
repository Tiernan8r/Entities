package me.Tiernanator.Entities;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_10_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_10_R1.entity.CraftEntity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;

import me.Tiernanator.Entities.Entities.CustomEntityEndermite;
import net.minecraft.server.v1_10_R1.BiomeBase;
import net.minecraft.server.v1_10_R1.BiomeBase.BiomeMeta;
import net.minecraft.server.v1_10_R1.Entity;
import net.minecraft.server.v1_10_R1.EntityEndermite;
import net.minecraft.server.v1_10_R1.EntityInsentient;
import net.minecraft.server.v1_10_R1.EntityTypes;

//Based off of code by
//Jacek @ https://bukkit.org/threads/tutorial-how-to-customize-the-behaviour-of-a-mob-or-entity.54547/
public enum CustomEntityType {

	// If you use the id and name of a vanilla mob it will be replaced with the
	// custom one
//	SKELETON("Skeleton", 51, EntityType.SKELETON, EntitySkeleton.class, EntitySkeleton.class, true),
	ENDERMITE("Endermite", 67, EntityType.ENDERMITE, EntityEndermite.class, CustomEntityEndermite.class, true);
//	ZOMBIE("Zombie", 54, EntityType.ZOMBIE, EntityZombie.class, CustomEntityZombie.class, true),
//	IRON_GOLEM("VillagerGolem", 99, EntityType.IRON_GOLEM, EntityIronGolem.class, CustomEntityIronGolem.class, true),
//	IRON_GOLEM_PET("VillagerGolem", 99, EntityType.IRON_GOLEM, EntityIronGolem.class, CustomEntityIronGolemPet.class, false),
//	METEOR("Meteor", 300, EntityType.FIREBALL, EntityFireball.class, EntityMeteor.class, true);

	private String name;
	private int id;
	private EntityType entityType;
	private Class<? extends Entity> nmsClass;
	private Class<? extends Entity> customClass;
	private boolean overrideDefault;

	private CustomEntityType(String name, int id, EntityType entityType,
			Class<? extends Entity> nmsClass,
			Class<? extends Entity> customClass, boolean overrideDefault) {
		this.name = name;
		this.id = id;
		this.entityType = entityType;
		this.nmsClass = nmsClass;
		this.customClass = customClass;
		this.overrideDefault = overrideDefault;
	}

	public String getName() {
		return this.name;
	}

	public int getID() {
		return this.id;
	}

	public EntityType getEntityType() {
		return this.entityType;
	}

	public Class<? extends Entity> getNMSClass() {
		return this.nmsClass;
	}

	public Class<? extends Entity> getCustomClass() {
		return this.customClass;
	}
	
	public boolean overrideDefault() {
		return this.overrideDefault;
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	public static void registerEntities() throws IllegalArgumentException,
			IllegalAccessException, SecurityException, NoSuchFieldException {
		for (CustomEntityType entity : CustomEntityType.class
				.getEnumConstants()) {
			try {

				// the fields required are the Map<String, Class<? extends
				// Entity> && Map<Integer, Class<? extends Entity>>
				Class clazz = EntityTypes.class;
				Field field = clazz.getDeclaredField("c");
				field.setAccessible(true);
				Map<String, Class<? extends Entity>> stringEntityMap = (Map<String, Class<? extends Entity>>) field
						.get(null);
				if(stringEntityMap.containsKey(entity.getName())) {
					stringEntityMap.remove(entity.getName());
				}
				
				field = clazz.getDeclaredField("e");
				field.setAccessible(true);
				Map<Integer, Class<? extends Entity>> intEntityMap = (Map<Integer, Class<? extends Entity>>) field
						.get(null);
				intEntityMap.remove(entity.getID());
				if(intEntityMap.containsKey(entity.getID())) {
					Bukkit.getLogger().log(Level.INFO, "Replacing entity with id " + Integer.toString(entity.getID()) + " with " + entity.getName());
					intEntityMap.remove(entity.getID());
				}

				try {
					// the required method takes (Class<? extends Entity>
					// paramClass,
					// String paramString, int paramInt) as input
					Method a = EntityTypes.class.getDeclaredMethod("a",
							new Class<?>[]{Class.class, String.class,
									int.class});
					a.setAccessible(true);
					a.invoke(null, entity.getCustomClass(), entity.getName(),
							entity.getID());
				} catch (Exception e) {
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		for (BiomeBase biomeBase : BiomeBase.i) {
			if (biomeBase == null) {
				break;
			}
			// The fields required are the ones the are List<BiomeMeta>
			for (String field : new String[]{"u", "v", "w", "x"}) {
				try {
					Field list = BiomeBase.class.getDeclaredField(field);
					list.setAccessible(true);
					List<BiomeMeta> mobList = (List<BiomeMeta>) list
							.get(biomeBase);

					for (BiomeMeta meta : mobList) {
						for (CustomEntityType entity : CustomEntityType.class
								.getEnumConstants()) {
							
							// meta.XX where XX is Class<? extends
							// EntityInsentient>
							if (entity.getNMSClass().equals(meta.b) && entity.overrideDefault()) {
								meta.b = (Class<? extends EntityInsentient>) entity.getCustomClass();
							}
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public org.bukkit.entity.Entity spawn(Location location) {
		Entity entity = null;
		switch(this) {
			case ENDERMITE :
				entity = new CustomEntityEndermite(((CraftWorld) location.getWorld()).getHandle());
				break;
			default :
				break;
			
		}
		return spawnEntity((LivingEntity) entity.getBukkitEntity(), location);
	}
	
	public static org.bukkit.entity.Entity spawnEntity(LivingEntity entity, Location location,
			ItemStack mainHand, ItemStack offHand, ItemStack helmet,
			ItemStack chestplate, ItemStack leggings, ItemStack boots) {

		CraftWorld handle = (CraftWorld) location.getWorld();

		EntityEquipment entityEquipment = entity.getEquipment();
		entityEquipment.setBoots(boots);
		entityEquipment.setChestplate(chestplate);;
		entityEquipment.setHelmet(helmet);
		entityEquipment.setLeggings(leggings);
		entityEquipment.setItemInMainHand(mainHand);
		entityEquipment.setItemInOffHand(offHand);

		CraftEntity craftEntity = (CraftEntity) entity;

		craftEntity.getHandle().setLocation(location.getX(), location.getY(),
				location.getZ(), location.getYaw(), location.getPitch());

		handle.getHandle().addEntity(craftEntity.getHandle(),
				SpawnReason.CUSTOM);
		
		return craftEntity;
	}
	
	public static org.bukkit.entity.Entity spawnEntity(LivingEntity entity, Location location) {
		return spawnEntity(entity, location, null, null, null, null, null, null);
	}
}