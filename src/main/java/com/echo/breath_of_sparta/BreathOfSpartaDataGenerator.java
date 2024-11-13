package com.echo.breath_of_sparta;

import com.echo.breath_of_sparta.datagen.tag.ModEntityTypeTagProvider;
import com.echo.breath_of_sparta.datagen.tag.ModItemTagProvider;
import com.echo.breath_of_sparta.datagen.ModLanguageProvider;
import com.echo.breath_of_sparta.datagen.ModModelProvider;
import com.echo.breath_of_sparta.datagen.ModRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class BreathOfSpartaDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {

		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModEntityTypeTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);


		pack.addProvider(ModLanguageProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);
	}
}
