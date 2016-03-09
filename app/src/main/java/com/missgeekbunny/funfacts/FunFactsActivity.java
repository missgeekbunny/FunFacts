package com.missgeekbunny.funfacts;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


public class FunFactsActivity extends AppCompatActivity {
	// Declare our View Variables
	public static final String TAG = FunFactsActivity.class.getSimpleName();
	private TextView mFactTextView;
	private Button mShowFactButton;
	private FactBook mFactBook = new FactBook();
	private ColorWheel mColorWheel = new ColorWheel();
	private RelativeLayout mRelativeLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fun_facts);
		CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
						.setDefaultFontPath("fonts/VarelaRound-Regular.ttf")
						.setFontAttrId(R.attr.fontPath)
						.build());

		// Assign the Views from the layout file to the corresponding variables
		mFactTextView = (TextView) findViewById(R.id.factTextView);
		mShowFactButton = (Button) findViewById(R.id.showFactButton);
		mRelativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
		View.OnClickListener listener = new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//Update the screen with our dynamic fact
				String fact = mFactBook.getFact();
				int color = mColorWheel.getColor();
				mFactTextView.setText(fact);
				mRelativeLayout.setBackgroundColor(color);
				mShowFactButton.setTextColor(color);
			}
		};
		mShowFactButton.setOnClickListener(listener);

	}
	@Override
	protected void attachBaseContext(Context newBase) {
		super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
	}
}
