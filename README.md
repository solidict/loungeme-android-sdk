# loungeme-android-sdk
# LoungeMe Android SDK.

## 1. Install the SDK to your project via Gradle in Android Studio and add the dependencies below in your app build.gradle file:
```
dependencies {
    ...

    implementation 'com.github.solidict:loungeme-android-sdk:1.0.0'
}
```
### Add the repository below in your root build.gradle file
```
allprojects {
    repositories {
        ...
        
        maven { url 'https://jitpack.io' }

    }
}
```

## 2. Add LoungMeActivity into your AndroidManifest.xml:
```
 <activity
     android:theme="@style/Theme.AppCompat.NoActionBar"
     android:name="com.tav.loungemesdk.LoungMeActivity"/>
            
```

## 3. Start LoungMeActivity where do you want to use:
```
       LoungMeActivity.newIntent(MainActivity.this);
```
