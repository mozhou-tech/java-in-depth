package com.tenstone.leet.patterns.behavior.iterator;

import java.util.Iterator;

/**
 * Created by liuyuancheng on 2021/7/10  <br/>
 */
public class BookShelfIterator implements Iterator<Book> {

    private int index;

    private final BookShelf bookShelf;

    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        this.index = -1;
    }

    @Override
    public boolean hasNext() {
        return bookShelf.getLength() - 1 > index;
    }

    @Override
    public Book next() {
        index++;
        return bookShelf.getBookAt(index);
    }
}
