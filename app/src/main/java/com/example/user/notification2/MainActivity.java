package com.example.user.notification2;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
import android.view.View;
//import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {

        @Override protected void onCreate(Bundle icicle) {
            super.onCreate(icicle);

            final Button button = new Button(this);
            button.setText("button");
            button.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    if (v.getId() == R.id.button)
                        sendNotification(); // クリック時の処理
                }
            });

            setContentView(button);
        }




    private void sendNotification() {
        Notification n = new Notification(); // Notificationの生成
        n.iconLevel= R.drawable.coda; // アイコンの設定
        n.tickerText = "This is a notification message..."; // メッセージの設定

        Intent i = new Intent(getApplicationContext(), NotificationActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, i, 0);
        n.setLatestEventInfo(getApplicationContext(), "TITLE", "TEXT", pi);

        /*long[] vibrate_ptn = {0, 100, 300, 1000}; // 独自バイブレーションパターン
        n.vibrate = vibrate_ptn; // 独自バイブレーションパターンを設定

        n.defaults |= Notification.DEFAULT_LIGHTS; // デフォルトLED点滅パターンを設定*/

        // NotificationManagerのインスタンス取得
        NotificationManager nm =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(1, n); // 設定したNotificationを通知する
    }
}
