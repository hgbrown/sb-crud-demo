package dev.hbrown.sbcruddemo.domain

import javax.persistence.*

@Entity
@Table(name = "book")
class Book(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_generator")
    @SequenceGenerator(name = "book_generator", sequenceName = "book_id_seq", allocationSize = 50)
    @Column(name = "id", nullable = false)
    var id: Long? = null,

    @Column(name = "title", length = 500)
    var title: String,

) {

    override fun toString(): String {
        return "Book(id=$id, title='$title')"
    }
}
