# Aileron

Aileron is an Android library that eliminates the boilerplate of extracting values from bundle in activity or fragment.

```java
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

## License

```
Copyright 2015 OCHIISHI Koichiro

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
