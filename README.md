# Aileron

Aileron is an Android library that eliminates the boilerplate of extracting values from bundle in activity or fragment.

```java
public class ExampleActivity extends Activity {

    private static final String EXTRA_USER_ID = "user_id";

    @Extra(EXTRA_USER_ID) int mUserId; // This will automatically set value from bundle

    public static Intent create(Context context, int userId) {
        Intent intent = new Intent(context, ExampleActivity.class);
        intent.putExtra(EXTRA_USER_ID, userId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);
        Aileron.roll(this);
    }
}
```

## Install

```gradle
dependencies {
    compile 'com.rakuishi:aileron:0.1.0'
}
```

## Supported types

Aileron supports these types for now.

- Primitive types (byte, short, int, long, float, double, char, boolean)
- List of primitive types (byte, short, int, long, float, double, char, boolean)
- Primitive wrappers (Byte, Short, Int, Long, Float, Double, Char, Boolean)
- ArrayList\<Integer\>
- String, String[], ArrayList\<String\>
- CharSequence, CharSequence[], ArrayList\<CharSequence\>
- android.util.Size, android.util.SizeF

## Todo

Supports Parcelable, ParcelableArray, ParcelableArrayList, and Serializable.

## For developers

### Upload library

```sh
$ ./gradlew clean build bintrayUpload -PbintrayUser=[bintrayUser] -PbintrayKey=[bintrayKey] -PdryRun=false
```
