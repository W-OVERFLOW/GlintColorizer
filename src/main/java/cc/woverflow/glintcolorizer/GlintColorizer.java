//#if MODERN==0 || FABRIC==1
package cc.woverflow.glintcolorizer;

import cc.woverflow.onecore.utils.Updater;
import cc.woverflow.glintcolorizer.config.GlintConfig;
import java.io.File;

//#if MODERN==0
import net.minecraftforge.fml.common.Mod;
import cc.woverflow.glintcolorizer.command.GlintCommand;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
//#else
//$$ import cc.woverflow.onecore.utils.Utils;
//#endif

//#if MODERN==0
@Mod(modid = GlintColorizer.ID, name = GlintColorizer.NAME, version = GlintColorizer.VER)
//#endif
public class GlintColorizer {
    public static final String NAME = "@NAME@", VER = "@VER@", ID = "@ID@";
    public static File modDir = new File(new File("./W-OVERFLOW"), NAME);
    public static GlintConfig config;

    //#if MODERN==0
    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent event)
    //#else
    //$$ public void onPreInit()
    //#endif
    {
        if (!modDir.exists()) modDir.mkdirs();
        //#if FABRIC==1
        //$$ File file = Utils.getFileOfMod(ID);
        //$$ if (file == null) return;
        //#endif
        Updater.INSTANCE.addToUpdater(
                //#if FABRIC==0
                event.getSourceFile()
                //#else
                //$$ file
                //#endif
                , NAME, ID, VER, "W-OVERFLOW/" + ID);
    }

    //#if MODERN==0
    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event)
    //#else
    //$$ public void onInit()
    //#endif
    {
        //#if MODERN==1
        //$$ onPreInit();
        //#endif
        //#if MODERN==0
        new GlintCommand().register();
        //#endif
        config = new GlintConfig();
        config.preload();
    }
}
//#endif