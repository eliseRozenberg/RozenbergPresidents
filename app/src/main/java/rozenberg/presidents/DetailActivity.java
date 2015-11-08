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
       President [] presidentList = (President[]) getIntent().getSerializableExtra("PRESIDENTS");
        //serializable is to slow because it uses reflection
        PresidentPagerAdapter adapter = new PresidentPagerAdapter(presidentList);
        viewPager.setAdapter(adapter);
        //get list of presidents from one activity to another
        //prob is its static

        //also prob is that it doesnt know where in the array to start
        int position= getIntent().getIntExtra("POSITION",0);

        //default value in case its not sent
        viewPager.setCurrentItem(position);
    }
}
