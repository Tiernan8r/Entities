package me.Tiernanator.Entities.Entities;

import net.minecraft.server.v1_10_R1.DamageSource;
import net.minecraft.server.v1_10_R1.Entity;
import net.minecraft.server.v1_10_R1.EntitySkeleton;
import net.minecraft.server.v1_10_R1.EntityZombie;
import net.minecraft.server.v1_10_R1.PathfinderGoalNearestAttackableTarget;
import net.minecraft.server.v1_10_R1.World;

public class CustomEntityZombie extends EntityZombie {

	public CustomEntityZombie(World world) {
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
	protected void r() {
		super.r();
		o();
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	@Override
	protected void o() {
		super.o();
		this.targetSelector.a(2, new PathfinderGoalNearestAttackableTarget(this,
				EntitySkeleton.class, true));
	}
}