/*
 * Copyright (c) 2019. All rights reserved.
 */

package xzot1k.plugins.hd.core.packets.jsonmsgs.versions;

import net.minecraft.server.v1_8_R2.IChatBaseComponent;
import net.minecraft.server.v1_8_R2.NBTTagCompound;
import net.minecraft.server.v1_8_R2.PacketPlayOutChat;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_8_R2.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import xzot1k.plugins.hd.core.packets.jsonmsgs.JSONHandler;

public class JSONHandler1_8R2 implements JSONHandler {
    @Override
    public void sendJSONMessage(Player player, String JSONString) {
        IChatBaseComponent comp = IChatBaseComponent.ChatSerializer.a(JSONString);
        PacketPlayOutChat packetPlayOutChat = new PacketPlayOutChat(comp);
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packetPlayOutChat);
    }

    @Override
    public String getJSONItem(ItemStack itemStack) {
        net.minecraft.server.v1_8_R2.ItemStack nmsItemStack = CraftItemStack.asNMSCopy(itemStack);
        NBTTagCompound compound = new NBTTagCompound();
        compound = nmsItemStack.save(compound);
        return compound.toString();
    }
}
