package com.tenstone.leet.patterns.behavioral.iterator;

/**
 * 迭代器模式，测试
 *
 * Created by liuyuancheng on 2021/7/10  <br/>
 */
public class Main {

    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(3);
        bookShelf.appendBook(new Book().setName("hello"))
                .appendBook(new Book().setName("world"))
                .appendBook(new Book().setName("!"));
        var iterator = bookShelf.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            System.out.println(book.getName());
        }
    }

}
