package rozenberg.presidents;

import android.graphics.drawable.Drawable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Elise on 10/29/2015.
 */
public class PresidentPagerAdapter extends PagerAdapter {
    private President[] presidents;
    private int []images;

    public PresidentPagerAdapter(President[] presidents, int[]images) {
        this.presidents = presidents;
        this.images=images;
    }


    @Override
    public int getCount() {
        return presidents.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        //doesnt know what for but should return it
        return view == object;
    }

    //we generated these to destroy the pages as swiping
    //looks like the onCreate of president adapter
    //we need to display president data

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        View view = inflater.inflate(R.layout.president_pager_item, null);

        ImageView image = (ImageView) view.findViewById(R.id.image);
        TextView name = (TextView) view.findViewById(R.id.name);
        TextView number = (TextView) view.findViewById(R.id.number);
        TextView birthYearDeathYear = (TextView) view.findViewById(R.id.birthYearDeathYear);
        TextView tookOfficeLeftOffice = (TextView) view.findViewById(R.id.tookOfficeLeftOffice);
        TextView party = (TextView) view.findViewById(R.id.party);

        //insert rest of info later

        //position is president in the array
        President president = presidents[position];
        image.setImageResource(images[position]);
        name.setText(president.getPresident());
        number.setText(String.valueOf("President #" + president.getNumber()));

        if (president.getDeathYear() == null) {
            birthYearDeathYear.setText(String.valueOf(president.getBirthYear() + "  / Still Alive"));
        } else {
            birthYearDeathYear.setText(String.valueOf(president.getBirthYear() + "  /  " + president.getDeathYear()));
        }

        if (president.getLeftOffice() == null) {
            tookOfficeLeftOffice.setText(president.getTookOffice() + "  /  Still in Office");
        } else {
            tookOfficeLeftOffice.setText(president.getTookOffice() + "  /  " + president.getLeftOffice());
        }
        party.setText(president.getParty());
        //need to pass the view which got from inflater
        container.addView(view);
        return view;
    }

    //if dont override the method, it doesnt get removed
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}