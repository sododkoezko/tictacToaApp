package org.codeforiraq.youcefdonneur;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import org.codeforiraq.youcefdonneur.R;

public class PushNotificationService extends FirebaseMessagingService {
    /**
     * Called when a message is received.
     *
     * <p>This is also called when a notification message is received while the app is in the
     * foreground. The notification parameters can be retrieved with {@link
     * RemoteMessage#getNotification()}.
     *
     * @param message Remote message that has been received.
     */
    @SuppressLint({"NewApi", "MissingPermission"})
    @Override
    public void onMessageReceived(@NonNull RemoteMessage message) {
        String title=message.getNotification().getTitle();
        String text=message.getNotification().getBody();
        final String CHANNEL_ID="HEADS_UP_NOTIFICATION";
        @SuppressLint({"NewApi", "LocalSuppress"}) NotificationChannel channel=new NotificationChannel(CHANNEL_ID,"Heads Up Notification"
                , NotificationManager.IMPORTANCE_HIGH);
        getSystemService(NotificationManager.class).createNotificationChannel(channel);
        Notification.Builder notification=new Notification.Builder(this,CHANNEL_ID).
                setContentTitle(title).setContentText(text).setSmallIcon(R.drawable.ic_launcher_background).
                setAutoCancel(true);
        NotificationManagerCompat.from(this).notify(1,notification.build());
        super.onMessageReceived(message);
    }
}
