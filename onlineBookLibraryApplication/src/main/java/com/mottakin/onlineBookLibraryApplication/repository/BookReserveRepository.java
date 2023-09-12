package com.mottakin.onlineBookLibraryApplication.repository;

import com.mottakin.onlineBookLibraryApplication.entity.BookEntity;
import com.mottakin.onlineBookLibraryApplication.entity.BookReserveEntity;
import com.mottakin.onlineBookLibraryApplication.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookReserveRepository extends JpaRepository<BookReserveEntity, Long> {
    BookReserveEntity findByUserEntityAndBookEntityAndStatus(UserEntity userEntity, BookEntity bookEntity, String reserved);
}
