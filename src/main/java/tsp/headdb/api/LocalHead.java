package tsp.headdb.api;

import org.apache.commons.lang.Validate;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import tsp.headdb.database.Category;
import tsp.headdb.util.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class LocalHead extends Head {

    private UUID uuid;
    private String name;

    public LocalHead(UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public ItemStack getItemStack() {
        Validate.notNull(uuid, "uuid must not be null!");

        ItemStack item = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) item.getItemMeta();
        meta.setOwningPlayer(Bukkit.getOfflinePlayer(uuid));
        meta.setDisplayName(Utils.colorize("&e" + name));
        List<String> lore = new ArrayList<>();
        lore.add(Utils.colorize("&7UUID: " + uuid.toString()));
        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }

    @Override
    public UUID getUniqueId() {
        return uuid;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getValue() {
        return null;
    }

    @Override
    public Category getCategory() {
        return null;
    }

    @Override
    public int getId() {
        return -1;
    }

    @Override
    public List<String> getTags() {
        return null;
    }

    @Override
    public LocalHead withUniqueId(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    @Override
    public LocalHead withName(String name) {
        this.name = name;
        return this;
    }

}
