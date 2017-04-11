package org.godotengine.godot;

import android.app.Activity;

//import GameAnalytics SDK
import com.gameanalytics.sdk.GameAnalytics;
import com.gameanalytics.sdk.GAProgressionStatus;
import com.gameanalytics.sdk.GAErrorSeverity;

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
        if(!initialized) 
        {
            final String gameKey = gaGameKey;
            final String secretKey = gaSecretKey;
            activity.runOnUiThread(new Runnable() 
            {
                @Override 
                public void run() 
                {
                    initOnUiThread(gameKey, secretKey);
                }
            });
        }
    }

    /**
     * Initialize the SDK
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
        if(initialized) 
        {
            GameAnalytics.addDesignEventWithEventId(eventHierarchy);
        }    
    }

    /**
     * Send a Design Event with additional numerical value
     */

    public void sendCustomEventWithFloat(String eventHierarchy, float value)
    {   
        if(initialized) 
        {
            GameAnalytics.addDesignEventWithEventId(eventHierarchy, value);
        }    
    }

    /**
     * If using modules for ads set this to true right before calling an ad and set back to false after return
     * to game, this avoids SDK ending a session
     */

    public void manualSessionHandling(boolean toggle)
    {
        if(initialized) 
        {
            GameAnalytics.setEnabledManualSessionHandling(toggle);
        }    
    }

    /**
     * If manual session handling is enabled and SDK is initialized ("init" method will start a session automatically),
     * you can control the beggining of a session from here
     */

    public void startSession()
    {
        if(initialized) 
        {
            GameAnalytics.startSession();
        }    
    }

    /**
     * If manual session handling is enabled, there's a active session and SDK is initialized ("init" method will
     * start a session automatically), you can control the end of a session from here
     */

    public void endSession()
    {
        if(initialized) 
        {
            GameAnalytics.endSession();
        }    
    }

    /**
     * Progression Event Start. Use this when a player is starting a progression attempt
     */

    public void progressionStart_1(String progression01)
    {
        if(initialized) 
        {
            GameAnalytics.addProgressionEventWithProgressionStatus(GAProgressionStatus.Start, progression01);
        }
    }

    public void progressionStart_2(String progression01, String progression02)
    {
        if(initialized) 
        {
            GameAnalytics.addProgressionEventWithProgressionStatus(GAProgressionStatus.Start, progression01, progression02);
        }
    }

    public void progressionStart_3(String progression01, String progression02, String progression03)
    {
        if(initialized) 
        {
            GameAnalytics.addProgressionEventWithProgressionStatus(GAProgressionStatus.Start, progression01, progression02, progression03);
        }
    }

    /**
     * Progression Event Fail. Use this when a player fails the attempt. When using a 3 tier hierarchy structure
     * you can also pass an optional integer 
     */

    public void progressionFail_1(String progression01)
    {
        if(initialized) 
        {
            GameAnalytics.addProgressionEventWithProgressionStatus(GAProgressionStatus.Fail, progression01);
        }
    }

    public void progressionFail_2(String progression01, String progression02)
    {
        if(initialized) 
        {
            GameAnalytics.addProgressionEventWithProgressionStatus(GAProgressionStatus.Fail, progression01, progression02);
        }
    }

    public void progressionFail_3(String progression01, String progression02, String progression03)
    {
        if(initialized) 
        {
            GameAnalytics.addProgressionEventWithProgressionStatus(GAProgressionStatus.Fail, progression01, progression02, progression03);
        }
    }

    public void progressionFail_3_WithInt(String progression01, String progression02, String progression03, int score)
    {
        if(initialized) 
        {
            GameAnalytics.addProgressionEventWithProgressionStatus(GAProgressionStatus.Fail, progression01, progression02, progression03, score);
        }
    }

    /**
     * Progression Event Complete. Use this when a player completes the attempt. When using a 3 tier hierarchy structure
     * you can also pass an optional integer 
     */

    public void progressionComplete_1(String progression01)
    {
        if(initialized) 
        {
            GameAnalytics.addProgressionEventWithProgressionStatus(GAProgressionStatus.Complete, progression01);
        }
    }

    public void progressionComplete_2(String progression01, String progression02)
    {
        if(initialized) 
        {
            GameAnalytics.addProgressionEventWithProgressionStatus(GAProgressionStatus.Complete, progression01, progression02);
        }
    }

    public void progressionComplete_3(String progression01, String progression02, String progression03)
    {
        if(initialized) 
        {
            GameAnalytics.addProgressionEventWithProgressionStatus(GAProgressionStatus.Complete, progression01, progression02, progression03);
        }
    }

    public void progressionComplete_3_WithInt(String progression01, String progression02, String progression03, int score)
    {
        if(initialized) 
        {
            GameAnalytics.addProgressionEventWithProgressionStatus(GAProgressionStatus.Complete, progression01, progression02, progression03, score);
        }
    }

    /**
     * Use this to track custom error events in your game. You can use the various severity level functions 
     * and attach a message.
     */

    public void sendReportDebug(String debugMessage)
    {
        if(initialized)
        {
            GameAnalytics.addErrorEventWithSeverity(GAErrorSeverity.Debug, debugMessage);
        }
    }

    public void sendReportInfo(String infoMessage)
    {
        if(initialized)
        {
            GameAnalytics.addErrorEventWithSeverity(GAErrorSeverity.Info, infoMessage);
        }
    }

    public void sendReportWarning(String warningMessage)
    {
        if(initialized)
        {
            GameAnalytics.addErrorEventWithSeverity(GAErrorSeverity.Warning, warningMessage);
        }
    }

    public void sendReportError(String errorMessage)
    {
        if(initialized)
        {
            GameAnalytics.addErrorEventWithSeverity(GAErrorSeverity.Error, errorMessage);
        }
    }

    public void sendReportCriticalError(String criticalErrorMessage)
    {
        if(initialized)
        {
            GameAnalytics.addErrorEventWithSeverity(GAErrorSeverity.Critical, criticalErrorMessage);
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
            "endSession",
            "progressionStart_1",
            "progressionStart_2",
            "progressionStart_3",
            "progressionFail_1",
            "progressionFail_2",
            "progressionFail_3",
            "progressionFail_3_WithInt",
            "progressionComplete_1",
            "progressionComplete_2",
            "progressionComplete_3",
            "progressionComplete_3_WithInt",
            "sendReportDebug",
            "sendReportInfo",
            "sendReportWarning",
            "sendReportError",
            "sendReportCriticalError"
        });

        this.activity = activity;
    }
}
