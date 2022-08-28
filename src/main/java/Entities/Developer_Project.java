package Entities;

import lombok.Data;

public @Data class Developer_Project {

    protected long developer_id;
    protected long project_id;

    public Developer_Project(long developer_id, long project_id) {
        this.developer_id = developer_id;
        this.project_id = project_id;
    }


}
