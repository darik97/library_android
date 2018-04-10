package library.libraryandroid.fragments

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.book_list.*
import library.libraryandroid.R
import library.libraryandroid.adapters.BookListAdapter
import library.libraryandroid.models.BriefBook
import library.libraryandroid.ui.BookInfoActivity
import library.libraryandroid.utilities.Constants
import library.libraryandroid.utilities.loadBooks

class AllBooksFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val rootView = inflater.inflate(R.layout.book_list, container, false)
        rootView!!.findViewById<SwipeRefreshLayout>(R.id.srefresh).apply {
            setColorSchemeResources(R.color.colorPrimaryDark, R.color.colorPrimary, R.color.colorAccent)
            setOnRefreshListener({
                isRefreshing = false
                loadBooks(Constants.URL)
            })
        }

        return rootView
    }

    override fun onResume() {
        super.onResume()
        recycle_book_list.layoutManager = LinearLayoutManager(view?.context, LinearLayout.VERTICAL, false)
    }



    fun showBooks(books: BriefBook.List) {
        val adapter = BookListAdapter(books) {
            showBookInfo(it)
        }
        recycle_book_list.adapter = adapter
    }

    fun showBookInfo(book: BriefBook) {
        val intent = Intent(view!!.context, BookInfoActivity::class.java)
    }
}
