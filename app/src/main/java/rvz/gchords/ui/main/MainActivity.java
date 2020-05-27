package rvz.gchords.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import rvz.gchords.R;
import rvz.gchords.databinding.MainActivityBinding;


public class MainActivity extends AppCompatActivity {
private MainActivityBinding binding;
private ViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        binding = DataBindingUtil.setContentView(this,R.layout.main_activity);
        binding.setLifecycleOwner(this);
        viewModel = new ViewModelProvider(this).get(ViewModel.class);
    }
}
