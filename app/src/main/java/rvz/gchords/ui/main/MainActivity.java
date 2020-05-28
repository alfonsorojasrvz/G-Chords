package rvz.gchords.ui.main;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import rvz.gchords.R;
import rvz.gchords.databinding.MainActivityBinding;
import rvz.gchords.viewmodel.MainViewModel;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private MainActivityBinding binding;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity);
        binding.setLifecycleOwner(this);
        binding.setViewmodel(viewModel);
        setScaleSpinner();
        setNotesSpinner();

    }

    private void setScaleSpinner() {
        ArrayAdapter<CharSequence> adapterScale = ArrayAdapter.createFromResource(this,
                R.array.scale_types, android.R.layout.simple_spinner_item);
        adapterScale.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinner2.setAdapter(adapterScale);
        binding.spinner2.setOnItemSelectedListener(this);
    }

    private void setNotesSpinner() {
        ArrayAdapter<CharSequence> adapterNotes = ArrayAdapter.createFromResource(this,
                R.array.notes, android.R.layout.simple_spinner_item);
        adapterNotes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinner.setAdapter(adapterNotes);
        binding.spinner.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


        if (parent.getId() == binding.spinner.getId()) {
            String selectedNote = parent.getItemAtPosition(position).toString();
            viewModel.setParameters(selectedNote, null);
        }
        if (parent.getId() == binding.spinner2.getId()) {
            String selectedScale = parent.getItemAtPosition(position).toString();
            viewModel.setParameters(null, selectedScale);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
