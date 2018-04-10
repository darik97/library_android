package library.libraryandroid.utilities

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async
import library.libraryandroid.App
import library.libraryandroid.models.BriefBook

fun saveBook(app: App, books: List<BriefBook>): Deferred<Unit> = async(CommonPool) {
    app.database.briefBookDao().insertAll(books)
}