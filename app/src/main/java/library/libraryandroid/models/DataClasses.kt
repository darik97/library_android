package library.libraryandroid.models

data class BriefBook (
        var id: Int = -1,
        var title: String,
        var authors : ArrayList<Author> = ArrayList(),
        var status : Int,
        var image : ByteArray) {

    override fun equals(other: Any?): Boolean {
        if (other is BriefBook)
            return title == other.title && authors == other.authors
        return false
    }

    override fun hashCode(): Int {
        return title.hashCode() * authors.hashCode()
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

data class Book (
        var brief: BriefBook,
        var genres: Genre,
        var rating: Int = 0,
        var series: Int = -1,
        var description: String = "",
        var comment: String = "",
        var link: String = ""
)

data class Genre (
        val id: Int = -1,
        val name: String
)

data class Author (
        val id : Int = -1,
        val firstName : String = "",
        val lastName : String
)