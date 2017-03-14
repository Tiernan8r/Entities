package me.Tiernanator.Entities.Entities;

import java.util.UUID;

import com.google.common.base.Optional;

import net.minecraft.server.v1_10_R1.DataWatcher;
import net.minecraft.server.v1_10_R1.DataWatcherObject;
import net.minecraft.server.v1_10_R1.DataWatcherRegistry;
import net.minecraft.server.v1_10_R1.EntityIronGolem;
import net.minecraft.server.v1_10_R1.World;

public class CustomEntityIronGolemPet extends EntityIronGolem {

	protected static final DataWatcherObject<Optional<UUID>> dataWatcher = DataWatcher
			.a(CustomEntityIronGolemPet.class, DataWatcherRegistry.m);
	
	public CustomEntityIronGolemPet(World world) {
		super(world);
	}

//	@Override
//	public boolean B(Entity entity) {
//		super.B(entity);
//		return true;
//		
//	}
//	
//	//this is the initialise values function
//	@Override
//	protected void initAttributes() {
//		super.initAttributes();
////		getAttributeInstance(GenericAttributes.MOVEMENT_SPEED).setValue(0.25D * 2);
//	}
//	
//	//Pathfinder handler
//	@Override
//	protected void r() {
//		super.r();
//		this.goalSelector.a(5, new PathfinderGoalFollowPlayer_IronGolemPet(this, 1.0D, 10.0F, 2.0F));
//	}
//	
//	@Override
//	protected void i() {
//		super.i();
//		this.datawatcher.register(dataWatcher, Optional.absent());
//	}
//	
//	@SuppressWarnings("rawtypes")
//	@Nullable
//	public UUID getOwnerUUID() {
//		return ((UUID) ((Optional) this.datawatcher.get(dataWatcher)).orNull());
//	}
//
//	public void setOwnerUUID(@Nullable UUID paramUUID) {
//		this.datawatcher.set(dataWatcher, Optional.fromNullable(paramUUID));
//	}
//
//	@Nullable
//	public EntityLiving getOwner() {
//		try {
//			UUID localUUID = getOwnerUUID();
//			if (localUUID == null) {
//				return null;
//			}
//			return this.world.b(localUUID);
//		} catch (IllegalArgumentException localIllegalArgumentException) {
//		}
//		return null;
//	}

}