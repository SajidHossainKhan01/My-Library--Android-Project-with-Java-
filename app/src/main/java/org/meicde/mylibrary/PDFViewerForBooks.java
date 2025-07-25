package org.meicde.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;

public class PDFViewerForBooks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfviewer_for_books);

        PDFView pdfView = findViewById(R.id.pdfViewerForBooks);
        Intent intent = getIntent();
        String pdfName = intent.getExtras().getString("bookId");
        Toast.makeText(this, pdfName, Toast.LENGTH_SHORT).show();
        pdfView.fromAsset(pdfName).load();
    }
}