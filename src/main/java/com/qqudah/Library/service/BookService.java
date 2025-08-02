package com.qqudah.Library.service;

import com.qqudah.Library.entity.Book;
import com.qqudah.Library.exceptions.BookNotFoundException;
import com.qqudah.Library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();

    }

    public Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found with id:" + id)
        );
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public void deleteById(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new BookNotFoundException("Cannot delete. Book not found with id: " + id);
        }
        bookRepository.deleteById(id);
    }

    public Book updateBook(Long id, Book updatedBook) {
        return bookRepository.findById(id)
                .map(book -> {
                    book.setTitle(updatedBook.getTitle());
                    book.setAuthor(updatedBook.getAuthor());
                    book.setDescription(updatedBook.getDescription());
                    book.setCopies(updatedBook.getCopies());
                    book.setCopiesAvailable(updatedBook.getCopiesAvailable());
                    book.setCategory(updatedBook.getCategory());
                    book.setImgURL(updatedBook.getImgURL());
                    return bookRepository.save(book);
                })
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
    }
}
