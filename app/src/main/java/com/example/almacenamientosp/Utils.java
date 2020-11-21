package com.example.almacenamientosp;

import android.app.Activity;
import android.content.Intent;

import com.example.almacenamientosp.R;

public class Utils
{
    private static int sTheme;
    public final static int THEME_DEFAULT = 0;
    public final static int THEME_WHITE = 1;
    public final static int THEME_BLUE = 2;

    public final static int LETRA_PEQUEÑA = 3;
    public final static int LETRA_MEDIANA = 4;
    public final static int LETRA_GRANDE = 5;

    /**
     * Set the theme of the Activity, and restart it by creating a new Activity of the same type.
     */
    public static void changeToTheme(Activity activity, int theme)
    {
        sTheme = theme;
        activity.finish();
        activity.startActivity(new Intent(activity, activity.getClass()));
    }
    /** Set the theme of the activity, according to the configuration. */
    public static void onActivityCreateSetTheme(Activity activity, int sTheme)
    {
        switch (sTheme)
        {
            default:
            case THEME_DEFAULT:
                activity.setTheme(R.style.AppTheme);
                break;
            case THEME_WHITE:
                activity.setTheme(R.style.black_Theme);
                break;
            case THEME_BLUE:
                activity.setTheme(R.style.blue_Theme);
                break;
            case LETRA_PEQUEÑA:
                activity.setTheme(R.style.letra_pequeña);
                break;
            case LETRA_MEDIANA:
                activity.setTheme(R.style.letra_mediana);
                break;
            case LETRA_GRANDE:
                activity.setTheme(R.style.letra_grande);
                break;
        }
    }
}