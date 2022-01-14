package com.tenstone.leet.patterns.base_behavioral.iterator;

import java.util.Iterator;

/**
 * Created by liuyuancheng on 2021/7/10  <br/>
 */
public class BookShelf implements Iterable<Book> {

    /**
     * 数组基于连续内存，查询时间复杂度O(1)
     */
    private final Book[] books;

    private int last;

    public BookShelf(int size) {
        this.last = 0;
        this.books = new Book[size];
    }

    public Book getBookAt(int index) {
        return books[index];
    }

    @Override
    public Iterator<Book> iterator() {
        return new BookShelfIterator(this);
    }

    public int getLength() {
        return books.length;
    }

    public BookShelf appendBook(Book book) {
        this.books[last] = book;
        last++;
        return this;
    }
}
