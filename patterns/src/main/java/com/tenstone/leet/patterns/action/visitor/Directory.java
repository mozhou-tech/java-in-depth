package com.tenstone.leet.patterns.action.visitor;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by liuyuancheng on 2022/1/4  <br/>
 *
 * @author liuyuancheng
 */
public class Directory extends Entry {
    private String name;
    private ArrayList dir = new ArrayList();

    public Directory(String name){
        this.name = name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getSize() {
        int size = 0;
        Iterator it = dir.iterator();
        while (it.hasNext()){
            Entry entry = (Entry) it.next();
            size+=entry.getSize();
        }
        return size;
    }

    @Override
    public Entry add(Entry entry){
        dir.add(entry);
        return this;
    }

    @Override
    public Iterator iterator(){
        return dir.iterator();
    }
}
