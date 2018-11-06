package ch.beerpro.presentation.utils;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;
import ch.beerpro.R;



public class ThemeChanger {
    private static int sTheme;


    public final static int THEME_BEER_THEME = 0;
    public final static int THEME_PINK_UNICORN_THEME = 1;

    public static void changeToTheme(Activity activity, int theme) {
        sTheme = theme;
        activity.finish();
        activity.startActivity(new Intent(activity, activity.getClass()));
        activity.overridePendingTransition(android.R.anim.fade_in,
                android.R.anim.fade_out);
    }

    public static void onActivityCreateSetTheme(Activity activity) {
        switch (sTheme) {
            case THEME_BEER_THEME:
                activity.setTheme(R.style.Theme_BeerTheme);
                break;
            case THEME_PINK_UNICORN_THEME:
                activity.setTheme(R.style.Theme_PinkUnicornTheme);
                break;
                default:
        }
    }
}