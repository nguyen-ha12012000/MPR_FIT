package com.a1_1801040071.myfriend.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.a1_1801040071.myfriend.R;
import com.a1_1801040071.myfriend.models.Friends;

import java.util.List;

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.FriendHolder> {

    private List<Friends> friends;

    public FriendAdapter(List<Friends> friends) {
        this.friends = friends;
    }


    @NonNull
    @Override
    public FriendHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View itemView = inflater.inflate(R.layout.item_friend, parent, false);

        return new FriendHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FriendHolder holder, int position) {
        Friends friend = friends.get(position);

        holder.bind(friend);
    }

    @Override
    public int getItemCount() {
        return friends.size();          //trả về được bn item
    }

    public class FriendHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private ImageButton btnSentEmail, btnSentMessage, btnCall;
        private Context context;

        public FriendHolder(@NonNull View itemView, Context context) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            btnSentMessage = itemView.findViewById(R.id.btnSentMessage);
            btnCall = itemView.findViewById(R.id.btnCall);
            btnSentEmail = itemView.findViewById(R.id.btnSentEmail);
        }

        public void bind(Friends friends) {
            tvName.setText(friends.getName());

            //handle of the click events
            btnCall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("Ex1: " + friends.getPhoneNo()));
                    context.startActivity(intent);
                }
            });
        }

    }
}
