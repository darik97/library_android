package library.libraryandroid.fragments

import android.app.ActionBar
import android.app.Fragment
import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toolbar
import kotlinx.android.synthetic.main.book_list_fragment.*
import library.libraryandroid.R
import library.libraryandroid.adapters.BookListAdapter
import library.libraryandroid.models.BriefBook

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

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {

        val view = inflater!!.inflate(R.layout.book_card, container, false)
//        var recycle = view.findViewById<RecyclerView>(R.id.recycle_book_list) as RecyclerView




        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private var networkManager = NetworkManager(this.context!!)

    fun loadBooks() {
    }

}

class NetworkManager(var context: Context) {
    val isConnected: Boolean?
        get() {
            val connectManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val info = connectManager.activeNetworkInfo
            return info != null && info.isConnected
        }
}