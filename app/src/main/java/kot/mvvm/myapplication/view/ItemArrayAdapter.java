package kot.mvvm.myapplication.view;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

import kot.mvvm.myapplication.utils.ItemClickListener;
import kot.mvvm.myapplication.R;
import kot.mvvm.myapplication.data.Video_model;


public class ItemArrayAdapter extends RecyclerView.Adapter<ItemArrayAdapter.ViewHolder> {

    //All methods in this adapter are required for a bare minimum recyclerview adapter
    private int listItemLayout;
    private ArrayList<Video_model> itemList;
    private ItemClickListener itemClickListener;



    // Constructor of the class
    public ItemArrayAdapter(int layoutId, ArrayList<Video_model> itemList,ItemClickListener clickListener) {
        listItemLayout = layoutId;
        this.itemList = itemList;
        this.itemClickListener = clickListener;
    }


    @Override
    public int getItemCount() {
        return itemList == null ? 0 : itemList.size();
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(listItemLayout, parent, false);
        ViewHolder myViewHolder = new ViewHolder(view,itemClickListener);



        return myViewHolder;
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int listPosition) {
        TextView item = holder.item;
        TextView item1 = holder.item1;
        item.setText(itemList.get(listPosition).getVideo_name());
        item1.setText(itemList.get(listPosition).getVideo_desc());
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView item;
        public TextView item1;
        private ItemClickListener itemClickListener;

        public ViewHolder(View itemView,ItemClickListener clickListener) {
            super(itemView);
            itemView.setOnClickListener(this);
            item = (TextView) itemView.findViewById(R.id.videoname);
            item1 = (TextView) itemView.findViewById(R.id.videodesc);
            this.itemClickListener=clickListener;

            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {

            itemClickListener.onClick(getAdapterPosition());

        }
    }
}