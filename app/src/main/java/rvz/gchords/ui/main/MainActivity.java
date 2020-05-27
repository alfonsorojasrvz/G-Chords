package rvz.gchords.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import rvz.gchords.R;
import rvz.gchords.databinding.MainActivityBinding;


public class MainActivity extends AppCompatActivity {
private MainActivityBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        binding = DataBindingUtil.setContentView(this,R.layout.main_activity);
        binding.setLifecycleOwner(this);
    }
}
