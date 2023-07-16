package xyz.r0r5chach.csy2061_assignment_2_resit.db.entities;

public class Entity {
    protected int id;
    protected int itemLayoutId;

    public Entity(int id) {
        this.id = id;
    }

    public Entity() { }

    public int getId() {
        return id;
    }

    public int getItemLayoutId() {
        return itemLayoutId;
    }
}
