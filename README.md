## **How to use:**

* Project -> New -> Module -> Import Gradle Project;
* add dependency to app/build.gradle

```
dependencies {
   ....

   compile project(':splashscreen');
}
```

* include ':splashscreen' into settings.gradle;

* create activity and include import
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