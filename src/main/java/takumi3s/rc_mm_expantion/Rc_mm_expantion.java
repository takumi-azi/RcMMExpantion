package takumi3s.rc_mm_expantion;

import io.lumine.mythic.api.config.MythicLineConfig;
import io.lumine.mythic.bukkit.events.MythicConditionLoadEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerCommandEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public final class Rc_mm_expantion extends JavaPlugin implements Listener {

    private static Rc_mm_expantion instance;
    public static Rc_mm_expantion getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        // Plugin startup logic
        Map<String, Integer> rcct = new HashMap<>();
        // Plugin startup logic
        PluginManager pm = getServer().getPluginManager();
        //pm.registerEvents(new RcDamageViewer(),this);
        pm.registerEvents(new MythicListener(),this);
        Bukkit.getLogger().info("mm reloadしたよ！！！！！！！");
        ServerCommandEvent e = new ServerCommandEvent(Bukkit.getConsoleSender(),"mythicmobs reload");
        if (e.callEvent()) {
            Bukkit.dispatchCommand(e.getSender(), e.getCommand());
        }
    }

    @EventHandler
    public void onMythicConditionLoad(MythicConditionLoadEvent event)	{
        if(event.getConditionName().equalsIgnoreCase("rcct"))	{
            event.register(new Conditions(event.getConfig()));
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
