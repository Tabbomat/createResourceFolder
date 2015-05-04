package com.ctbotfreak.createResourceFolder;

import com.ctbotfreak.createResourceFolder.proxy.IProxy;
import com.ctbotfreak.createResourceFolder.reference.Reference;
import com.ctbotfreak.createResourceFolder.utility.LogHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import java.io.File;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class createResourceFolder {

    @Mod.Instance(Reference.MOD_ID)
    public static createResourceFolder instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.EventHandler
    public void Init(FMLInitializationEvent event) {
        String DIRECTORY = System.getProperty("user.dir");
        String RESOURCE_DIRECTORY = DIRECTORY + "\\resourcepacks";

        File directory = new File(RESOURCE_DIRECTORY);
        boolean success;
        if (!directory.exists()) {
            //Create Directory
            success = directory.mkdir();
            if (success) {
                LogHelper.info("Created directory 'resourcepacks' successfully");
            } else {
                LogHelper.warn("Error creating directory 'resourcepacks'");
            }
        } else {
            LogHelper.info("Directory 'resourcepacks' exists already");
        }
    }
}
