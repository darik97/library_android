package library.libraryandroid.adapters

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import kotlinx.android.synthetic.main.book_card.view.*
import library.libraryandroid.R
import library.libraryandroid.fragments.BookListFragment
import library.libraryandroid.models.BriefBook

class BookListAdapter(val books: ArrayList<BriefBook>, val context: Context)
    : RecyclerView.Adapter<BookListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookListAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.book_card, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: BookListAdapter.ViewHolder, position: Int) {
        holder.bindItems(books[position], context)
    }

    override fun getItemCount(): Int {
        return books.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindItems(book: BriefBook, context: Context) {
            itemView.book_title.text = book.title
            var authors : ArrayList<String> = ArrayList()
            for (author in book.authors )
                authors.add(author.firstName + " " + author.lastName)
            itemView.book_author.text = authors.joinToString(", ")
            itemView.book_state.text = book.getStateName()

            when (book.status) {
                0->itemView.book_state.setTextColor(context.getColor(R.color.stateIsRead))
                1->itemView.book_state.setTextColor(context.getColor(R.color.stateInPlans))
                2->itemView.book_state.setTextColor(context.getColor(R.color.stateInProgress))
                3->itemView.book_state.setTextColor(context.getColor(R.color.stateNotInteresting))
            }
        }
    }
}
