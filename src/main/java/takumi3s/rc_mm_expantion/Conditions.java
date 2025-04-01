package takumi3s.rc_mm_expantion;

import io.lumine.mythic.api.adapters.AbstractEntity;
import io.lumine.mythic.api.config.MythicLineConfig;
import io.lumine.mythic.api.skills.conditions.IEntityCondition;
import io.lumine.mythic.api.skills.conditions.ISkillCondition;

public class Conditions implements ISkillCondition, IEntityCondition{

    public Conditions(MythicLineConfig config) {
    }
    @Override
    public boolean check(AbstractEntity target) {
        return RcCt.rcct.containsKey(target.getUniqueId());
    }

}
