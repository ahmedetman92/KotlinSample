package com.etisalat.sampletask.views

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.etisalat.sampletask.R
import kotlinx.android.synthetic.main.activity_camera.*
import java.util.jar.Manifest
import com.bumptech.glide.Glide
import java.io.ByteArrayOutputStream


class CameraActivity : AppCompatActivity() {

    val CAMERA_REQUEST_CODE = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)

        btn_capture.setOnClickListener() {
            val callCameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (callCameraIntent.resolveActivity(packageManager) != null) {
                var permissionCheck = ContextCompat.checkSelfPermission(this,
                        android.Manifest.permission.CAMERA)
                if(permissionCheck != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(this,
                            arrayOf<String>(android.Manifest.permission.CAMERA),10)
                }else {
                    startActivityForResult(callCameraIntent, CAMERA_REQUEST_CODE);
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            CAMERA_REQUEST_CODE -> {
                if( data != null){

                    var img = data.extras.get("data") as Bitmap
                    val stream = ByteArrayOutputStream()
                    img.compress(Bitmap.CompressFormat.PNG, 100, stream)
                    Glide.with(this)
                            .load(stream.toByteArray())
                            .asBitmap()
                            .into(img_thumbnail)

                   // img_thumbnail.setImageBitmap(img)
                }
            }
            else -> {
                Toast.makeText(this, "Undefined request",  Toast.LENGTH_LONG).show()
            }
        }
    }
}
