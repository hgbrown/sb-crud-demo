package dev.hbrown.sbcruddemo.service

import dev.hbrown.sbcruddemo.domain.Book
import dev.hbrown.sbcruddemo.repository.BookRepository
import org.springframework.stereotype.Service
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.transaction.Transactional

interface BookService : BookRepository {
    fun persistAll(books: List<Book>): List<Book>
    fun saveAllBooks(books: List<Book>): Iterable<Book>
}

@Service
class BookServiceImpl(
    private val bookRepository: BookRepository,
    @PersistenceContext private val em: EntityManager,
) : BookService, BookRepository by bookRepository {

    @Transactional(Transactional.TxType.REQUIRED)
    override fun saveAllBooks(books: List<Book>): Iterable<Book> {
        return bookRepository.saveAll(books)
    }


    @Transactional(Transactional.TxType.REQUIRED)
    override fun persistAll(books: List<Book>): List<Book> {
        return books.map {
            em.persist(it)
            it
        }
    }

}
