package com.example.resourcesdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLayout = findViewById(R.id.mLayout);

        mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLayout.setBackgroundColor(Color.WHITE);

            }
        });

    }
    public void btnBoxShowNormal(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.box_massage));
        builder.setTitle(getResources().getString(R.string.box_title));
        builder.setCancelable(false);
        builder.setNegativeButton(getResources().getString(R.string.box_cancel), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.setPositiveButton(getResources().getString(R.string.box_sure), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), R.string.box_log_out_success,
                        Toast.LENGTH_LONG).show();

            }
        });

        AlertDialog alert = builder.create();
        alert.show();

    }


    public void btnCostumeBoxShow(View view) {

        String[] items = new String[]{"Item 1", "Item 2", "Item 3"};

        MaterialAlertDialogBuilder dialogBuilder = new MaterialAlertDialogBuilder(MainActivity.this);

        dialogBuilder.setTitle("My Title");

        dialogBuilder.setItems(items, (dialogInterface, i) -> {
            Toast.makeText(this, "Select "+items[i], Toast.LENGTH_SHORT).show();
        });

        dialogBuilder.show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater()
                .inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        switch (id)
        {

            case R.id.miRed:

                mLayout.setBackgroundColor(Color.RED);

                break;


            case R.id.miGreen:

                mLayout.setBackgroundColor(Color.GREEN);

                break;

            case R.id.miBlue:

                mLayout.setBackgroundColor(Color.BLUE);

                break;

        }


        return super.onOptionsItemSelected(item);
    }

}