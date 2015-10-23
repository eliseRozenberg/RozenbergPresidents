package rozenberg.presidents;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//handle the creation of A,B,C...
//bind will set the code for the name
//everytime the A.. goes back on sceen, build will give it the new data?
public class PresidentAdapter extends RecyclerView.Adapter<PresidentViewHolder> {

    private PresidentsList presidentList;
    //when a class needs something pass it through a constructor

    public PresidentAdapter(PresidentsList presidents){
        this.presidentList = presidents;
    }

    @Override
    public PresidentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.president_list_item, parent, false);
        return new PresidentViewHolder(itemView);
    }

    @Override
        public void onBindViewHolder(PresidentViewHolder holder, int position) {
            holder.bind(presidentList.get(position));
    }

    @Override
    public int getItemCount() {

        return presidentList.size();
    }
}