package com.technocupids.libgdx.simplelibgdxanimation.android;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.technocupids.libgdx.simplelibgdxanimation.SimpleLibGDXAnimation;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new SimpleLibGDXAnimation(), config);
	}
}
