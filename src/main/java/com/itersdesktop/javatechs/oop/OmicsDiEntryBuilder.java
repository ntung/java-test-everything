package com.itersdesktop.javatechs.oop;

public class OmicsDiEntryBuilder extends AbstractEntryBuilder {

    public OmicsDiEntryBuilder setOptionalFields() {
        this.description = "We are in OmicsDiEntryBuilder.";
        return this;
    }

    @Override
    public void index() {
        setCompulsoryFields();
        setOptionalFields();
        System.out.println(this);
    }
}
