package com.christiankula.users.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.christiankula.users.R;
import com.christiankula.users.rest.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private List<User> data;

    public UserAdapter(ArrayList<User> data) {
        this.data = data;
    }

    /**
     * Sets the dataSet for this adapter and notify that the data set has changed
     */
    public void setData(List<User> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_user, parent, false);

        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        final User user = data.get(position);

        holder.tvFirstName.setText(user.getName().getFirst());
        holder.tvLastName.setText(user.getName().getLast());

        holder.tvEmail.setText(user.getEmail());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class UserViewHolder extends RecyclerView.ViewHolder {
        TextView tvFirstName;
        TextView tvLastName;

        TextView tvEmail;

        UserViewHolder(View itemView) {
            super(itemView);

            tvFirstName = itemView.findViewById(R.id.tv_list_item_user_first_name);
            tvLastName = itemView.findViewById(R.id.tv_list_item_user_last_name);
            tvEmail = itemView.findViewById(R.id.tv_list_item_user_email);
        }
    }
}
