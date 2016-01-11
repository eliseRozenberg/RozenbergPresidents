package rozenberg.presidents;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PresidentViewHolder extends RecyclerView.ViewHolder {


    @Bind(R.id.name)
    TextView name;

    public PresidentViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        //once for each class that you are binding to
    }

    public void bind(President president) {

        name.setText(president.getPresident());
    }
}
