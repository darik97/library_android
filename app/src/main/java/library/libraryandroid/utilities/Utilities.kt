package library.libraryandroid.utilities

import android.content.Context
import android.net.ConnectivityManager

class Constants {
    companion object {
        const val URL = "http://192.168.0.103"
    }
}

class NetworkManager(var context: Context) {
    public val isConnectedToInternet: Boolean?
        get() {
            val connManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val info = connManager.activeNetworkInfo
            return info != null && info.isConnected
        }
}
