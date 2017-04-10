# GodotGameAnalytics

This is an implementation of the [GameAnalytics](http://www.gameanalytics.com/) Android SDK for the 
[Godot Game Engine](https://github.com/godotengine/godot)!

The module works only on Android and has been tested with Godot-2.1.2-stable.

## Available Features
> Design Event; 

> Progression Event; 

> Session Handling.

## Build/Compile Module
1. Copy the "GodotGameAnalytics" folder to the *modules* folder inside of Godot source code;
2. Compile the Android Export Templates. [[docs]](http://docs.godotengine.org/en/stable/reference/compiling_for_android.html)

## Configure GodotGameAnalytics
1. Add the module in the `engine.cfg`:
```
[android]
modules="org/godotengine/godot/GodotGameAnalytics"
```
2. On the project *Export* settings, load the *Custom Package* with the 'GodotGameAnalytics' compiled module templates.
3. **[optional]** The mandatory permissions are already configured. Information about additional permissions, as well as their advantages and disadvantages can be found [here](https://github.com/GameAnalytics/GA-SDK-ANDROID/wiki/Configure-Android-Studio#storage-permissions) and [here](https://github.com/GameAnalytics/GA-SDK-ANDROID/wiki/Configure-Android-Studio#optional-fallback-option-for-identifier-imei).

## Initialize GodotGameAnalytics
To to use the module functions on your scripts, start the module as follows: 

(You can [Sign Up](https://go.gameanalytics.com/signup) for free to get the keys).

```GDScript

var gameAnalytics

var gameKey = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"
var secretKey = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"

func _ready():
	if(Globals.has_singleton("GodotGameAnalytics")):
		gameAnalytics = Globals.get_singleton("GodotGameAnalytics")
		gameAnalytics.init(gameKey, secretKey)

```

And declare the functions you need:

```GDScript

func sendCustomEvent(stringHierarchy):
	if gameAnalytics:
		gameAnalytics.sendCustomEvent(stringHierarchy)

```
(You can learn more about *Singletons* and initializations [here](http://docs.godotengine.org/en/stable/tutorials/step_by_step/singletons_autoload.html)). 


Then call the function wherever you need, following the reference below:

## API Reference
The following functions are available:


**Startup Function**

```GDScript
void init(String appId, String appSignature)
```
___

**Design Event**

```GDScript
void sendCustomEvent(String stringHierarchy)
```
The *stringHierarchy* is a String that can consist of 1-5 segments separated by ':'.  
Each segment can have a max length of 32.  
Eg: "Kill:Sword:Robot"  


**Design Event With Float Value**

```GDScript
void sendCustomEventWithFloat(String stringHierarchy, float value)
```
Same as above, but now you can pass a float value within the event. 


More information about *Design Events* can be found [here](http://www.gameanalytics.com/docs/custom-events).

___

**Progression Event Start**

```GDScript
void progressionStart_1(String progression01)
void progressionStart_2(String progression01, String progression02)
void progressionStart_3(String progression01, String progression02, String progression03)
```
Use this when a player initiates an attempt to progress the game. The functions give you the option to use from 1 to 3 parameters that represent the beginning of the progression in your game. 


**Progression Event Fail**

```GDScript
void progressionFail_1(String progression01)
void progressionFail_2(String progression01, String progression02)
void progressionFail_3(String progression01, String progression02, String progression03)
void progressionFail_3_WithInt(String progression01, String progression02, String progression03, int score)
```
Use this when the player fails the attempt to progress. When using a three-tier structure you have the option to use a function of Strings only or a function composed of Strings and an integer value (to represent a score, for example). 


**Progression Event Complete**

```GDScript
void progressionFail_1(String progression01)
void progressionFail_2(String progression01, String progression02)
void progressionFail_3(String progression01, String progression02, String progression03)
void progressionFail_3_WithInt(String progression01, String progression02, String progression03, int score)
```
Use this when the player succeeds the attempt to progress. When using a three-tier structure you have the option to use a function of Strings only or a function composed of Strings and an integer value, as in the case above. 


More information about *Progression Events* can be found [here](http://www.gameanalytics.com/docs/ga-data).

___

**Manual Session Handling**

```GDScript
void manualSessionHandling(bool enable)
```
Ads will most likely interfere with the session length of the game. To prevent this you need to 
use manual session handling at least when you are about to show ads. So, If you're using modules for ads 
set this to `true` right before calling an ad and set back to `false` when return from ad.

___

**Start Session And End Session**

```GDScript
void startSession()
void endSession()
```
If you decide to keep manual session handling enabled, you can use these functions to control when 
sessions begin and end (`init` method will always start a session automatically).