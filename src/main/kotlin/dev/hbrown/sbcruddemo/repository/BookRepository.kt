package dev.hbrown.sbcruddemo.repository

import dev.hbrown.sbcruddemo.domain.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : JpaRepository<Book, Long>
