package rozenberg.presidents;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//handle the creation of A,B,C...
//bind will set the code for the name
//everytime the A.. goes back on sceen, build will give it the new data?
public class PresidentAdapter extends RecyclerView.Adapter<PresidentViewHolder> {

    private President[] presidentList;
    private OnPresidentSelectedListener onClickListener;
    private int[] images;
    //when a class needs something pass it through a constructor

    public PresidentAdapter(President[] presidents, int[] images, OnPresidentSelectedListener listener) {
        this.presidentList = presidents;
        this.images = images;
        this.onClickListener = listener;
    }

    @Override
    //creates the line
    public PresidentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.president_list_item, parent, false);
        return new PresidentViewHolder(itemView);
    }

    @Override
    //puts the view into the line
    public void onBindViewHolder(final PresidentViewHolder holder, final int position) {
        holder.bind(presidentList[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.onSelect(presidentList, images, position);
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return presidentList.length;
    }
}
