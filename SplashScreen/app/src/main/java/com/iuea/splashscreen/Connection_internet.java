package com.iuea.splashscreen;

import android.app.Service;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;

public class Connection_internet {
    Context context;

    public Connection_internet(Context context ) {
        this.context=context;
    }
    public boolean isConnected(){
        ConnectivityManager connectivityManager=(ConnectivityManager)
                context.getSystemService(Service.CONNECTIVITY_SERVICE);
        if (connectivityManager!=null){
            NetworkInfo info=connectivityManager.getActiveNetworkInfo();
            if (info!=null) {
                if (info.getState() == NetworkInfo.State.CONNECTED){
                    return true;
                }
            }
        }
        return false;
    }
}
