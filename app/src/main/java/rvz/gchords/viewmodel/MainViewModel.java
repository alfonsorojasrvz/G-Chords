package rvz.gchords.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import rvz.gchords.data.repository.PyChordsRepository;

public class MainViewModel extends ViewModel {
private MutableLiveData<String> scaleNotes = new MutableLiveData<>();

    public void requestScaleNotes() {
        PyChordsRepository pyChordsRepository = new PyChordsRepository();
        String scaleNotesString = pyChordsRepository.getScale();
        scaleNotes.setValue(scaleNotesString);
    }
    public LiveData<String> getScaleNotes(){
        return scaleNotes;
    }
}
