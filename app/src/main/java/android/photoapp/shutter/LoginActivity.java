package android.photoapp.shutter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener
{
    TextView txtv_skip;
    Button btn_signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setUpUi();
    }

    public void setUpUi()
    {
        txtv_skip = (TextView) findViewById(R.id.txtv_skip);
        txtv_skip.setOnClickListener(this);

        btn_signUp = (Button) findViewById(R.id.btn_signUp);
        btn_signUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.txtv_skip :
                Intent helpdesk = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(helpdesk);
                break;
            case R.id.btn_signUp :
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
                break;
        }
    }
}