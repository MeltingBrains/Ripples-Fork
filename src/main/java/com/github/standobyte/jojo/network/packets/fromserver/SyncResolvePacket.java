package com.github.standobyte.jojo.network.packets.fromserver;

import java.util.function.Supplier;

import com.github.standobyte.jojo.client.ClientUtil;
import com.github.standobyte.jojo.power.stand.IStandPower;

import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

public class SyncResolvePacket {
    private final float resolve;
    private final int resolveLevel;
    private final int noDecayTicks;
    
    public SyncResolvePacket(float resolve, int resolveLevel, int noDecayTicks) {
        this.resolve = resolve;
        this.resolveLevel = resolveLevel;
        this.noDecayTicks = noDecayTicks;
    }
    
    public static void encode(SyncResolvePacket msg, PacketBuffer buf) {
        buf.writeFloat(msg.resolve);
        buf.writeVarInt(msg.resolveLevel);
        buf.writeVarInt(msg.noDecayTicks);
    }
    
    public static SyncResolvePacket decode(PacketBuffer buf) {
        return new SyncResolvePacket(buf.readFloat(), buf.readVarInt(), buf.readVarInt());
    }

    public static void handle(SyncResolvePacket msg, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            IStandPower.getStandPowerOptional(ClientUtil.getClientPlayer()).ifPresent(power -> {
                power.setResolve(msg.resolve, msg.noDecayTicks);
                power.setResolveLevel(msg.resolveLevel);
            });
        });
        ctx.get().setPacketHandled(true);
    }
}
