package ch.beerpro;

import android.app.Application;
import ch.beerpro.presentation.utils.ThemeChanger;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

/**
 * The MyApplication class is instantiated once for the whole application and can (but should not) be used as a
 * singleton to store application wide data. The manifest contains a reference to this class, apart from that it is
 * not referenced in this application.
 */
public class MyApplication extends Application {

    public static int currentPosition;
    @Override
    public void onCreate() {
        super.onCreate();
        /*
         * This will log whenever we reveice data from firestore. This is useful for debugging and to get a feeling
         * of how much and when new data is received from the database.
         * */
        FirebaseFirestore.setLoggingEnabled(true);
    }
}