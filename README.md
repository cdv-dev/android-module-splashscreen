## **How to use:**

* Clone this repository or download zip.
* Open Android Studio and select File -> New -> Import module -> Select directory "splashscreen". 
* Check dependency in the app/build.gradle or add if there is no it:

```
dependencies {
   ....

   compile project(':splashscreen');
}
```

* include ':splashscreen' into settings.gradle;

* create activity and include import:
```java
   import com.cdvdev.splashscreen.BaseSplashActivity;
```

* extends from BaseSplashActivity;

**Example:**

```java
public class SplashActivity extends BaseSplashActivity {

    @Override
    public void onRunNextActivity(Activity splashActivityReference) {
        Intent intent = new Intent(splashActivityReference, MainActivity.class);
        startActivity(intent);
        splashActivityReference.finish();
    }

    @Override
    public int getSplashLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public int getSplashShowTime() {
        return 2000;
    }
}
```
