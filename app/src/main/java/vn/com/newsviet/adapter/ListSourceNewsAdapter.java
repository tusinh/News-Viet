package vn.com.newsviet.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

import vn.com.newsviet.R;
import vn.com.newsviet.listnews.ListNewsActivity;
import vn.com.newsviet.model.SourceNews;
import vn.com.newsviet.view.FontTextView;

public class ListSourceNewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<SourceNews> data;
    private int height = -1;

    public ListSourceNewsAdapter(Context context, ArrayList<SourceNews> data) {
        this.context = context;
        this.data = data;
    }

    public void setHeight(int height) {
        this.height = height;
        super.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(context).inflate(R.layout.item_sourcenews, parent, false);
        return new ViewHolder(convertView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        final SourceNews item = data.get(position);
        final ViewHolder holder = (ViewHolder) viewHolder;

        if (height != -1) {
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) holder.imageView.getLayoutParams();
//            GridLayoutManager.LayoutParams params1 = (GridLayoutManager.LayoutParams) holder.mainLayout.getLayoutParams();
//            params1.setMargins(10, 5, 5, 5);
//            holder.mainLayout.getLayoutParams().height = (int) ((height - 80) / 4.5f);
//            holder.mainLayout.getLayoutParams().width = ((context.getResources().getDisplayMetrics().widthPixels) / 2) - 50;

            params.height = (int) ((height - 50) / 5f);
            params.width = params.height;
        }
        holder.title.setTextColor(context.getResources().getColor(R.color.colorAccent));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (item.arrayListNews != null && item.arrayListNews.size()>0) {
                    Intent intent = new Intent(context,ListNewsActivity.class);
//                    intent.putExtra("sourcenews",item.title);
//                    intent.putExtra("datanews",item.arrayListNews);
                    intent.putExtra("newsob",item);
                    context.startActivity(intent);
                } else {
                    Toast.makeText(context, "chua co :)", Toast.LENGTH_SHORT).show();
                }

            }
        });
        holder.imageView.setImageResource(item.resource);
        holder.title.setText(item.title);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        CardView mainLayout;
        ImageView imageView;
        FontTextView title;

        ViewHolder(View itemView) {
            super(itemView);
            mainLayout = itemView.findViewById(R.id.main_layout);
            imageView = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.title);
        }
    }

}
