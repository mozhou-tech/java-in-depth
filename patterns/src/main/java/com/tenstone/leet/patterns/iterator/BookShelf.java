package com.tenstone.leet.patterns.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by liuyuancheng on 2021/7/10  <br/>
 */
public class BookShelf implements Iterable<Book> {

    private final List<Book> books = new ArrayList<>();

    public Book getBookAt(Integer index) {
        return books.get(index);
    }

    @Override
    public Iterator<Book> iterator() {
        return new BookShelfIterator(this);
    }

    public int getLength() {
        return books.size();
    }

    public BookShelf appendBook(Book book) {
        this.books.add(book);
        return this;
    }
}
