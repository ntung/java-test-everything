package com.itersdesktop.javatechs.oop;

abstract public class AbstractEntryBuilder {
    public String id;

    public String name;

    public String description;

    @Override
    public String toString() {
        return "id: " + id + ", name: " + name + ", description: " + description;
    }

    AbstractEntryBuilder setCompulsoryFields() {
        this.id = "random";
        this.name = "My Name";
        return this;
    }

    public abstract void index();
}
