package matc89.exercicio2;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class OutraActivity extends AppCompatActivity {
    private EditText editText;
    private Button btnConfirmar;
    private Button btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outra);

        editText = (EditText) findViewById(R.id.editText);
        btnConfirmar =(Button) findViewById(R.id.btnConfirmar);
        btnCancelar = (Button) findViewById(R.id.btnCancelar);

        Bundle extras = getIntent().getExtras();

        if(extras != null){
            String user = extras.get("user").toString();
            editText.setText(user);
        }

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newUser = editText.getText().toString();

                Intent data = new Intent();
                data.putExtra("newUser", newUser);
                setResult(RESULT_OK, data);

                finish();
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("user", editText.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String user = savedInstanceState.getString("user");
        editText.setText(user);
    }
}
