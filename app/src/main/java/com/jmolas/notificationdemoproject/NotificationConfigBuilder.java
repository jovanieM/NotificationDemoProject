package com.jmolas.notificationdemoproject;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

/**
 * Created by jmolas on 12/15/2017.
 */

class NotificationConfigBuilder {

    private int smallIcon;
    private long[] vibratePattern;
    private boolean autoCancel = false;
    private String tickerText;
    private String contentTitle;
    private String contentText;
    private long when;
    private Context context;
    private static final int UNIQUE_ID = 123455;

    NotificationConfigBuilder(Context context){
        this.context = context;
    }

    void triggerConfiguredNotification(NotificationManager notificationManager, PendingIntent pendingIntent) {

        NotificationCompat.Builder ncb = new NotificationCompat.Builder(context, "ad")
                .setSmallIcon(getSmallIcon())
                .setTicker(getTickerText())
                .setAutoCancel(isAutoCancel())
                .setWhen(getWhen())
                .setVibrate(getVibratePattern())
                .setContentTitle(contentTitle)
                .setContentText(contentText)
                .setContentIntent(pendingIntent);

        if(notificationManager != null)
            notificationManager.notify(UNIQUE_ID, ncb.build());
    }

    private int getSmallIcon() {
        if (smallIcon == -1) return 0;
        return smallIcon;
    }

    void setSmallIcon(int smallIcon) {
        this.smallIcon = smallIcon;
    }

    private long[] getVibratePattern() {
        return vibratePattern;
    }

    void setVibratePattern(long[] vibratePattern) {
        this.vibratePattern = vibratePattern;
    }

    private boolean isAutoCancel() {
        return autoCancel;
    }

    void setAutoCancel(boolean autoCancel) {
        this.autoCancel = autoCancel;
    }

    private String getTickerText() {
        return tickerText == null ? "default ticker text" : tickerText;
    }

    void setTickerText(String tickerText) {
        this.tickerText = tickerText;
    }


    void setContentTitle(String contentTitle) {
        this.contentTitle = contentTitle;
    }


    void setContentText(String contentText) {
        this.contentText = contentText;
    }

    private long getWhen() {
        return when;
    }

    void setWhen(long when) {
        this.when = when;
    }

}
