# Aileron

Aileron is an Android library that eliminates the boilerplate of extracting values from bundle in activity. 

```
public class ExampleActivity extends Activity {

    private static final String EXTRA_USER_ID = "user_id";

    @Extra(EXTRA_USER_ID) int mUserId; // This will automatically extracted value from bundle

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
