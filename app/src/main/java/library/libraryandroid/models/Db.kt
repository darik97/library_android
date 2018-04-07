package library.libraryandroid.models

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

/**
 * Created by Daria on 07.04.2018.
 */
@Database(entities = arrayOf(BriefBook::class, Book::class), version = 1)
abstract class BooksDataBase : RoomDatabase() {

    abstract fun briefBookDao(): BriefBookDao
    abstract fun bookDao(): BookDao

    companion object {
        private var INSTANCE: BooksDataBase? = null

        fun getInstance(context: Context): BooksDataBase? {

            if (INSTANCE == null) {
                synchronized(BooksDataBase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                            BooksDataBase::class.java, "library.db")
                            .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}