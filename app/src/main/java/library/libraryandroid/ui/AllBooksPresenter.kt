package library.libraryandroid.ui

import android.content.Context
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import library.libraryandroid.App
import library.libraryandroid.models.BriefBook
import library.libraryandroid.utilities.*

class AllBooksPresenter(var context: Context, var activity: App) {

    private var networkManager = NetworkManager(context)
    fun loadBooks() {

        var books = BriefBook.List()
        launch(UI) {
            if (networkManager.isConnectedToInternet == false) {
                val cachedBooks = loadBooksFromCache(activity).await()
                if (cachedBooks.isNotEmpty()) {
                    books.addAll(cachedBooks)
                }
            } else {
                val cloudBooksJob = loadBooks(Constants.URL)
                saveBook(activity, books)
                cloudBooksJob.start()
            }
        }
    }
}