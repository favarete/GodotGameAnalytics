package org.godotengine.godot;

import android.app.Activity;

//import GameAnalytics SDK
import com.gameanalytics.sdk.GameAnalytics;

/**
 * Created by rodrigo favarete on April 2, 2017
 */

public class GodotGameAnalytics extends Godot.SingletonBase 
{   
    private Activity activity; 
    private boolean initialized;

    private static final String TAG = "GodotGameAnalytics";

    /* Methods
     * ********************************************************************** */

    /**
     * initialize SDK With GameKey and Secret Key
     */

    public void init(String gaGameKey, String gaSecretKey) 
    {
        if(!initialized) {
            final String gameKey = gaGameKey;
            final String secretKey = gaSecretKey;
            activity.runOnUiThread(new Runnable() {
                @Override 
                public void run() {
                    initOnUiThread(gameKey, secretKey);
                }
            });
        }
    }

    /**
     * initOnUiThread
     */

    public void initOnUiThread(String gaGameKey, String gaSecretKey) 
    {   
        GameAnalytics.initializeWithGameKey(activity, gaGameKey, gaSecretKey);
        initialized = true;
    }

    /**
     * Send a simple Design Event
     */

    public void sendCustomEvent(String eventHierarchy)
    {   
        if(initialized) {
            GameAnalytics.addDesignEventWithEventId(eventHierarchy);
        }    
    }

    /**
     * Send a Design Event with additional numerical value
     */

    public void sendCustomEventWithFloat(String eventHierarchy, float value)
    {   
        if(initialized) {
            GameAnalytics.addDesignEventWithEventId(eventHierarchy, value);
        }    
    }

    /**
     * If using modules for ads set this to true right before calling an ad and set back to false after return
     * to game, this avoids SDK ending a session
     */

    public void manualSessionHandling(boolean toggle)
    {
        if(initialized) {
            GameAnalytics.setEnabledManualSessionHandling(toggle);
        }    
    }

    /**
     * If manual session handling is enabled and SDK is initialized ("init" method will start a session automatically)
     * you can control the beggining of a session from here
     */

    public void startSession()
    {
        if(initialized) {
            GameAnalytics.startSession();
        }    
    }

    /**
     * If manual session handling is enabled, there's a active session and SDK is initialized ("init" method will
     * start a session automatically), you can control the end of a session from here
     */
    public void endSession()
    {
        if(initialized) {
            GameAnalytics.endSession();
        }    
    }


    /* Definitions
     * ********************************************************************** */

    /**
     * Initilization of the Singleton
     */

    static public Godot.SingletonBase initialize(Activity p_activity)
    {
        return new GodotGameAnalytics(p_activity);
    }

    /**
     * Constructor
     */

    public GodotGameAnalytics(Activity activity) 
    {
        registerClass("GodotGameAnalytics", new String[]
        {
            "init", 
            "sendCustomEvent",
            "sendCustomEventWithFloat",
            "manualSessionHandling",
            "startSession",
            "endSession"
        });

        this.activity = activity;
    }
}
