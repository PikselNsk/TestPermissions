package info.javaway.testpermissions;

import android.Manifest;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "info.javaway.testpermissions";
    private static final int REQUEST_CODE = 1132;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int permissionCheck = ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA);
        if(permissionCheck == PackageManager.PERMISSION_GRANTED){
            permOk();
        } else {
            permCan();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                shouldShowRequestPermissionRationale(Manifest.permission.CAMERA);
                requestPermissions(new String[]{Manifest.permission.CAMERA}, REQUEST_CODE);
                Toast.makeText(this, "require", Toast.LENGTH_SHORT).show();
            }
        }

        ComponentName receiver = new ComponentName(this, BroadcastTest.class);
        PackageManager pm = this.getPackageManager();

        pm.setComponentEnabledSetting(receiver,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP);
    }

    private void permOk() {
        Log.wtf(TAG, "Разрешено");
    }
    private void permCan() {
        Log.wtf(TAG, "Запрещено");
    }


}
