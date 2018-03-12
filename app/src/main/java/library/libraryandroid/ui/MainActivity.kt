package library.libraryandroid.ui

import android.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.LinearLayoutManager
import library.libraryandroid.R
import android.support.v7.widget.Toolbar
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.book_list_fragment.*
import library.libraryandroid.adapters.BookListAdapter
import library.libraryandroid.fragments.BookListFragment
import library.libraryandroid.models.Author
import library.libraryandroid.models.BriefBook


class MainActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar
//    private lateinit var floating: FloatingActionButton
    private lateinit var linearLayoutManager: LinearLayoutManager
    private var booklistFragment: BookListFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById<Toolbar>(R.id.toolbar_booklist) as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setTitle(R.string.all_books)

        recycle_book_list.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        val books = ArrayList<BriefBook>()
        val authors = ArrayList<Author>()
        authors.add(Author(-1, "Галина", "Гончарова"))
        authors.add(Author(-1, "Галина1", "Гончарова1"))
        authors.add(Author(-1, "Галина2", "Гончарова2"))
        books.add(BriefBook(-1, "Азъ есмь Софья. Сестра", authors,0, ByteArray(1)))
        books.add(BriefBook(-1, "Азъ есмь Софья. Царевна", authors,1, ByteArray(1)))
        books.add(BriefBook(-1, "Азъ есмь Софья. Государыня", authors,2, ByteArray(1)))
        books.add(BriefBook(-1, "Азъ есмь Софья. Тень за троном", authors,3, ByteArray(1)))

        val adapter = BookListAdapter(books, this)
        recycle_book_list.adapter = adapter

//        floating = findViewById<FloatingActionButton>(R.id.fab) as FloatingActionButton
//        floating.setImageResource(R.drawable.icon_toolbar_clear)
//        floating.setBackgroundColor(resources.getColor(R.color.colorAccent))


//        booklistFragment = Fragment.instantiate(this@MainActivity,
//                BookListFragment::class.java.name) as BookListFragment
//        fragmentManager.beginTransaction().replace(R.id.main_container, booklistFragment)
//                .addToBackStack()
//                .commit()

//        linearLayoutManager = LinearLayoutManager(this)

//        val recyclerView = findViewById<RecyclerView>(R.id.recycle_book_list) as RecyclerView


    }

//    fun <T : View> Activity.bind(@IdRes idRes: Int): Lazy<T> {
//        @Suppress("UNCHECKED_CAST")
//        return unsafeLazy { findViewById<T>(idRes) as T }
//    }
//
//    fun <T : View> View.bind(@IdRes idRes: Int): Lazy<T> {
//        @Suppress("UNCHECKED_CAST")
//        return unsafeLazy { findViewById<T>(idRes) as T }
//    }
//
//    private fun <T> unsafeLazy(initializer: () -> T) = lazy(LazyThreadSafetyMode.NONE, initializer)

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//
//        menuInflater.inflate(R.menu.menu_toolbar_booklist, menu)
//        var searchViewItem: MenuItem = menu.findItem(R.id.search_action)
//        return super.onCreateOptionsMenu(menu)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
//        var id:Int = item!!.itemId
////        if (id == R.id.action_settings) return true
//
//        return super.onOptionsItemSelected(item)
//    }
}
