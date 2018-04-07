package library.libraryandroid.ui

import android.app.Fragment
import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.CollapsingToolbarLayout
import android.support.design.widget.FloatingActionButton
import android.support.v7.graphics.Palette
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import library.libraryandroid.R
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.book_list_fragment.*
import library.libraryandroid.adapters.BookListAdapter
import library.libraryandroid.fragments.BookListFragment
import library.libraryandroid.models.BriefBook
import android.support.v4.widget.SearchViewCompat.setSearchableInfo
import android.support.v4.view.MenuItemCompat.getActionView
import android.widget.SearchView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)
    }


//    private lateinit var toolbar: Toolbar
//    private lateinit var floating: FloatingActionButton
//    private lateinit var linearLayoutManager: LinearLayoutManager
//    private var booklistFragment: BookListFragment? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
////        handleIntent(intent)
//        setContentView(R.layout.activity_main)
//
//        toolbar = findViewById<Toolbar>(R.id.toolbar_booklist) as Toolbar
//        setSupportActionBar(toolbar)
//        supportActionBar?.setTitle(R.string.all_books)
//
//        recycle_book_list.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
//
//        val books = ArrayList<BriefBook>()
//        books.add(BriefBook(-1, "Азъ есмь Софья. Сестра", "Гончарова Галина", 0, ""))
//        books.add(BriefBook(-1, "Азъ есмь Софья. Царевна", "Гончарова Галина", 1, ""))
//        books.add(BriefBook(-1, "Азъ есмь Софья. Государыня", "Гончарова Галина", 2, ""))
//        books.add(BriefBook(-1, "Азъ есмь Софья. Тень за троном", "Гончарова Галина", 3, ""))
//
//        val adapter = BookListAdapter(books, this)
//        recycle_book_list.adapter = adapter
//
////        floating = findViewById<FloatingActionButton>(R.id.fab) as FloatingActionButton
////        floating.setImageResource(R.drawable.icon_toolbar_clear)
////        floating.setBackgroundColor(resources.getColor(R.color.colorAccent))
//
//
////        booklistFragment = Fragment.instantiate(this@MainActivity,
////                BookListFragment::class.java.name) as BookListFragment
////        fragmentManager.beginTransaction().replace(R.id.main_container, booklistFragment)
////                .addToBackStack()
////                .commit()
//
////        linearLayoutManager = LinearLayoutManager(this)
//
//        val recyclerView = findViewById<RecyclerView>(R.id.recycle_book_list) as RecyclerView
//
//
//    }

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//
//        menuInflater.inflate(R.menu.menu_toolbar_booklist, menu)
//
//        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
//        val searchView = menu.findItem(R.id.search_action).actionView as SearchView
//        searchView.setSearchableInfo(
//                searchManager.getSearchableInfo(componentName))
//
//        return super.onCreateOptionsMenu(menu)
//    }


//    private fun handleIntent(intent: Intent) {
//
//        if (Intent.ACTION_SEARCH == intent.action) {
//            val query = intent.getStringExtra(SearchManager.QUERY)
//            //use the query to search your data somehow
//        }
//    }

//    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
//        var id:Int = item!!.itemId
////        if (id == R.id.action_settings) return true
//
//        return super.onOptionsItemSelected(item)
//    }
}
