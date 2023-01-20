# Keep class names of Hilt injected ViewModels since their name are used as a multibinding map key.
-keepnames @dagger.hilt.android.lifecycle.HiltViewModel class * extends androidx.lifecycle.ViewModel

#Onesignal
-dontwarn com.onesignal.**
-keep class com.onesignal.ActivityLifecycleListenerCompat** {*;}

#Lottie
-dontwarn com.airbnb.lottie.**
-keep class com.airbnb.lottie.** {*;}
#AppsFlyer
-keep class com.appsflyer.** { *; }
-keep public class com.android.installreferrer.** { *; }

# Facebook
-keep class com.facebook.** {
   *;
}


#Coroutines
-keep class kotlinx.coroutines.**
-dontwarn kotlinx.coroutines.**

# Retrofit
-keep class com.google.gson.** { *; }
-keep public class com.google.gson.** {public private protected *;}
-keep class com.google.inject.** { *; }
-keep class org.apache.http.** { *; }
-keep class retrofit.** { *; }
-keepattributes *Annotation*
-keepattributes Signature
-dontwarn com.squareup.okhttp.*


#Volley
-keep class com.android.volley.** { *; }
-keep class org.apache.commons.logging.**
-keepattributes *Annotation*
-dontwarn org.apache.**




-keepclassmembers,allowobfuscation class * {
@com.google.gson.annotations.SerializedName <fields>;
}