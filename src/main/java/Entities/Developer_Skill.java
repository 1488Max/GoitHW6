package Entities;

import lombok.Data;

public @Data class Developer_Skill {
    protected long developer_id;
    protected long skill_id;

    public Developer_Skill(long developer_id, long skill_id) {
        this.developer_id = developer_id;
        this.skill_id = skill_id;
    }

}
