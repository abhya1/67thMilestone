package com.bml67.android.a67thmilestonebml;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bluejamesbond.text.DocumentView;
import com.bluejamesbond.text.style.TextAlignment;

public class GamingArena extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaming_arena);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DocumentView documentView = new DocumentView(this, DocumentView.PLAIN_TEXT);  // Support plain text
        documentView.getDocumentLayoutParams().setTextAlignment(TextAlignment.JUSTIFIED);


        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);

        FloatingActionButton favorites_fab = (FloatingActionButton) findViewById(R.id.favorites_fab_gaming_arena);
        favorites_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fdhandler fdh = new fdhandler(getApplicationContext(),null,null,1);
                favouritesdatabase fd = new favouritesdatabase("Gaming Arena","2nd March | 1:00 pm","Computer Lab");
                fdh.addfavouriteevent(fd);
                Toast.makeText(getApplicationContext(),"Event added to your Favourites",Toast.LENGTH_LONG).show();
                Intent i = new Intent(getApplicationContext(), MyService.class);
                startService(i);
            }
        });

//        FloatingActionButton location_fab = (FloatingActionButton) findViewById(R.id.location_fab);
//        location_fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Location/Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        ImageView email1 = (ImageView) findViewById(R.id.email1_gaming_arena);
        email1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String[] addresses = {"anand.akshay.15cse@bml.edu.in"};

                String subject = "Fest";
                composeEmail(addresses, subject);

            }
        });

        ImageView call1 = (ImageView) findViewById(R.id.call1_gaming_arena);
        call1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialPhoneNumber("09779139101");
            }
        });

    }




    private void composeEmail(String[] addresses, String subject) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setType("*//*");
        intent.setData(Uri.parse("mailto:"));     //only e-mail apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);


        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void dialPhoneNumber ( String phoneNumber ) {
        Intent intent = new Intent ( Intent.ACTION_DIAL);
        intent . setData ( Uri . parse ( "tel:" + phoneNumber ));
        if ( intent . resolveActivity ( getPackageManager ()) != null) {
            startActivity ( intent );
        }

    }
}
