package vn.com.newsviet.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.util.ArrayList;

import vn.com.newsviet.DetailNewsActivity;
import vn.com.newsviet.R;
import vn.com.newsviet.Utils.RoundedCornersTransform;
import vn.com.newsviet.model.News;
import vn.com.newsviet.view.FontTextView;

public class Main1Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<News> data;

    public Main1Adapter(Context context, ArrayList<News> data) {
        this.context = context;
        this.data = data;
    }

    public void setData(ArrayList<News> ob) {
        this.data = ob;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_main1, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        final News item = data.get(position);
        viewHolder.title.setText(item.title);
        viewHolder.source.setText(item.source + " / " + item.categ);
        if (!item.img.isEmpty()) {
            Picasso.with(context).load(item.img).fit().error(R.mipmap.logo1).into(viewHolder.img);
        } else {
            viewHolder.img.setImageResource(R.mipmap.logo1);
        }
        viewHolder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailNewsActivity.class);
                intent.putExtra("link", item.link);
                context.startActivity(intent);
            }
        });
        viewHolder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailNewsActivity.class);
                intent.putExtra("link", item.link);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        FontTextView title, source;

        public ViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            title = itemView.findViewById(R.id.title);
            source = itemView.findViewById(R.id.source);
        }
    }
}
