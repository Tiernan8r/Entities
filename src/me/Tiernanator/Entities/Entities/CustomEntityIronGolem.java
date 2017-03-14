package me.Tiernanator.Entities.Entities;

import net.minecraft.server.v1_10_R1.DamageSource;
import net.minecraft.server.v1_10_R1.Entity;
import net.minecraft.server.v1_10_R1.EntityIronGolem;
import net.minecraft.server.v1_10_R1.World;

public class CustomEntityIronGolem extends EntityIronGolem {

	public CustomEntityIronGolem(World world) {
		super(world);
	}

	//this is the on attack function
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
	
	//this is the initialise values function
	@Override
	protected void initAttributes() {
		super.initAttributes();
//		getAttributeInstance(GenericAttributes.MOVEMENT_SPEED).setValue(0.25D * 2);
	}

}