package library.libraryandroid.adapters

import android.app.Activity
import android.os.Bundle
import android.app.SearchManager
import android.content.Intent



/**
 * Created by Daria on 07.04.2018.
 */
class SearchResultsActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        handleIntent(intent)
    }

    private fun handleIntent(intent: Intent) {

        if (Intent.ACTION_SEARCH == intent.action) {
            val query = intent.getStringExtra(SearchManager.QUERY)
            //use the query to search your data somehow
        }
    }
}