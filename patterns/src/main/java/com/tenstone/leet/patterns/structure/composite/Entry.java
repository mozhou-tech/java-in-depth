package com.tenstone.leet.patterns.structure.composite;

/**
 * Created by liuyuancheng on 2021/7/18  <br/>
 */
public abstract class Entry {
    public abstract String getName();

    public abstract int getSize();

    public Entry add(Entry entry) throws FileTreatmentException{
        throw new FileTreatmentException();
    }

    public void printList() {
        printList("");
    }

    protected abstract void printList(String prefix);

    @Override
    public String toString() {
        return getName() + "(" + getSize() + ")";
    }
}
