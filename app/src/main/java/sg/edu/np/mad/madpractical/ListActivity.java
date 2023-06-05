package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {
    String title = "List Activity";
    private String RandomNumber(){
        Random random = new Random();
        int randomValue = random.nextInt(100000);
        return Integer.toString(randomValue);
    }
    ArrayList<User> userList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        userList.add(new User("Name" + RandomNumber(), "Description" + RandomNumber(), 1, false));
        userList.add(new User("Name" + RandomNumber(), "Description" + RandomNumber(), 2, false));
        userList.add(new User("Name" + RandomNumber(), "Description" + RandomNumber(), 3, false));
        userList.add(new User("Name" + RandomNumber(), "Description" + RandomNumber(), 4, false));
        userList.add(new User("Name" + RandomNumber(), "Description" + RandomNumber(), 5, false));
        userList.add(new User("Name" + RandomNumber(), "Description" + RandomNumber(), 6, false));
        userList.add(new User("Name" + RandomNumber(), "Description" + RandomNumber(), 7, false));
        userList.add(new User("Name" + RandomNumber(), "Description" + RandomNumber(), 8, false));
        userList.add(new User("Name" + RandomNumber(), "Description" + RandomNumber(), 9, false));
        userList.add(new User("Name" + RandomNumber(), "Description" + RandomNumber(), 10, false));
        userList.add(new User("Name" + RandomNumber(), "Description" + RandomNumber(), 11, false));
        userList.add(new User("Name" + RandomNumber(), "Description" + RandomNumber(), 12, false));
        userList.add(new User("Name" + RandomNumber(), "Description" + RandomNumber(), 13, false));
        userList.add(new User("Name" + RandomNumber(), "Description" + RandomNumber(), 14, false));
        userList.add(new User("Name" + RandomNumber(), "Description" + RandomNumber(), 15, false));
        userList.add(new User("Name" + RandomNumber(), "Description" + RandomNumber(), 16, false));
        userList.add(new User("Name" + RandomNumber(), "Description" + RandomNumber(), 17, false));
        userList.add(new User("Name" + RandomNumber(), "Description" + RandomNumber(), 18, false));
        userList.add(new User("Name" + RandomNumber(), "Description" + RandomNumber(), 19, false));
        userList.add(new User("Name" + RandomNumber(), "Description" + RandomNumber(), 20, false));

        RecyclerView recyclerViewUser = findViewById(R.id.recyclerview);
        UserAdapter mAdapter = new UserAdapter(userList);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(
                getApplicationContext(),
                LinearLayoutManager.VERTICAL,
                false
        );
        LinearLayoutManager sLayoutManager = new LinearLayoutManager(this);
        recyclerViewUser.setLayoutManager(sLayoutManager);
        recyclerViewUser.setItemAnimator(new DefaultItemAnimator());
        recyclerViewUser.setAdapter(mAdapter);
    }
}