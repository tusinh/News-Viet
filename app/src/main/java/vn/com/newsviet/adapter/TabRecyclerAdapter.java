package vn.com.newsviet.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

import vn.com.newsviet.R;
import vn.com.newsviet.Utils.MyLog;
import vn.com.newsviet.model.News;
import vn.com.newsviet.view.FontTextView;

public class TabRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<News> data;
    private OnMainLayoutClickListener listener;

    public interface OnMainLayoutClickListener {
        public void OnMainLayoutCLick(int position);
    }

    public TabRecyclerAdapter(Context context, ArrayList<News> data, OnMainLayoutClickListener listener) {
        this.context = context;
        this.data = data;
        this.listener = listener;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(context).inflate(R.layout.item_tab, parent, false);
        return new ViewHolder(convertView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        News item = data.get(position);
        viewHolder.titletab.setText(item.title);
        if (item.isSelected) {

            viewHolder.titletab.setTextColor(context.getResources().getColor(R.color.white));
            viewHolder.titletab.setFont("fonts/Roboto-Regular.ttf","bold");
//            viewHolder.titletab.setTypeface(viewHolder.titletab.getTypeface(), Typeface.BOLD);
            viewHolder.mainlayout_tab.setCardBackgroundColor(context.getResources().getColor(R.color.red));
            viewHolder.indicator.setBackgroundColor(context.getResources().getColor(R.color.red1));
        } else {
//            viewHolder.titletab.setPadding(10,8,10,8);
            viewHolder.titletab.setFont("fonts/Roboto-Regular.ttf","normal");
//            viewHolder.titletab.setTypeface(viewHolder.titletab.getTypeface(), Typeface.NORMAL);
            viewHolder.indicator.setBackgroundColor(context.getResources().getColor(R.color.xam));
            viewHolder.titletab.setTextColor(context.getResources().getColor(R.color.red1));
            viewHolder.mainlayout_tab.setCardBackgroundColor(context.getResources().getColor(R.color.white));
        }
//        int widthtitle = viewHolder.titletab.getLayoutParams().width;
//        MyLog.Log("widthtitle: "+widthtitle);

        viewHolder.mainlayout_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) listener.OnMainLayoutCLick(position);
            }
        });
    }

    public void setSelected(int position) {
        for (int i = 0; i < data.size(); i++) {
            data.get(i).isSelected = false;
        }
        data.get(position).isSelected = true;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        FontTextView titletab;
        View indicator;
        CardView mainlayout_tab;

        public ViewHolder(View itemView) {
            super(itemView);
            titletab = itemView.findViewById(R.id.titletab);
            indicator = itemView.findViewById(R.id.indicator);
            mainlayout_tab = itemView.findViewById(R.id.mainlayout_tab);
        }
    }
}
