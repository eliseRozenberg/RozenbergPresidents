package rozenberg.presidents;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Elise on 12/10/2015.
 */
public class PresidentDetailFragment extends Fragment {

    private ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_president_detail, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        //remove intent bc its for sending message between activity and not fragments
        //serializable is to slow because it uses reflection

        //moved adapter down a method
    }

    public void showPresidentDetail(President[] presidentList,int[]images, int position) {
        PresidentPagerAdapter adapter = new PresidentPagerAdapter(presidentList, images);

        viewPager.setAdapter(adapter);
        //get list of presidents from one activity to another
        //prob is its static

        //also prob is that it doesnt know where in the array to start

        //default value in case its not sent
        viewPager.setCurrentItem(position);
    }

}
