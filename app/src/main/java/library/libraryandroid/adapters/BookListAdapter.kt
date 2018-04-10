package library.libraryandroid.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.book_card.view.*
import library.libraryandroid.utilities.Constants
import library.libraryandroid.R
import library.libraryandroid.models.BriefBook

class BookListAdapter(val books: BriefBook.List, private val bookCardClickListener: (BriefBook) -> Unit)
    : RecyclerView.Adapter<BookListAdapter.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookListAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.book_card, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: BookListAdapter.ViewHolder, position: Int) {
        holder.bindItems(books[position], bookCardClickListener)
    }

    override fun getItemCount(): Int {
        return books.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindItems(book: BriefBook, clickListener: (BriefBook) -> Unit) {
            itemView.book_title.text = book.title
            itemView.book_author.text = book.author
            itemView.book_state.text = book.getStateName()

//            when (book.status) {
//                0->itemView.book_state.setTextColor(context.getColor(R.color.stateIsRead))
//                1->itemView.book_state.setTextColor(context.getColor(R.color.stateInPlans))
//                2->itemView.book_state.setTextColor(context.getColor(R.color.stateInProgress))
//                3->itemView.book_state.setTextColor(context.getColor(R.color.stateNotInteresting))
//            }

            Glide.with(itemView.context)
                    .load(Constants.URL + book.image)
                    .apply(RequestOptions.circleCropTransform())
                    .into(itemView.book_image)
            itemView.book_card.setOnClickListener {
                run {
                    clickListener(book)
                }
            }
        }
    }
}
