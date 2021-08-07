package me.wiefferink.areashop.tools;

import me.wiefferink.areashop.AreaShop;
import org.bukkit.Material;

import java.util.Arrays;
import java.util.HashSet;

public class Materials {

	private Materials() {

	}

	private static final HashSet<String> WALL_SIGN_TYPES = new HashSet<>(Arrays.asList(
		"ACACIA_WALL_SIGN",
		"BIRCH_WALL_SIGN",
		"DARK_OAK_WALL_SIGN",
		"JUNGLE_WALL_SIGN",
		"OAK_WALL_SIGN",
		"SPRUCE_WALL_SIGN"
	));
	private static final HashSet<String> FLOOR_SIGN_TYPES = new HashSet<>(Arrays.asList(
		"ACACIA_SIGN",
		"BIRCH_SIGN",
		"DARK_OAK_SIGN",
		"JUNGLE_SIGN",
		"OAK_SIGN",
		"SPRUCE_SIGN"
	));

	/**
	 * Get material based on a sign material name.
	 * @param name Name of the sign material
	 * @return null if not a sign, otherwise the material matching the name
	 */
	public static Material signNameToMaterial(String name) {
		// Expected null case
		if (!isSign(name)) {
			return null;
		}

		Material result = Material.getMaterial(name);

		if (result == null) {
			AreaShop.debug("Materials.get() null result:", name);
		}

		return result;
	}

	/**
	 * Check if a Material is a sign (of either the wall or floor type).
	 * @param material Material to check
	 * @return true if the given material is a sign
	 */
	public static boolean isSign(Material material) {
		return isSign(material.name());
	}

	/**
	 * Check if a Material is a sign (of either the wall or floor type).
	 * @param name String to check
	 * @return true if the given material is a sign
	 */
	public static boolean isSign(String name) {
		return name != null && (FLOOR_SIGN_TYPES.contains(name) || WALL_SIGN_TYPES.contains(name));
	}

}
