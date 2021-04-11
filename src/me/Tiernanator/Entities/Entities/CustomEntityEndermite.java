package me.Tiernanator.Entities.Entities;

import net.minecraft.server.v1_10_R1.DamageSource;
import net.minecraft.server.v1_10_R1.Entity;
import net.minecraft.server.v1_10_R1.EntityEndermite;
import net.minecraft.server.v1_10_R1.World;

public class CustomEntityEndermite extends EntityEndermite {

//	private int a;
	
	public CustomEntityEndermite(World world) {
		super(world);
	}

	// This is the on attack method
	@Override
	public boolean B(Entity entity) {
		super.B(entity);
		return true;
	}

	// this is the on take damage method
	@Override
	public boolean damageEntity(DamageSource damagesource, float f) {
		super.damageEntity(damagesource, f);
		return true;
	}

	@Override
	public void n() {
//		((EntityMonster) this).n();
		
		if (this.world.isClientSide) {
			this.world.removeEntity(this);
		} else {
			super.n();
		}
		
	}
	
}