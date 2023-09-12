package com.mottakin.onlineBookLibraryApplication.repository;

import com.mottakin.onlineBookLibraryApplication.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
    Optional<BookEntity> findByIdAndDeletedFalse(Long id);

    Optional<BookEntity> findByTitleAndAuthor(String title, String author);
}
