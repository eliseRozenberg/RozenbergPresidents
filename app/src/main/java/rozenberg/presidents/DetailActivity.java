package rozenberg.presidents;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;


public class DetailActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        PresidentPagerAdapter adapter = new PresidentPagerAdapter(MainActivity.presidentsList);
        viewPager.setAdapter(adapter);
        //get list of presidents from one activity to another
    }
}
