package library.libraryandroid.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import library.libraryandroid.R
import library.libraryandroid.models.Book
import library.libraryandroid.utilities.Constants

class BookInfoActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)
    }

    fun showBookInfo(book: Book) {
        val img = findViewById<ImageView>(R.id.img)
        val genre =  findViewById<TextView>(R.id.book_genre)
        val ser = findViewById<TextView>(R.id.book_series)
        val descr = findViewById<TextView>(R.id.book_description)

        genre.text = book.genre
        descr.text = book.description
        ser.text = book.series
        Glide.with(this).load(Constants.URL + intent.getStringExtra("image")).into(img)
    }

    fun getId(): Int {
        return intent.getIntExtra("id", 0)
    }
}