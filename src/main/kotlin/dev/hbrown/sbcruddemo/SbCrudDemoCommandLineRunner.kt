package dev.hbrown.sbcruddemo

import dev.hbrown.sbcruddemo.domain.Book
import dev.hbrown.sbcruddemo.service.BookService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
@Component
class SbCrudDemoCommandLineRunner(
    private val bookService: BookService,
): CommandLineRunner {

    private val log: Logger = LoggerFactory.getLogger(javaClass)

    @Value("\${spring.application.name}")
    lateinit var appName: String

    @Value("\${info.app.version}")
    lateinit var appVersion: String

    override fun run(vararg args: String?) {
        log.info("Running $appName v$appVersion")

        println("\n\n\n=== save() ===")
        createBooksWithTitlePrefix("A").map { bookService.save(it) }

        println("\n\n\n=== saveAll() ===")
        bookService.saveAll(createBooksWithTitlePrefix("B"))

        println("\n\n\n=== persistAll() ===")
        bookService.persistAll(createBooksWithTitlePrefix("C"))

        println("\n\n\n=== saveAllBooks() ===")
        bookService.saveAllBooks(createBooksWithTitlePrefix("D"))

    }

    private fun createBooksWithTitlePrefix(prefix: String): List<Book> = List(20) { Book(title = "Book $prefix-$it") }
}
