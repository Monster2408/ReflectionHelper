package xyz.mlserver.reflectionhelper.resolver.minecraft;

import xyz.mlserver.reflectionhelper.minecraft.Minecraft;
import xyz.mlserver.reflectionhelper.resolver.ClassResolver;

/**
 * {@link ClassResolver} for <code>net.minecraft.server.*</code> classes
 */
public class NMSClassResolver extends ClassResolver {

	@Override
	public Class resolve(String... names) throws ClassNotFoundException {
		for (int i = 0; i < names.length; i++) {
			if (!names[i].startsWith("net.minecraft.server")) {
				names[i] = "net.minecraft.server." + Minecraft.getVersion() + names[i];
			}
		}
		return super.resolve(names);
	}
}
