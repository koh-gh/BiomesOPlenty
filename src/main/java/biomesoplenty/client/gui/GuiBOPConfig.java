package biomesoplenty.client.gui;

import biomesoplenty.common.config.GameplayConfigurationHandler;
import biomesoplenty.common.config.MiscConfigurationHandler;
import biomesoplenty.core.BiomesOPlenty;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.config.DummyConfigElement;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;

import java.util.ArrayList;
import java.util.List;

public class GuiBOPConfig extends GuiConfig
{
    public GuiBOPConfig(GuiScreen parentScreen)
    {
        super(parentScreen, GuiBOPConfig.getConfigElements(), BiomesOPlenty.MOD_ID, false, false, "/biomesoplenty");
    }

    private static List<IConfigElement> getConfigElements()
    {
        List<IConfigElement> list = new ArrayList<IConfigElement>();

        List<IConfigElement> convenienceSettings = new ConfigElement(GameplayConfigurationHandler.config.getCategory(GameplayConfigurationHandler.convenienceSettings.toLowerCase())).getChildElements();
        List<IConfigElement> guiSettings = new ConfigElement(MiscConfigurationHandler.config.getCategory(MiscConfigurationHandler.guiSettings.toLowerCase())).getChildElements();
        List<IConfigElement> textureSettings = new ConfigElement(MiscConfigurationHandler.config.getCategory(MiscConfigurationHandler.textureSettings.toLowerCase())).getChildElements();

        list.add(new DummyConfigElement.DummyCategoryElement(StatCollector.translateToLocal("config.category.convenienceSettings.title"), "config.category.convenienceSettings", convenienceSettings));
        list.add(new DummyConfigElement.DummyCategoryElement(StatCollector.translateToLocal("config.category.guiSettings.title"), "config.category.guiSettings", guiSettings));
        list.add(new DummyConfigElement.DummyCategoryElement(StatCollector.translateToLocal("config.category.textureSettings.title"), "config.category.textureSettings", textureSettings));

        return list;
    }
}