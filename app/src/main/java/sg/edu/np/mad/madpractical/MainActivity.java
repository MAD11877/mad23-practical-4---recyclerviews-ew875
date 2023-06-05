package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    final String TITLE = "Main Activity";
    User u = new User("MAD", "Description", 00, false);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TITLE, "Create!");
        User myUser =  new User();
        myUser.setFollowed(false);
        TextView change = findViewById(R.id.helloworld);
        change.setText("MAD " + getRandomNumber());
        Button message = (Button) findViewById(R.id.button);
        message.setOnClickListener(view -> {
            Intent messager = new Intent (MainActivity.this, MessageGroup.class);
            startActivity(messager);}
                );

        Button myfollowbutton = findViewById(R.id.button2);
        myfollowbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean bool = myUser.isFollowed();
                bool = !bool;
                myUser.setFollowed(bool);
                Log.v(TITLE, "on Destroy....");
                if (myUser.isFollowed() == Boolean.FALSE)
                {
                    myfollowbutton.setText("Follow");
                    Toast.makeText(getApplicationContext(),"Followed",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    myfollowbutton.setText("Unfollow");
                    Toast.makeText(getApplicationContext(),"Unfollowed",Toast.LENGTH_SHORT).show();
                }

                Log.v(TITLE, "on Destroy....");
            }
        });
    }
    private int getRandomNumber(){
        Random random = new Random();
        int randomValue = random.nextInt(100000);
        return randomValue;
    }
}