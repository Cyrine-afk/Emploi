package com.example.emploi.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.emploi.R;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder>{
    private String[] menuItems;
    private LayoutInflater inflater;
    private OnMenuItemClickListener clickListener;

    public MenuAdapter(Context context, String[] menuItems) {
        this.inflater = LayoutInflater.from(context);
        this.menuItems = menuItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_menu, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String menuItem = menuItems[position];
        holder.menuItemTextView.setText(menuItem);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickListener != null) {
                    clickListener.onMenuItemClick(holder.getAdapterPosition());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return menuItems.length;
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener listener) {
        this.clickListener = listener;
    }

    public interface OnMenuItemClickListener {
        void onMenuItemClick(int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView menuItemTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            menuItemTextView = itemView.findViewById(R.id.menuItemTextView);
        }
    }
}
