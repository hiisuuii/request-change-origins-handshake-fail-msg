package mod.hisui.origins.handshake.change;

import mod.hisui.origins.handshake.change.config.Config;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class ChangeHandshakeMessage implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("origins-dc-message-changer");
	public static final File CONFIG_PATH = FabricLoader.getInstance().getConfigDir().resolve("origins_handshake.json").toFile();
	public static Config config = Config.loadConfigFile(CONFIG_PATH);
	@Override
	public void onInitialize() {
		ServerLifecycleEvents.START_DATA_PACK_RELOAD.register(((server, resourceManager) -> {
			config = Config.loadConfigFile(CONFIG_PATH);
			config.saveConfigFile(CONFIG_PATH);
		}));
	// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution
		LOGGER.info("Hello Fabric world!");
	}
}