package com.integral.hooklibultimate;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.integral.hooklibultimate.proxy.CommonProxy;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = HookLibUltimate.MODID, version = HookLibUltimate.VERSION, name = HookLibUltimate.NAME)
public class HookLibUltimate {
	public static final String MODID = "hooklibultimate";
	public static final String NAME = "HookLib Ultimate";
	public static final String VERSION = "@VERSION@";

	public static SimpleNetworkWrapper packetInstance;

	@SidedProxy(clientSide = "com.integral.hooklibultimate.proxy.ClientProxy", serverSide = "com.integral.hooklibultimate.proxy.CommonProxy")
	public static CommonProxy proxy;

	@Instance(MODID)
	public static HookLibUltimate instance;
	public static final Logger log = LogManager.getLogger("HookLibUltimate");

	@EventHandler
	public void load(FMLInitializationEvent event) {
		proxy.registerRenderers();
	}

	@EventHandler
	public void serverLoad(FMLServerStartingEvent event) {
		// NO-OP
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		packetInstance = NetworkRegistry.INSTANCE.newSimpleChannel("HookLibUltimateChannel");

		NetworkRegistry.INSTANCE.registerGuiHandler(this, proxy);
	}
}
