package library.libraryandroid.models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "BriefBooks")
data class BriefBook ( @PrimaryKey(autoGenerate = true) var id: Long?,
                       @ColumnInfo(name = "title") var title: String,
                       @ColumnInfo(name = "author") var author: String,
                       @ColumnInfo(name = "status") var status: Int,
                       @ColumnInfo(name = "image") var image : String) {

    constructor():this(null, "", "", 0, "")

    class List : ArrayList<BriefBook>()

    override fun equals(other: Any?): Boolean {
        if (other is BriefBook)
            return title == other.title && author == other.author
        return false
    }

    override fun hashCode(): Int {
        return title.hashCode() * author.hashCode()
    }

    fun getStateName() : String {
        when (status) {
            0-> return "Прочитано"
            1-> return "В планах"
            2-> return "В процессе"
            3-> return "Не интересно"
        }
        return ""
    }
}

@Entity(tableName = "Books",
        foreignKeys = arrayOf(ForeignKey(entity = BriefBook::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("brief"),
        onDelete = ForeignKey.CASCADE)))

data class Book (@PrimaryKey(autoGenerate = true) var id: Long?,
                 @ColumnInfo(name = "brief") var brief: Long?,
                 @ColumnInfo(name = "genre") var genre: String,
                 @ColumnInfo(name = "series") var series: String,
                 @ColumnInfo(name = "description") var description: String) {

    constructor():this(null, null, "", "", "")
}
