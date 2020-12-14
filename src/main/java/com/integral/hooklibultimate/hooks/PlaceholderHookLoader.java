package com.integral.hooklibultimate.hooks;

import com.integral.hooklibultimate.minecraft.HookLoader;
import com.integral.hooklibultimate.minecraft.PrimaryClassTransformer;

public class PlaceholderHookLoader extends HookLoader {

	@Override
	public String[] getASMTransformerClass() {
		return new String[]{PrimaryClassTransformer.class.getName()};
	}

	@Override
	public void registerHooks() {
		registerHookContainer("com.integral.hooklibultimate.hooks.PlaceholderHook");
	}

}