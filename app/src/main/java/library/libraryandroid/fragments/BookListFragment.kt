package library.libraryandroid.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.widget.Toolbar
import library.libraryandroid.utilities.NetworkManager

class BookListFragment : Fragment() {

    companion object {
        @JvmStatic fun newInstance(): BookListFragment {
            return BookListFragment()
        }
    }

    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
    }



    private var networkManager = NetworkManager(this.context!!)

    fun loadBooks() {
    }

}