package com.lany.cropper.sample;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class ResultActivity extends AppCompatActivity {
    static Bitmap mImage;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_result);

        imageView = findViewById(R.id.resultImageView);
        imageView.setBackgroundResource(R.drawable.backdrop);

        Intent intent = getIntent();
        if (mImage != null) {
            imageView.setImageBitmap(mImage);
            int sampleSize = intent.getIntExtra("SAMPLE_SIZE", 1);
            double ratio = ((int) (10 * mImage.getWidth() / (double) mImage.getHeight())) / 10d;
            int byteCount = mImage.getByteCount() / 1024;
            String desc =
                    "("
                            + mImage.getWidth()
                            + ", "
                            + mImage.getHeight()
                            + "), Sample: "
                            + sampleSize
                            + ", Ratio: "
                            + ratio
                            + ", Bytes: "
                            + byteCount
                            + "K";
            ((TextView) findViewById(R.id.resultImageText)).setText(desc);
        } else {
            Uri imageUri = intent.getParcelableExtra("URI");
            if (imageUri != null) {
                imageView.setImageURI(imageUri);
            } else {
                Toast.makeText(this, "No image is set to show", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onBackPressed() {
        releaseBitmap();
        super.onBackPressed();
    }

    public void onImageViewClicked(View view) {
        releaseBitmap();
        finish();
    }

    private void releaseBitmap() {
        if (mImage != null) {
            mImage.recycle();
            mImage = null;
        }
    }
}
