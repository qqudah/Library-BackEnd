package com.qqudah.Library.repository;

import com.qqudah.Library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository  extends JpaRepository<Book, Long> {

}
