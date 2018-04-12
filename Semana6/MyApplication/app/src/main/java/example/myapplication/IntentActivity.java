package example.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

import static example.myapplication.Constants.OPEN_CAMERA_CODE;

/**
 * Created by david on 11/9/16.
 */

public class IntentActivity extends AppCompatActivity implements View.OnClickListener {


    private ImageView mImageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();


        Contact myContact = intent.getParcelableExtra("extra");


        if (Intent.ACTION_SEND.equalsIgnoreCase(action) && type != null) {
            obtainImage(intent);
        }


        setContentView(R.layout.intent_layout);
        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        mImageView = (ImageView) findViewById(R.id.image1);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                openCameraIntent();
                break;
            case R.id.button2:
                openEmailComposer();
                break;
        }
    }


    private void obtainImage(Intent intent) {
        String url = intent.getStringExtra(Intent.EXTRA_TEXT);
        if (url != null) {
            Toast.makeText(this, url, Toast.LENGTH_SHORT).show();
        }
    }


    private void openEmailComposer() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("message/rfc822");
        intent.putExtra(Intent.EXTRA_EMAIL, "daveligu@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "test subject");
        intent.putExtra(Intent.EXTRA_TEXT, "this is the email content");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    private void openCameraIntent() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File f = getPictureFile();
        Uri contentUri = Uri.fromFile(f);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, contentUri);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, OPEN_CAMERA_CODE);
        }
    }


    private File getPictureFile() {
        return new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), "my_picture.jpg");
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == OPEN_CAMERA_CODE && resultCode == RESULT_OK) {

            /*Bundle bundle = data.getExtras();
            Bitmap image = (Bitmap) bundle.getParcelable("data");

            mImageView.setImageBitmap(image);*/


            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setDataAndType(Uri.parse("file://" + getPictureFile().getAbsolutePath()), "image/*");
            startActivity(intent);

        }
    }

}
