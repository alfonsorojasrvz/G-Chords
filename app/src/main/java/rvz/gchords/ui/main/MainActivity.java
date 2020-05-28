package rvz.gchords.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import rvz.gchords.R;
import rvz.gchords.databinding.MainActivityBinding;
import rvz.gchords.viewmodel.MainViewModel;


public class MainActivity extends AppCompatActivity {
private MainActivityBinding binding;
private MainViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        binding = DataBindingUtil.setContentView(this,R.layout.main_activity);
        binding.setLifecycleOwner(this);
        binding.setViewmodel(viewModel);
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.requestScaleNotes();
            }
        });
    }
}
