package library.libraryandroid.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import library.libraryandroid.models.Book
import library.libraryandroid.db.BookDao
import library.libraryandroid.models.BriefBook
import library.libraryandroid.db.BriefBookDao

@Database(entities = arrayOf(BriefBook::class, Book::class), version = 1)
abstract class BooksDataBase : RoomDatabase() {

    abstract fun briefBookDao(): BriefBookDao
    abstract fun bookDao(): BookDao

}