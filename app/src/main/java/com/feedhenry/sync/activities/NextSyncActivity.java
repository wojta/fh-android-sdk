package com.feedhenry.sync.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import com.feedhenry.sdk.android.FHSyncService;
import com.feedhenry.sdk.android.FHSyncServiceConnection;
import com.feedhenry.sdk.sync.FHSyncListener;
import com.feedhenry.sdk.sync.NotificationMessage;
import com.feedhenry.sync.R;

public class NextSyncActivity extends AppCompatActivity {

    private static final String TAG = "NextSyncActivity";
    private FHSyncServiceConnection serviceConnection;
    TextView tvText;
    private FHSyncListener syncListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        setSupportActionBar(findViewById(R.id.toolbar));
        tvText = findViewById(R.id.tvText);
        //binding of the service
        serviceConnection = FHSyncService.bindService(this, syncService -> {
            Log.d(TAG, "activity connected to service ");
            syncListener = new FHSyncListener() {
                @Override
                public void onSyncStarted(NotificationMessage message) {
                    println("onSyncStarted:" + message.getDataId() + ":" + message.getMessage());
                }

                @Override
                public void onSyncCompleted(NotificationMessage message) {
                    println("onSyncCompleted:" + message.getDataId() + ":" + message.getMessage());
                }

                @Override
                public void onUpdateOffline(NotificationMessage message) {
                    println("onUpdateOffline:" + message.getDataId() + ":" + message.getMessage());
                }

                @Override
                public void onCollisionDetected(NotificationMessage message) {

                }

                @Override
                public void onRemoteUpdateFailed(NotificationMessage message) {
                    println("onRemoteUpdateFailed:" + message.getDataId() + ":" + message.getMessage());
                }

                @Override
                public void onRemoteUpdateApplied(NotificationMessage message) {
                    println("onRemoteUpdateApplied:" + message.getDataId() + ":" + message.getMessage());
                }

                @Override
                public void onLocalUpdateApplied(NotificationMessage message) {
                    println("onLocalUpdateApplied:" + message.getDataId() + ":" + message.getMessage());
                }

                @Override
                public void onDeltaReceived(NotificationMessage message) {
                    println("onDeltaReceived:" + message.getDataId() + ":" + message.getMessage());
                }

                @Override
                public void onSyncFailed(NotificationMessage message) {
                    println("onSyncFailed:" + message.getDataId() + ":" + message.getMessage());
                }

                @Override
                public void onClientStorageFailed(NotificationMessage message) {
                    println("onClientStorageFailed:" + message.getDataId() + ":" + message.getMessage());
                }
            };
            serviceConnection.call(obj -> obj.registerListener(syncListener));
        });
    }

    @Override
    protected void onDestroy() {
        serviceConnection.unbindAndUnregister(syncListener);
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnuSecond:
                startActivity(new Intent(this, NextSyncActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("SetTextI18n")
    private void println(String s) {
        tvText.setText(tvText.getText().toString() + s + "\n");
    }
}
