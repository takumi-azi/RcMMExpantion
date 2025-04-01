package takumi3s.rc_mm_expantion;

import io.lumine.mythic.api.adapters.AbstractEntity;
import io.lumine.mythic.api.config.MythicLineConfig;
import io.lumine.mythic.api.skills.ISkillMechanic;
import io.lumine.mythic.api.skills.ITargetedEntitySkill;
import io.lumine.mythic.api.skills.SkillMetadata;
import io.lumine.mythic.api.skills.SkillResult;
import io.lumine.mythic.bukkit.BukkitAdapter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class RcCt implements ISkillMechanic, ITargetedEntitySkill {

    public static final Map<UUID, Integer> rcct = new HashMap<UUID, Integer>();
    private int duration;

    public RcCt(MythicLineConfig config) {
        duration = config.getInteger(new String[]{"duration", "d"});
    }

    public SkillResult castAtEntity(SkillMetadata skillMetadata, AbstractEntity abstractEntity) {
        try {
            Entity entity = BukkitAdapter.adapt(abstractEntity);
            UUID uuid = entity.getUniqueId();

            rcct.put(uuid, rcct.getOrDefault(uuid, 0) + 1);

            Bukkit.getScheduler().runTaskLater(Rc_mm_expantion.getInstance(), () -> {
                rcct.put(uuid, rcct.get(uuid) - 1);
                if (rcct.get(uuid) <= 0) {
                    rcct.remove(uuid);
                }
            }, duration);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
}