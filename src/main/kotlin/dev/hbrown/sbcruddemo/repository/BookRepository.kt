package dev.hbrown.sbcruddemo.repository

import dev.hbrown.sbcruddemo.domain.Book
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : CrudRepository<Book, Long>
