package smu.ai.waiting;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MyGridView extends BaseAdapter {
    Context context;
    Integer[] orderID = {R.drawable.food, R.drawable.tiss};
    Integer[] orderTitle = {R.string.c1, R.string.c2};
    ImageView imageView;

    public MyGridView(Context c) {
        context = c;
    }

    public int getCount() {
        return orderID.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        imageView = new ImageView(context);
        imageView.setLayoutParams(new GridView.LayoutParams(400, 650));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setPadding(5, 5, 10, 10);
        imageView.setImageResource(orderID[position]);

        final int pos = position;
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pos == 0) {
                    Intent intent = new Intent(context, OrderKitchen.class);
                    context.startActivity(intent);
                }
                else if (pos == 1){
                    Intent intent = new Intent(context, OrderHall.class);
                    context.startActivity(intent);
                }
            }
        });

        return imageView;
    }
}