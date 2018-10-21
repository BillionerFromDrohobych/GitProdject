package misterpanchak.com.ostapuchi;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SightActivity extends AppCompatActivity implements View.OnClickListener{
TextView textView;
ImageView imgview;
ImageButton imageButton;
Intent intent1;
TextView tx3;

    String geo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sight);
        Intent intent = getIntent();
        String name = intent.getExtras().getString("name");
        String adress = intent.getExtras().getString("adress");
        int imgurl = intent.getExtras().getInt("imgurl");

       geo = intent.getExtras().getString("location");
        imgview = (ImageView) findViewById(R.id.imageView2);
        textView = (TextView) findViewById(R.id.textView);
        imageButton = (ImageButton)  findViewById(R.id.imageButton);
        tx3 = (TextView) findViewById(R.id.textView3);
        textView.setText(name);
        imgview.setImageResource(imgurl);
        tx3.setText(adress);
        imageButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.imageButton:
                intent1 = new Intent();
                intent1.setAction(Intent.ACTION_VIEW);
                intent1.setData(Uri.parse(geo));
                startActivity(intent1);
                break;
        }
    }
}
