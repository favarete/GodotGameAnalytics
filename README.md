# GodotGameAnalytics

This is an implementation of the [GameAnalytics](http://www.gameanalytics.com/) Android SDK for the 
[Godot Game Engine](https://github.com/godotengine/godot)!

The module works only on Android and has been tested with Godot-2.1.2-stable.

## Available Features
> Design Event;
> Session Handling.

## Build/Compile module
1. Copy the "GodotGameAnalytics" folder to the *modules* folder inside of Godot source code;
2. Compile the Android Export Templates. [[docs]](http://docs.godotengine.org/en/stable/reference/compiling_for_android.html)

## Configure GameAnalytics
1. Add the module in the `engine.cfg`:
```
[android]
modules="org/godotengine/godot/GodotGameAnalytics"
```
2. On the project *Export* settings, load the *Custom Package* with the 'GodotGameAnalytics' compiled module templates.
3. **[optional]** The mandatory permissions are already configured. Information about additional permissions, as well as their advantages and disadvantages can be found [here](https://github.com/GameAnalytics/GA-SDK-ANDROID/wiki/Configure-Android-Studio#storage-permissions) and [here](https://github.com/GameAnalytics/GA-SDK-ANDROID/wiki/Configure-Android-Studio#optional-fallback-option-for-identifier-imei).

## Initialize GameAnalytics
To to use the module functions on your scripts, start the module as follows:
(You can [Sign Up](https://go.gameanalytics.com/signup) for free to get the keys)

```GDScript

var GA

var gameKey = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"
var secretKey = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"

func _ready():
	if(Globals.has_singleton("GodotGameAnalytics")):
		GA = Globals.get_singleton("GodotGameAnalytics")
		GA.init(gameKey, secretKey)

```

And declare the functions you need:

```GDScript

func sendCustomEvent(stringHierarchy):
	if GA:
		GA.sendCustomEvent(stringHierarchy)

```
Then call the function wherever you need, following the reference below:

## API Reference
The following functions are available:


**Startup function**

```GDScript
void init(String appId, String appSignature)
```
___

**Design Event**

```GDScript
void sendCustomEvent(String stringHierarchy)
```
The *stringHierarchy* is a string that can consist of 1-5 segments separated by ':'. 
Each segment can have a max length of 32.
Eg: "Kill:Sword:Robot"


**Design Event with Float Value**

```GDScript
void sendCustomEventWithFloat(String stringHierarchy, float value)
```
Same as above, but now you can pass a float value within the event
More information about *Design Events* can be found [here](http://www.gameanalytics.com/docs/custom-events)

___

**Manual Session Handling**

```GDScript
void manualSessionHandling(bool enable)
```
Ads will most likely interfere with the session length of the game. To prevent this you need to 
use manual session handling at least when you are about to show ads. So, If you're using modules for ads 
set this to true right before calling an ad and set back to false when return from ad.

___

**Start Session and End Session**

```GDScript
void startSession()
void endSession()
```
If you decide to keep manual session handling enabled, you can use these functions to control when 
sessions begin and end ("init" method will always start a session automatically).