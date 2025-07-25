package org.meicde.mylibrary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

public class CurrentlyReadingBookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currently_reading_book);

        RecyclerView recyclerView = findViewById(R.id.bookRecViewCurrentlyReadingBook);

        if (Utils.getInstance(this).getCurrentlyReadingBooks().size() !=0){
            BookRecViewAdapter adapter = new BookRecViewAdapter(this, "currentlyReading");
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            adapter.setBooks(Utils.getInstance(this).getCurrentlyReadingBooks());
        }else{
            AlertDialog.Builder builder = new AlertDialog.Builder(CurrentlyReadingBookActivity.this);
            builder.setTitle(getString(R.string.app_name));
            builder.setMessage("You aren't reading any book!");
            builder.setNegativeButton("Go back", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    onBackPressed();
                }
            });
            builder.setCancelable(false);
            builder.create().show();
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}