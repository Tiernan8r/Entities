package me.Tiernanator.Entities.Entities;

import net.minecraft.server.v1_10_R1.EntityLiving;
import net.minecraft.server.v1_10_R1.EntitySkeleton;
import net.minecraft.server.v1_10_R1.World;

public class CustomEntitySkeleton extends EntitySkeleton {

	public CustomEntitySkeleton(World world) {
		super(world);
	}

	//this is the on shoot arrow function
	@Override
	public void a(EntityLiving entityliving, float f) {
//		for (int i = 0; i < 2; i++) {
			super.a(entityliving, f);
//		}
	}
	
	//this is the initialise values function
	@Override
	protected void initAttributes() {
		super.initAttributes();
//		getAttributeInstance(GenericAttributes.MOVEMENT_SPEED).setValue(0.25D * 2);
	}

}