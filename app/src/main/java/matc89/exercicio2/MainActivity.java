package matc89.exercicio2;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private String user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);

        user = "";
    }

    public void changeUser(View view){
        Intent intent = new Intent(this, OutraActivity.class);

        if(!user.equals("")) {
            intent.putExtra("user", user);
        }

        startActivityForResult(intent, 0000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 0000 && resultCode == RESULT_OK){
            user = data.getStringExtra("newUser");

            if(!user.equals("")){
                textView.setText("Oi, " + user + "!");
            }else{
                textView.setText("Oi!");
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("user", user);
        outState.putString("greeting", textView.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        user = savedInstanceState.getString("user");
        String greeting = savedInstanceState.getString("greeting");
        textView.setText(greeting);
    }
}
