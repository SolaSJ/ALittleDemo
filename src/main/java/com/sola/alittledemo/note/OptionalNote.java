package com.sola.alittledemo.note;

import com.sola.alittledemo.entity.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Sola
 * @date 2018/10/11
 */
public class OptionalNote {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    public void note(Long bookId) {
        Book book1 = new Book(bookId, "defaultBookName");

        // Optional构造方式,
        //
        // Optional.of(obj), Optional.ofNullable(obj)和Optional.empty()
        Optional<Book> bookOpt1 = Optional.of(book1);
        Optional<Book> bookOpt2 = Optional.ofNullable(book1);
        Optional<Book> bookOpt3 = Optional.ofNullable(null);

        // Optional的应用
        //
        // Optional中可依赖的应该是除了 isPresent()和get()的其他方法:
        // public<U> Optional<U> map(Function<? super T, ? extends U> mapper)
        // public T orElse(T other)
        // public T orElseGet(Supplier<? extends T> other)
        // public void ifPresent(Consumer<? super T> consumer)
        // public Optional<T> filter(Predicate<? super T> predicate)
        // public<U> Optional<U> flatMap(Function<? super T, Optional<U>> mapper)
        // public <X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier) throws X

        // 如果不为null返回bookPo, 否则返回null, 而不是 return user.isPresent() ? user.get() : null;
        Book book2 = bookOpt3.orElse(null);
        Book book3 = bookOpt3.orElseGet(this::getBook);
        // 而不要 if (user.isPresent()) {}
        bookOpt1.ifPresent(System.out::println);

        // 关于map的使用
        String[] arr = {"第一章", "第二章"};
        book1.setChapters(Stream.of(arr).collect(Collectors.toList()));
        List<String> chapters = bookOpt1.map(Book::getChapters).orElse(new ArrayList<>());
        chapters.forEach(System.out::print);

        String bookName = null;
        if (book1 != null) {
            bookName = book1.getBookName();
            if (bookName != null) {
                bookName = bookName.toUpperCase();
            }
        }
        log.info("bookName: {}", bookName);

        // 结合lambda表达式的写法
        book1.setBookName(null);
        String bookName1 = bookOpt1.map(Book::getBookName).map(String::toUpperCase).orElse(null);
        log.info("bookName1: {}", bookName1);
    }

    private Book getBook() {
        return new Book();
    }

}
