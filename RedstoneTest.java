package me.Tiernanator.Portalz.Events;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockRedstoneEvent;

import me.Tiernanator.Portalz.Main;

public class RedstoneTest implements Listener {

	@SuppressWarnings("unused")
	private Main plugin;

	public RedstoneTest(Main main) {
		plugin = main;
	}
	
	@EventHandler
	public void onRedstonechange(BlockRedstoneEvent event) {
		
	    Block blockBottom = event.getBlock().getRelative(BlockFace.DOWN);
	    Material from = Material.GOLD_ORE;
	    Material to = Material.DIAMOND_ORE;
	    
	    if(event.getNewCurrent() == 15) {  // on
	    	
	    	temp(blockBottom, from, to);
	        
	    } else if(event.getNewCurrent() == 0) { // off
	    	
	    	temp(blockBottom, to, from);
	        
	    }
	}
	
	public static void temp(Block block, Material from, Material to) {
		Material blockMaterial = block.getType();

		if (blockMaterial == from) {  // on

			block.setType(to); // new
			changeBlocksRecursive(block, from, to);

		} else if (blockMaterial == to) { // off

			block.setType(from); // new
			changeBlocksRecursive(block, to, from);

		}
	}
	
	public static void changeBlocksRecursive(Block origin, Material from, Material to) {
		
		BlockFace[] blockFaces = new BlockFace[]{
				BlockFace.DOWN,
				BlockFace.EAST,
				BlockFace.EAST_NORTH_EAST,
				BlockFace.EAST_SOUTH_EAST,
				BlockFace.NORTH,
				BlockFace.NORTH_EAST,
				BlockFace.NORTH_NORTH_EAST,
				BlockFace.NORTH_NORTH_WEST,
				BlockFace.NORTH_WEST,
				BlockFace.SOUTH,
				BlockFace.SOUTH_EAST,
				BlockFace.SOUTH_SOUTH_EAST,
				BlockFace.SOUTH_SOUTH_WEST,
				BlockFace.SOUTH_WEST,
				BlockFace.UP,
				BlockFace.WEST,
				BlockFace.WEST_NORTH_WEST,
				BlockFace.WEST_SOUTH_WEST
		};
		
	    for (BlockFace face : blockFaces) {
	        Block block = origin.getRelative(face);
	        if (block.getType() == from) {
	            block.setType(to);
	            changeBlocksRecursive(block, from, to);
	        }
	    }
	}

}
