package info.javaway.testpermissions;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by максим on 19.04.2017.
 */

public class BroadcastTest extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Alarm", Toast.LENGTH_LONG).show();
        Log.wtf("info.javaway.android.testpermissions", "testpermissions");

    }
}
