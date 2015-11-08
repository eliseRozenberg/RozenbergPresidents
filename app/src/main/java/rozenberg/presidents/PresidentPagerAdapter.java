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
public class PresidentPagerAdapter extends PagerAdapter{
     private President[] presidents;

    public PresidentPagerAdapter(President[] presidents){
        this.presidents = presidents;
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
        int[]pic = new int[]{
                R.drawable.gwash, R.drawable.jadams, R.drawable.tjeff,R.drawable.jmad,R.drawable.jmon,
                R.drawable.jqdams,R.drawable.ajack,R.drawable.mvburen,R.drawable.whharis,R.drawable.jtyler,
                R.drawable.jkpolk,R.drawable.ztaylor,R.drawable.mfil,R.drawable.fpierce,R.drawable.jbuch,
                R.drawable.alinc,R.drawable.ajohn,R.drawable.usgrant,R.drawable.rbhayes,R.drawable.jagar,
                R.drawable.caarth,R.drawable.gclev,R.drawable.bharis,R.drawable.gclev,R.drawable.wmick,
                R.drawable.troos, R.drawable.whtaft,R.drawable.wwil,R.drawable.wghard,R.drawable.ccool,
                R.drawable.hhoov,R.drawable.fdroos,R.drawable.hstru,R.drawable.ddeisen,R.drawable.jfkenn,
                R.drawable.lbjohn,R.drawable.rmnix,R.drawable.grford,R.drawable.jcart,R.drawable.rreag,
                R.drawable.gbush,R.drawable.bclint,R.drawable.gwbush,R.drawable.bobama};
        ImageView image = (ImageView) view.findViewById(R.id.image);
        TextView name = (TextView) view.findViewById(R.id.name);
        TextView number = (TextView) view.findViewById(R.id.number);
        TextView birthYearDeathYear = (TextView) view.findViewById(R.id.birthYearDeathYear);
        TextView tookOfficeLeftOffice = (TextView) view.findViewById(R.id.tookOfficeLeftOffice);
        TextView party = (TextView) view.findViewById(R.id.party);

        //insert rest of info later

        //position is president in the array
        President president = presidents[position];
        image.setImageResource(pic[position]);
        name.setText(president.getPresident());
        number.setText(String.valueOf("President #" +president.getNumber()));
        birthYearDeathYear.setText(String.valueOf(president.getBirthYear() + "  /  " + president.getDeathYear()));
        tookOfficeLeftOffice.setText(president.getTookOffice() + "  /  " + president.getLeftOffice());
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