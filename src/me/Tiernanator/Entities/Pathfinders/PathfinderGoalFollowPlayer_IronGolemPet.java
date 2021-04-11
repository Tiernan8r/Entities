package me.Tiernanator.Entities.Pathfinders;

import net.minecraft.server.v1_10_R1.PathfinderGoal;

//
//import me.Tiernanator.Entities.Entities.CustomEntityIronGolemPet;
//import net.minecraft.server.v1_10_R1.BlockPosition;
//import net.minecraft.server.v1_10_R1.EntityHuman;
//import net.minecraft.server.v1_10_R1.EntityLiving;
//import net.minecraft.server.v1_10_R1.IBlockData;
//import net.minecraft.server.v1_10_R1.Material;
//import net.minecraft.server.v1_10_R1.MathHelper;
//import net.minecraft.server.v1_10_R1.Navigation;
//import net.minecraft.server.v1_10_R1.NavigationAbstract;
//import net.minecraft.server.v1_10_R1.PathType;
//import net.minecraft.server.v1_10_R1.PathfinderGoal;
//import net.minecraft.server.v1_10_R1.World;
//
public class PathfinderGoalFollowPlayer_IronGolemPet extends PathfinderGoal {
//
//	
//	private final CustomEntityIronGolemPet entity;
//	private EntityLiving entityLiving;
//	World world;
//	private final double f;
//	private final NavigationAbstract navigationAbstract;
//	private int h;
//	float b;
//	float c;
//	private float i;
//
//	public PathfinderGoalFollowPlayer_IronGolemPet(CustomEntityIronGolemPet paramEntity, double paramDouble, float paramFloat1, float paramFloat2) {
//		this.entity = paramEntity;
//		this.world = paramEntity.world;
//		this.f = paramDouble;
//		this.navigationAbstract = paramEntity.getNavigation();
//		this.c = paramFloat1;
//		this.b = paramFloat2;
//		a(3);
//
//		if (!(paramEntity.getNavigation() instanceof Navigation))
//			throw new IllegalArgumentException(
//					"Unsupported mob type for FollowPlayerGoal");
//	}
//
	public boolean a() {
//		EntityLiving localEntityLiving = this.entity.getOwner();
//		if (localEntityLiving == null) {
//			return false;
//		}
//		if ((localEntityLiving instanceof EntityHuman)
//				&& (((EntityHuman) localEntityLiving).isSpectator())) {
//			return false;
//		}
//		if (this.entity.h(localEntityLiving) < this.c * this.c) {
//			return false;
//		}
//		this.entityLiving = localEntityLiving;
		return true;
	}
//
//	public boolean b() {
//		return ((!(this.navigationAbstract.n())) && (this.entity.h(this.entityLiving) > this.b * this.b));
//	}
//
//	public void c() {
//		this.h = 0;
//		this.i = this.entity.a(PathType.WATER);
//		this.entity.a(PathType.WATER, 0.0F);
//	}
//
//	public void d() {
//		this.entityLiving = null;
//		this.navigationAbstract.o();
//		this.entity.a(PathType.WATER, this.i);
//	}
//
//	private boolean a(BlockPosition paramBlockPosition) {
//		IBlockData localIBlockData = this.world.getType(paramBlockPosition);
//		if (localIBlockData.getMaterial() == Material.AIR) {
//			return true;
//		}
//		return (!(localIBlockData.h()));
//	}
//
//	public void e() {
//		this.entity.getControllerLook().a(this.entityLiving, 10.0F, this.entity.N());
//
//		if (--this.h > 0) {
//			return;
//		}
//		this.h = 10;
//
//		if (this.navigationAbstract.a(this.entityLiving, this.f)) {
//			return;
//		}
//		if (this.entity.isLeashed()) {
//			return;
//		}
//		if (this.entity.h(this.entityLiving) < 144.0D) {
//			return;
//		}
//
//		int j = MathHelper.floor(this.entityLiving.locX) - 2;
//		int k = MathHelper.floor(this.entityLiving.locZ) - 2;
//		int l = MathHelper.floor(this.entityLiving.getBoundingBox().b);
//		for (int i1 = 0; i1 <= 4; ++i1)
//			for (int i2 = 0; i2 <= 4; ++i2) {
//				if ((i1 >= 1) && (i2 >= 1) && (i1 <= 3) && (i2 <= 3)) {
//					continue;
//				}
//				if ((this.world.getType(new BlockPosition(j + i1, l - 1, k + i2))
//						.q()) && (a(new BlockPosition(j + i1, l, k + i2)))
//						&& (a(new BlockPosition(j + i1, l + 1, k + i2)))) {
//					this.entity.setPositionRotation(j + i1 + 0.5F, l, k + i2 + 0.5F,
//							this.entity.yaw, this.entity.pitch);
//					this.navigationAbstract.o();
//					return;
//				}
//			}
//	}
}