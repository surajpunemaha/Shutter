package android.photoapp.shutter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener
{
    LinearLayout layout_signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setUpUi();
    }

    public void setUpUi()
    {
        layout_signUp = (LinearLayout) findViewById(R.id.layout_signUp);
        layout_signUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.layout_signUp :
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
                break;
        }
    }
}