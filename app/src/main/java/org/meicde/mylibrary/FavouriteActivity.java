package org.meicde.mylibrary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class FavouriteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);

        RecyclerView recyclerView = findViewById(R.id.bookRecViewFavouriteBook);
        if (Utils.getInstance(this).getFavoriteBooks().size() !=0){
            BookRecViewAdapter adapter = new BookRecViewAdapter(this, "favouriteBook");
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            adapter.setBooks(Utils.getInstance(this).getFavoriteBooks());
        }else{
            AlertDialog.Builder builder = new AlertDialog.Builder(FavouriteActivity.this);
            builder.setTitle(getString(R.string.app_name));
            builder.setMessage("You have no favorite books!");
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