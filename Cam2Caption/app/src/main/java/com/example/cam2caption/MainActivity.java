package com.example.cam2caption;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.os.Bundle;
import android.provider.MediaStore;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.microsoft.projectoxford.vision.VisionServiceClient;
import com.microsoft.projectoxford.vision.VisionServiceRestClient;

public class MainActivity extends AppCompatActivity {

    TextView caption;
    ImageView imageView;
    Button picture;
    Button analyze;

    //danno problemi


    //Declare Vision Client
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        caption = findViewById(R.id.result);
        imageView = findViewById(R.id.imageView);
        picture = findViewById(R.id.button);
        analyze = findViewById(R.id.buttonAnalyze);

        picture.setOnClickListener(view -> {
            // Launch camera if we have permission
            if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                someActivityResultLauncher.launch(cameraIntent);
            } else {
                //Request camera permission if we don't have it.
                requestPermissions(new String[]{Manifest.permission.CAMERA}, 100);
            }
        });
    }
        private final ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            // There are no request codes
                            Intent data = result.getData();
                            Bitmap image = (Bitmap) data.getExtras().get("data");
                            int dimension = Math.min(image.getWidth(), image.getHeight());
                            image = ThumbnailUtils.extractThumbnail(image, dimension, dimension);
                            imageView.setImageBitmap(image);

                        }
                    }
                });

    }