package com.a1_1801040071.myfriend;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.a1_1801040071.myfriend.adapters.FriendAdapter;
import com.a1_1801040071.myfriend.models.Friends;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvfriends;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //recycler view
        rvfriends = findViewById(R.id.rvfriends);

        //demo date
        List<Friends> friends = new ArrayList<>();
        friends.add(new Friends("A", "hahvalh;@gmail.com", "75740527-71-r"));
        friends.add(new Friends("B", "hahvalh;@gmail.com", "75740527-71-r"));
        friends.add(new Friends("C", "hahvalh;@gmail.com", "75740527-71-r"));
        friends.add(new Friends("D", "hahvalh;@gmail.com", "75740527-71-r"));
        friends.add(new Friends("E", "hahvalh;@gmail.com", "75740527-71-r"));

        //setup recycler view
        //adapter
        FriendAdapter friendAdapter = new FriendAdapter(friends);
        rvfriends.setAdapter(friendAdapter);
        //layout
        rvfriends.setLayoutManager(new LinearLayoutManager(this));



    }
}