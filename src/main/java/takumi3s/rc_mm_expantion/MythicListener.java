package takumi3s.rc_mm_expantion;

import io.lumine.mythic.bukkit.events.MythicMechanicLoadEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class MythicListener implements Listener {


    @EventHandler
    public void onLoad(MythicMechanicLoadEvent e){
        String s = e.getMechanicName();
        if(s.equalsIgnoreCase("rcct")){
            e.register(new RcCt(e.getConfig()));
        }
    }

    @EventHandler
    public void onJoind(PlayerJoinEvent e){
        RcCt.rcct.remove(e.getPlayer().getUniqueId());
    }
}
