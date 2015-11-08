package rozenberg.presidents;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class PresidentViewHolder extends RecyclerView.ViewHolder {

    private TextView name;

    //the president_list_item.xml
    //view holder because find view by id takes to long
    //so created view holder so that only call  find view by id once and save it
    //and call bind - as many times as need to bind the president info to the view holder

    public PresidentViewHolder(View itemView) {
        super(itemView);
        name = (TextView) itemView.findViewById(R.id.name);
    }

    public void bind(President president){
        name.setText(president.getPresident());
    }
}
