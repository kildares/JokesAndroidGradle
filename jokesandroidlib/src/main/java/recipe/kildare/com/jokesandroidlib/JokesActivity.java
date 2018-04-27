package recipe.kildare.com.jokesandroidlib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class JokesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes);

        Intent intent = getIntent();
        if(intent != null){
            Bundle extras = intent.getExtras();
            if(extras != null){
                String joke = extras.getString(getString(R.string.JOKE_KEY));
            }
        }
    }
}
