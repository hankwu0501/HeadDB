package tsp.headdb.database;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import tsp.headdb.api.Head;
import tsp.headdb.api.HeadAPI;

import java.util.HashMap;
import java.util.Map;

public enum Category {

    ALPHABET("alphabet", ChatColor.YELLOW, 20),
    ANIMALS("animals", ChatColor.DARK_AQUA, 21),
    BLOCKS("blocks", ChatColor.DARK_GRAY, 22),
    DECORATION("decoration", ChatColor.LIGHT_PURPLE, 23),
    FOOD_DRINKS("food-drinks", ChatColor.GOLD, 24),
    HUMANS("humans", ChatColor.DARK_BLUE, 29),
    HUMANOID("humanoid", ChatColor.AQUA, 30),
    MISCELLANEOUS("miscellaneous", ChatColor.DARK_GREEN, 31),
    MONSTERS("monsters", ChatColor.RED, 32),
    PLANTS("plants", ChatColor.GREEN, 33);

    private final String name;
    private final ChatColor color;
    private final int location;
    private final Map<Category, Head> item = new HashMap<>();
    private static final Category[] values = values();

    Category(String name, ChatColor color, int location) {
        this.name = name;
        this.color = color;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public ChatColor getColor() {
        return color;
    }

    public int getLocation() {
        return location;
    }

    public ItemStack getItem() {
        if (item.containsKey(this)) {
            return item.get(this).getItemStack();
        }

        item.put(this, HeadAPI.getHeads(this).get(0));
        return getItem();
    }

    public static Category getByName(String name) {
        for (Category category : values) {
            if (category.getName().equalsIgnoreCase(name)) {
                return category;
            }
        }

        return null;
    }

    public static Category[] getValues() {
        return values;
    }

}
