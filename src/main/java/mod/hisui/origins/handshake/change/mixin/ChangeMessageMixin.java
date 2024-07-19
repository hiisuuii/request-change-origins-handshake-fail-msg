package mod.hisui.origins.handshake.change.mixin;

import io.github.apace100.origins.networking.ModPacketsC2S;
import mod.hisui.origins.handshake.change.ChangeHandshakeMessage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(ModPacketsC2S.class)
public class ChangeMessageMixin {
	@ModifyArg(at = @At(value = "INVOKE", target = "Lnet/minecraft/text/Text;of(Ljava/lang/String;)Lnet/minecraft/text/Text;"), method = "handleHandshakeReply")
	private static String init(String string) {
		// This code is injected into the start of MinecraftServer.loadWorld()V
		return ChangeHandshakeMessage.config.message;
	}
}