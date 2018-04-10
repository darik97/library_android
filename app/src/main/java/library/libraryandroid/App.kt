package library.libraryandroid

import android.app.Application
import android.arch.persistence.room.Room
import library.libraryandroid.db.BooksDataBase

class App: Application() {

    lateinit var database: BooksDataBase
    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, BooksDataBase::class.java, "books").build()
    }
}