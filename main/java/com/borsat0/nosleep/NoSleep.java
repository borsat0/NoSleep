package com.borsat0.nosleep;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.SleepingLocationCheckEvent;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = NoSleep.MOD_ID, bus = Bus.FORGE)
@Mod("nosleep")
public class NoSleep {
	public static final String MOD_ID = "nosleep";

	public NoSleep() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public static void onSleepCheck(SleepingLocationCheckEvent event) {
		if (event.getEntity() instanceof PlayerEntity) {
			event.setResult(Result.DENY);
		}
	}

	@SubscribeEvent
	public static void onClientMsg(ClientChatReceivedEvent event) {
		if (event.getMessage().toString().contains("block.minecraft.bed.no_sleep")) {
			event.setCanceled(true);
		}
	}
}