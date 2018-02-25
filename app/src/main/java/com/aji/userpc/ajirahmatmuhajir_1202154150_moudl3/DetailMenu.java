package com.aji.userpc.ajirahmatmuhajir_1202154150_moudl3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class DetailMenu extends AppCompatActivity {

    private int mLevel = 0;
    static final String STATE_LEVEL = "level air";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_menu);

        //melakukan inisiasi pada views
        TextView menuTitle = (TextView)findViewById(R.id.minuman_title);
        ImageView menuImage = (ImageView)findViewById(R.id.menuImages_detail);

        //mengisi views dengan data, dari intent
        menuTitle.setText(getIntent().getStringExtra("title"));
        Glide.with(this).load(getIntent().getIntExtra("image",0))
                .into(menuImage);

        if (savedInstanceState != null) {
            ImageView galon = (ImageView) findViewById(R.id.galon);
            TextView isi_galon = (TextView) findViewById(R.id.isi_galon);

            mLevel = savedInstanceState.getInt(STATE_LEVEL);

            //Set the text views
            isi_galon.setText(String.valueOf(mLevel+"L"));

            galon.setImageLevel(mLevel);

        }
    }

    public void setImageLevel(View view){


        ImageView galon = (ImageView) findViewById(R.id.galon);
        TextView isi_galon = (TextView) findViewById(R.id.isi_galon);
        //Get the ID of the button that was clicked
        int viewID = view.getId();

        switch (viewID){
            //If it was on btnTambah
            case R.id.btnTambah:

                //Increment the score and update the TextView
                if (mLevel < 6) {
                    mLevel++;
                    galon.setImageLevel(mLevel);
                    isi_galon.setText(mLevel+"L");

                }
                else if(mLevel >= 6){
                    galon.setImageLevel(mLevel);
                    Toast toast = Toast.makeText(this, "Air sudah full", Toast.LENGTH_LONG);
                    toast.show();
                }

                break;

            //If it was btnKurang
            case R.id.btnKurang:
                //Increment the score and update the TextView

                if (mLevel > 0) {
                    mLevel--;
                    galon.setImageLevel(mLevel);
                    isi_galon.setText(mLevel+"L");

                }
                else if(mLevel == 0){
                    galon.setImageLevel(mLevel);
                    Toast toast = Toast.makeText(this, "air sedikit", Toast.LENGTH_LONG);
                    toast.show();
                }

        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //Save the scores
        outState.putInt(STATE_LEVEL, mLevel);
        super.onSaveInstanceState(outState);
    }
}
