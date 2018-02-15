package android.photoapp.shutter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

EditText Email_id,Password;
    Button Signup,Login,Login_with_google,Login_with_fb,Skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Email_id=(EditText)findViewById(R.id.EtEmailid);
        Password=(EditText)findViewById(R.id.EtPassword);
        Signup=(Button)findViewById(R.id.BtnSignup);
        Login=(Button)findViewById(R.id.BtnLogin);
        Login_with_google=(Button)findViewById(R.id.BtnLoginwithgoogle);
        Login_with_fb=(Button)findViewById(R.id.BtnLoginwithFacebook);
        Skip=(Button)findViewById(R.id.BtnSkip);
        Signup.setOnClickListener(this);
        Login.setOnClickListener(this);
        Login_with_google.setOnClickListener(this);
        Login_with_fb.setOnClickListener(this);
        Skip.setOnClickListener(this);


    }

@Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.BtnSignup:
                break;
            case R.id.BtnLogin:
                break;
            case R.id.BtnLoginwithgoogle:
                break;
            case R.id.BtnLoginwithFacebook:
                break;
            case R.id.BtnSkip:
                break;
        }
}
