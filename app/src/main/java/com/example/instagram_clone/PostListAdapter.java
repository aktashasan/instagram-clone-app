package com.example.instagram_clone;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instagram_clone.data.PostItemData;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PostListAdapter extends RecyclerView.Adapter<PostListAdapter.ViewHolder> {

    private List<PostItemData> postList;

    public PostListAdapter(List<PostItemData> list) {
        this.postList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View listItem = inflater.inflate(R.layout.item_news, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final PostItemData item = postList.get(position);
        holder.tvCommentCount.setText("View all" + item.getCommentCount() + "comments");
        holder.tvLikeCount.setText(item.getLikeCount() + "likes");
        holder.tvDesc.setText(item.getUserName() + " " + item.getDescription());
        holder.tvUserName.setText(item.getUserName());
        Picasso.with(holder.itemView.getContext()).load(item.getProfileImage()).into(holder.ivProfile);
        Picasso.with(holder.itemView.getContext()).load(item.getPostImage()).into(holder.ivPost);
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivProfile;
        public ImageView ivPost;
        public TextView tvUserName;
        public TextView tvLikeCount;
        public TextView tvDesc;
        public TextView tvCommentCount;

        public ViewHolder(View itemView) {
            super(itemView);
            this.ivProfile = (ImageView) itemView.findViewById(R.id.ivProfile);
            this.ivPost = (ImageView) itemView.findViewById(R.id.ivImage);
            this.tvUserName = (TextView) itemView.findViewById(R.id.tvUserName);
            this.tvLikeCount = (TextView) itemView.findViewById(R.id.tvLikeCount);
            this.tvDesc = (TextView) itemView.findViewById(R.id.tvContentDesc);
            this.tvCommentCount = (TextView) itemView.findViewById(R.id.tvCommentCount);
        }
    }

}
