package com.echo.breath_of_sparta;

import com.echo.breath_of_sparta.entity.ModEntityType;
import com.echo.breath_of_sparta.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BreathOfSparta implements ModInitializer {
	public static final String MOD_ID = "breath_of_sparta";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);



	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModEntityType.registerModEntityTypes();

	}
}