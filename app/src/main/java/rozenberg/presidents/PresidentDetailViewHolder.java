package rozenberg.presidents;

import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Elise on 1/7/2016.
 */

//creates a  view and with holder sepreate - makes the code more readable
public class PresidentDetailViewHolder {
    @Bind(R.id.name)
    TextView name;
    @Bind(R.id.number)
    TextView number;

    public  PresidentDetailViewHolder (View itemView, President president){
        ButterKnife.bind(this, itemView);
    }
}
