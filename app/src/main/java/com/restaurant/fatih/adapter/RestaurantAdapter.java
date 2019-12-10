package com.restaurant.fatih.adapter;

import android.content.Context;
import android.media.Image;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.restaurant.fatih.model.RestaurantItem;

import java.util.List;

public class RestaurantAdapter {
    RecyclerView.Adapter<RestaurantAdapter.MyViewHolder>{
        List<RestaurantItem> listItem;
        TextView tvRestaurantName;
        View view;
        ImageView ivRestaurantPhoto;

        private Context ctx;
        private AdapterView.OnItemClickListener mOnItemClickListener;
        public interface OnItemClickListener{
            void OnClick(int position);
        }

        public void setOnItemClickListener(final OnItemClickListener onItemClickListener){
            this.mOnItemClickListener = mItemClickListener;
        }


    }
}
