package com.chuckdries.xlauncher;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public void onChromeButtonClick(View v) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView chromeIcon = (ImageView) findViewById(R.id.chromeButton);
        chromeIcon.setImageDrawable(getActivityIcon(this,"com.android.chrome", "com.google.android.apps.chrome.Main"));
        chromeIcon.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.android.chrome");
                startActivity(launchIntent);
            }});
    }


    public static Drawable getActivityIcon(Context context, String packageName, String activityName) {
        PackageManager pm = context.getPackageManager();
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(packageName, activityName));
        ResolveInfo resolveInfo = pm.resolveActivity(intent, 0);

        return resolveInfo.loadIcon(pm);
    }
}
