package org.meicde.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {

    public static final String BOOK_ID_KEY = "bookId";

    private TextView txtBookName, txtAuthor, txtPages, txtDescription;
    private Button btnAddToWantToRead, btnAddAlreadyRead, btnAddToCurrentlyReading, btnAddToFavourite, btnOpenBook;
    private ImageView bookImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        initView();

//        String longDescription = "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc. Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
//
//        //TODO: Get the data from recycler view in here
//        Book book = new Book(2,"ELECTRICAL ENGINEERS","Alexandar",1350,"https://images.interestingengineering.com/img/iea/V0OyLWZ2wQ/51exflyfrol-sx384-bo1204203200.jpg",
//                "A great book on electrical engineering should be easy to understand, cover a broad variety of topics, and include practical and theoretical applications. ", longDescription);

        Intent intent = getIntent();
        if (null != intent){
            int bookId = intent.getIntExtra(BOOK_ID_KEY, -1);
            if (bookId != -1){
                Book incomingBook = Utils.getInstance(this).getBookById(bookId);
                if (null != incomingBook){
                    setData(incomingBook);

                    handleAllReadyRead(incomingBook);
                    handleWantToReadBooks(incomingBook);
                    handleCurrentlyReadingBooks(incomingBook);
                    handleFavouriteBooks(incomingBook);
                    handleOpenBook(incomingBook);
                }
            }
        }
    }

    private void handleOpenBook(final Book book){
        btnOpenBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (book.getPdfName() != null){
                    Intent intent = new Intent(BookActivity.this, PDFViewerForBooks.class);
                    intent.putExtra(BOOK_ID_KEY, book.getPdfName());
                    startActivity(intent);

                    Toast.makeText(BookActivity.this, book.getName(), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(BookActivity.this, "Not Available Yet!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void handleFavouriteBooks(final Book book) {
        ArrayList<Book> favouriteBooks = Utils.getInstance(this).getFavoriteBooks();

        boolean existInFavouriteBooks = false;

        for (Book b: favouriteBooks){
            if (b.getId() == book.getId()){
                existInFavouriteBooks = true;
            }
        }
        if (existInFavouriteBooks){
            btnAddToFavourite.setEnabled(false);
        }else{
            btnAddToFavourite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Utils.getInstance(BookActivity.this).addToFavourite(book)){
                        Toast.makeText(BookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(BookActivity.this, FavouriteActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(BookActivity.this, "Something wrong, try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handleCurrentlyReadingBooks(final Book book) {
        ArrayList<Book> currentlyReadingBooks = Utils.getInstance(this).getCurrentlyReadingBooks();

        boolean existInCurrentlyReadingBooks = false;

        for (Book b: currentlyReadingBooks){
            if (b.getId() == book.getId()){
                existInCurrentlyReadingBooks = true;
            }
        }
        if (existInCurrentlyReadingBooks){
            btnAddToCurrentlyReading.setEnabled(false);
        }else{
            btnAddToCurrentlyReading.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Utils.getInstance(BookActivity.this).addToCurrentlyReadingBook(book)){
                        Toast.makeText(BookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(BookActivity.this, CurrentlyReadingBookActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(BookActivity.this, "Something wrong, try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handleWantToReadBooks(final Book book) {
        ArrayList<Book> wantToReadBooks = Utils.getInstance(this).getWantToReadBooks();

        boolean existInWantToReadBooks = false;

        for (Book b: wantToReadBooks){
            if (b.getId() == book.getId()){
                existInWantToReadBooks = true;
            }
        }
        if (existInWantToReadBooks){
            btnAddToWantToRead.setEnabled(false);
        }else{
            btnAddToWantToRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Utils.getInstance(BookActivity.this).addWantToRead(book)){
                        Toast.makeText(BookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(BookActivity.this, WantToReadActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(BookActivity.this, "Something wrong, try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handleAllReadyRead(final Book book){
        ArrayList<Book> alreadyReadBooks = Utils.getInstance(this).getAlreadyReadBooks();

        boolean existInAlreadyReadBooks = false;

        for (Book b: alreadyReadBooks){
            if (b.getId() == book.getId()){
                existInAlreadyReadBooks = true;
            }
        }
        if (existInAlreadyReadBooks){
            btnAddAlreadyRead.setEnabled(false);
        }else{
            btnAddAlreadyRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Utils.getInstance(BookActivity.this).addToAlreadyRead(book)){
                        Toast.makeText(BookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(BookActivity.this, AlreadyReadBookActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(BookActivity.this, "Something wrong, try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void setData(Book book){
        txtBookName.setText(book.getName());
        txtAuthor.setText(book.getAuthor());
        txtPages.setText(String.valueOf(book.getPages()));
        txtDescription.setText(book.getLongDesc());
        Glide.with(this)
                .asBitmap()
                .load(book.getImageUrl())
                .into(bookImage);
    }

    private void initView(){
        txtAuthor = findViewById(R.id.textAuthorName);
        txtBookName = findViewById(R.id.textBookName);
        txtPages = findViewById(R.id.textPages);
        txtDescription = findViewById(R.id.txtDescription);

        btnAddAlreadyRead = findViewById(R.id.btnAddAlreadyRead);
        btnAddToCurrentlyReading = findViewById(R.id.btnAddToCurrentlyReading);
        btnAddToFavourite = findViewById(R.id.btnAddToFavourite);
        btnAddToWantToRead = findViewById(R.id.btnAddToWantToRead);
        btnOpenBook = findViewById(R.id.btnOpenBook);

        bookImage = findViewById(R.id.imageBook);
    }
}