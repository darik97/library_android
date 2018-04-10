package library.libraryandroid.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import library.libraryandroid.models.Book
import library.libraryandroid.models.BriefBook

@Dao
interface BriefBookDao {

    @Query("select * from BriefBooks")
    fun getBriefAll(): List<BriefBook>

    @Insert(onConflict = REPLACE)
    fun insert(briefBook: BriefBook)

    @Insert
    fun insertAll(books:List<BriefBook>)

    @Query("delete from BriefBooks")
    fun deleteBriefAll()

    @Query("select * from BriefBooks where status = :status")
    fun getBooksWithStatus(status: Int): List<BriefBook>

    @Query("update BriefBooks set status = :status where id = :id")
    fun updateBookStatus(status: Int, id: Long?)
}

@Dao
interface BookDao {

    @Query("select * from Books where brief = :briefId")
    fun selectBookDescription(briefId: Long?) : Book

}