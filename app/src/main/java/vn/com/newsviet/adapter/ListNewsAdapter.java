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
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;


import java.util.ArrayList;

import vn.com.newsviet.DetailNewsActivity;
import vn.com.newsviet.R;
import vn.com.newsviet.Utils.RoundedCornersTransform;
import vn.com.newsviet.model.News;
import vn.com.newsviet.view.FontTextView;

import static java.security.AccessController.getContext;

public class ListNewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<News> data;

    public ListNewsAdapter(Context context, ArrayList<News> data) {
        this.context = context;
        this.data = data;
    }

    public void setData(ArrayList<News> ob) {
        this.data = ob;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(context).inflate(R.layout.item_list_news, parent, false);
        return new ViewHolder(convertView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final News item = data.get(position);
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.title.setText(item.title);
//        viewHolder.description.setText(item.description_short);
        viewHolder.pubdate.setText(item.pubDate);
//        final Transformation transformation = new MaskTransformation(getContext(), R.drawable.rounded_convers_transformation);
        final Transformation transformation = new RoundedCornersTransform();
        if (!item.img.isEmpty()) {
            Picasso.with(context).load(item.img).fit().transform(transformation).error(R.mipmap.logo1).into(viewHolder.img);
        } else {
            viewHolder.img.setImageResource(R.mipmap.logo1);
        }


        viewHolder.layout_itemlistnews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailNewsActivity.class);
                intent.putExtra("link", item.link);
                context.startActivity(intent);
            }
        });
//        if(item.img.contains("data:image/gif;base64")){
//            byte[] decodedString = Base64.decode("R0lGODlhAQABAAAAACH5BAEKAAEALAAAAAABAAEAAAICTAEAOw==", Base64.DEFAULT);
//            Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
//            viewHolder.img.setImageBitmap(decodedByte);
//        }else {

//        }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        FontTextView title, pubdate, description;
        CardView layout_itemlistnews;

        public ViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            title = itemView.findViewById(R.id.title);
            pubdate = itemView.findViewById(R.id.pubdate);
            description = itemView.findViewById(R.id.description);
            layout_itemlistnews = itemView.findViewById(R.id.layout_itemlistnews);
        }
    }
}
