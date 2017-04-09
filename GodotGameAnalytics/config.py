def can_build(plat):
	return plat=="android"

def configure(env):
	if (env['platform'] == 'android'):
		env.android_add_to_manifest("android/AndroidManifestChunk.xml")
		env.android_add_to_permissions("android/AndroidPermissionsChunk.xml")
		env.android_add_java_dir("android/src")
		env.android_add_dependency("compile files('../../../modules/GodotGameAnalytics/android/lib//gameanalytics.jar')")
		env.android_add_dependency("compile 'com.google.android.gms:play-services-basement:8.4.0'")
		env.android_add_dependency("compile 'com.google.android.gms:play-services-ads:8.4.0'")
		env.android_add_dependency("compile 'com.android.support:appcompat-v7:23.1.1'")