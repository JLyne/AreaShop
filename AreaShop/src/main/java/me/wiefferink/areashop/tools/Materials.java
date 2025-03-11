package me.wiefferink.areashop.tools;

import com.destroystokyo.paper.MaterialSetTag;
import me.wiefferink.areashop.AreaShop;
import org.bukkit.Material;

import java.util.Arrays;
import java.util.HashSet;

public class Materials {

	private Materials() {

	}

	/**
	 * Get material based on a sign material name.
	 * @param name Name of the sign material
	 * @return null if not a sign, otherwise the material matching the name
	 */
	public static Material signNameToMaterial(String name) {
		Material result = Material.getMaterial(name);

		if (result == null) {
			AreaShop.debug("Materials.get() null result:", name);
		}

		if (!isSign(result)) {
			return null;
		}

		return result;
	}

	/**
	 * Check if a Material is a sign (of either the wall or floor type).
	 * @param material Material to check
	 * @return true if the given material is a sign
	 */
	public static boolean isSign(Material material) {
		return MaterialSetTag.SIGNS.isTagged(material);
	}
}
