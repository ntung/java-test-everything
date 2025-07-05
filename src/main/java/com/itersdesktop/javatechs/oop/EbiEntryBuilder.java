package com.itersdesktop.javatechs.oop;

public class EbiEntryBuilder extends AbstractEntryBuilder {

    public EbiEntryBuilder setOptionalFields() {
        this.description = "We are in EbiEntryBuilder.";
        return this;
    }

    public void index() {
        setCompulsoryFields();
        setOptionalFields();
        System.out.println(this);
    }
}
