package com.example.testandoqrcode;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class MainActivity extends AppCompatActivity {
    EditText edit;
    Button btn;
    ImageView img_code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit = findViewById(R.id.edit);
        btn = findViewById(R.id.btn);
        img_code = findViewById(R.id.img_code);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                gerarQR_code();

            }
        });

    }


    private void gerarQR_code() {
        String tx_edit = String.valueOf(edit.getText().toString());
        MultiFormatWriter formatWriter = new MultiFormatWriter();


        try {

            BitMatrix bitMatrix = formatWriter.encode(tx_edit, BarcodeFormat.AZTEC.QR_CODE,300,300);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            img_code.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
            ;

        }
    }

}