package library.libraryandroid.utilities

import com.google.gson.Gson
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async
import library.libraryandroid.App
import library.libraryandroid.models.BriefBook
import okhttp3.OkHttpClient
import okhttp3.Request

fun loadBooks(url: String, id: Int = -1) = async(CommonPool) {
    val client = OkHttpClient()
    val request : Request
    if (id == -1) {
        request = Request.Builder()
                .url("$url?controller=object")
                .build()
    } else {
        request = Request.Builder()
                .url("$url?controller=book&id=$id")
                .build()
    }
    val response = client.newCall(request).execute()
    val responseText = response.body()!!.string()
    val books = Gson().fromJson(responseText, BriefBook.List::class.java)
    books
}

fun loadBooksFromCache(app: App): Deferred<List<BriefBook>> = async(CommonPool) {
    app.database.briefBookDao().getBriefAll()
}
