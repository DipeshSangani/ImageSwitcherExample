package com.example.imageswitcherexample;


import java.io.InputStream;



import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;


public class ImageSwitcherExampleActivity extends Activity {

	
	private Integer images [] = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3};
	private int currImage = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image_switcher_example);
		
		initializeImageSwitcher();
		setInitialImage();
		setImageRotateListener();
		
	}

	private void initializeImageSwitcher() {
		final ImageSwitcher imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);
		imageSwitcher.setFactory(new ViewFactory() {
			@Override
			public View makeView() {
				ImageView imageView = new ImageView(ImageSwitcherExampleActivity.this);
				return imageView;
			}});
		
		imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left));
		imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right));
		
	}

	private void setImageRotateListener() {
		final Button rotatebutton = (Button) findViewById(R.id.btnRotateImage);
		rotatebutton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				currImage++;
				if(currImage == 3) {
					currImage = 0;
				}
				setCurrentImage();
			}
		});
	}

	private void setInitialImage() {
		setCurrentImage();
	}
	
	private void setCurrentImage() {
		final ImageSwitcher imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);
		imageSwitcher.setImageResource(images[currImage]);
	}

	
}
