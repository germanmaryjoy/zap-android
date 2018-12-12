package ln_zap.zap;

import androidx.fragment.app.Fragment;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;

import androidx.fragment.app.FragmentTransaction;
import ln_zap.zap.Fragments.History;
import ln_zap.zap.Fragments.Settings;
import ln_zap.zap.Fragments.Wallet;

public class MainActivity extends AppCompatActivity {

    private Fragment currentFragment = null;
    private FragmentTransaction ft;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_wallet:
                    // Display the fragment as the main content.
                    ft = getSupportFragmentManager().beginTransaction();
                    currentFragment = new Wallet();
                    ft.replace(R.id.content, currentFragment);
                    ft.commit();
                    return true;
                case R.id.navigation_history:
                    // Display the fragment as the main content.
                    ft = getSupportFragmentManager().beginTransaction();
                    currentFragment = new History();
                    ft.replace(R.id.content, currentFragment);
                    ft.commit();
                    return true;
                case R.id.navigation_settings:
                    // Display the fragment as the main content.
                    ft = getSupportFragmentManager().beginTransaction();
                    currentFragment = new Settings();
                    ft.replace(R.id.content, currentFragment);
                    ft.commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ft = getSupportFragmentManager().beginTransaction();
        currentFragment = new Wallet();
        ft.replace(R.id.content, currentFragment);
        ft.commit();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
