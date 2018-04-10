package library.libraryandroid.ui

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import library.libraryandroid.R
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.book_list.*
import library.libraryandroid.adapters.BookListAdapter
import library.libraryandroid.fragments.BookListFragment
import library.libraryandroid.models.BriefBook
import android.widget.SearchView
import library.libraryandroid.fragments.AllBooksFragment


class MainActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var drawer: DrawerLayout
    private lateinit var navigetion: NavigationView
    private lateinit var drawerToggle: ActionBarDrawerToggle


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById<Toolbar>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setTitle(R.string.all_books)

        drawer = findViewById(R.id.drawer)
        drawerToggle = ActionBarDrawerToggle(
                this,
                drawer,
                toolbar,
                R.string.drawer_open,
                R.string.drawer_close
        )
        drawer.addDrawerListener(drawerToggle)

        navigetion = findViewById(R.id.navigation_view)
        navigetion.setNavigationItemSelectedListener {
            selectDrawerItem(it)
            true
        }

        if (savedInstanceState == null) selectDrawerItem(navigetion.menu!!.getItem(0))
    }

    private fun selectDrawerItem(menuItem: MenuItem) {
        var fragment: Fragment? = when (menuItem.itemId) {
            R.id.nav_all_books -> {
                AllBooksFragment()
            }
            R.id.nav_plan_books -> {
                BookListFragment()
            }
            R.id.nav_process_books -> {
                BookListFragment()
            }
            R.id.nav_read_books -> {
                BookListFragment()
            }
            else -> BookListFragment()
        }
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
        menuItem.isChecked = true
        title = menuItem.title
        drawer.closeDrawers()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            android.R.id.home -> {
                drawer.openDrawer(GravityCompat.START)
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        drawerToggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        drawerToggle.onConfigurationChanged(newConfig)
    }
}
