package android.photoapp.shutter;

import android.content.DialogInterface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HelpdeskActivity extends AppCompatActivity implements View.OnClickListener, TextWatcher
{
    ActionBar actionBar;
    EditText edit_email,edit_query;
    Button btn_submit;
    AlertDialog msg_dialog;
    TextView counter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpdesk);

        setUpUi();
    }

    public void setUpUi()
    {
        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        actionBar.setTitle(getResources().getString(R.string.helpdesk));

        edit_email= (EditText) findViewById(R.id.edit_email);
        edit_query= (EditText) findViewById(R.id.edit_query);
        btn_submit= (Button) findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(this);

        counter=(TextView) findViewById(R.id.txtv_counter);
        edit_query.addTextChangedListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if(v.getId()==R.id.btn_submit)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            SpannableString title = new SpannableString(getResources().getString(R.string.message));
            title.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.app_green)), 0, title.length(), 0);
            builder.setTitle(title);
            builder.setMessage(getResources().getString(R.string.response_recorded));
            builder.setPositiveButton(getResources().getString(R.string.okay), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    msg_dialog.dismiss();
                }
            });
            msg_dialog = builder.create();
            msg_dialog.show();
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count)
    {
        try{
            int length=s.length();
            int remain=500-length;
            counter.setText(""+remain);
        }catch (Exception e)
        {
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}