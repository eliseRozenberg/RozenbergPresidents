package rozenberg.presidents;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PresidentListFragment extends Fragment {
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_president_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        InputStream in = getResources().openRawResource(R.raw.presidents);
        President[] presidents = gson.fromJson(new InputStreamReader(in), President[].class);

        int[] images = new int[]{
                R.drawable.gwash, R.drawable.jadams, R.drawable.tjeff, R.drawable.jmad, R.drawable.jmon,
                R.drawable.jqdams, R.drawable.ajack, R.drawable.mvburen, R.drawable.whharis, R.drawable.jtyler,
                R.drawable.jkpolk, R.drawable.ztaylor, R.drawable.mfil, R.drawable.fpierce, R.drawable.jbuch,
                R.drawable.alinc, R.drawable.ajohn, R.drawable.usgrant, R.drawable.rbhayes, R.drawable.jagar,
                R.drawable.caarth, R.drawable.gclev, R.drawable.bharis, R.drawable.gclev, R.drawable.wmick,
                R.drawable.troos, R.drawable.whtaft, R.drawable.wwil, R.drawable.wghard, R.drawable.ccool,
                R.drawable.hhoov, R.drawable.fdroos, R.drawable.hstru, R.drawable.ddeisen, R.drawable.jfkenn,
                R.drawable.lbjohn, R.drawable.rmnix, R.drawable.grford, R.drawable.jcart, R.drawable.rreag,
                R.drawable.gbush, R.drawable.bclint, R.drawable.gwbush, R.drawable.bobama};


        //an interface that defines onClick
        OnPresidentSelectedListener listener = (OnPresidentSelectedListener) getActivity();
        PresidentAdapter adapter = new PresidentAdapter(presidents, images, listener);
        //tell recycler view to use this adapter
        recyclerView.setAdapter(adapter);
    }
}
