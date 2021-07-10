package com.example.clipboard;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.ClipData;
        import android.content.ClipboardManager;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button b1,b2;
    EditText t1,t2;
    ClipboardManager myClipboard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=findViewById(R.id.TxtCopy);
        t2=findViewById(R.id.TxtPaste);
        b1=findViewById(R.id.BtnCopy);
        b1.setOnClickListener(this);
        b2=findViewById(R.id.BtnPaste);
        b2.setOnClickListener(this);
        myClipboard= (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
    }
    public void onClick(View v)
    {
        if(v.equals(b1))
        {
            ClipData myClip;
            String data = t1.getText().toString();
            myClip = ClipData.newPlainText("text", data);
            myClipboard.setPrimaryClip(myClip);
            Toast.makeText(getBaseContext(),"Copied..",Toast.LENGTH_LONG).show();
        }

        else if(v.equals(b2))
        {
            ClipData abc = myClipboard.getPrimaryClip();
            ClipData.Item item = abc.getItemAt(0);
            t2.setText(item.getText().toString());
        }
    }
}