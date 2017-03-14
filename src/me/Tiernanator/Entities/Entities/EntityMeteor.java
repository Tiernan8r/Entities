package me.Tiernanator.Entities.Entities;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.bukkit.Bukkit;
import org.bukkit.entity.Fireball;

import net.minecraft.server.v1_10_R1.EntityFireball;
import net.minecraft.server.v1_10_R1.MovingObjectPosition;
import net.minecraft.server.v1_10_R1.World;

public class EntityMeteor extends EntityFireball {

	private float speedModifier = 1.10F; // How much to accelerate the meteor by
											// each update
	private float trailPower = 10F; // The power of the spawned trail explosions
	private float impactPower = 50F; // The power of the final explosion

	public EntityMeteor(World world) {
		super(world);
		Bukkit.getServer().broadcastMessage("Metoer Spawn");
	}

	@Override
	protected void a(MovingObjectPosition movingobjectposition) {
		
		Fireball fireball = (Fireball) this.getBukkitEntity();
		fireball.getWorld().createExplosion(fireball.getLocation(),
				impactPower);
		Method a;
		try {
			a = EntityFireball.class.getDeclaredMethod("a",
					new Class<?>[]{Class.class, String.class, int.class});
			a.setAccessible(true);
//			a.invoke(null, entity.getCustomClass(), entity.getName(),
//					entity.getID());
			a.invoke(null, movingobjectposition);
			
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
//		super.a(movingobjectposition); // Perform cleanup, event firing and death
	}

	@Override
	public void m() {
		// Perform logic on movement here
		Fireball fireball = (Fireball) this.getBukkitEntity();
		fireball.getWorld().createExplosion(fireball.getLocation(), trailPower);
		motX *= speedModifier;
		motY *= speedModifier;
		motZ *= speedModifier;
		super.m(); // Delegate to original fireball code; run physics &c
	}
	
}