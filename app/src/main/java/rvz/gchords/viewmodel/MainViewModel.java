package rvz.gchords.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import rvz.gchords.data.repository.PyChordsRepository;

public class MainViewModel extends ViewModel {
private MutableLiveData<String> scaleNotes = new MutableLiveData<>();
private String note;
private String scalename;


    public void requestScaleNotes() {
        PyChordsRepository pyChordsRepository = new PyChordsRepository();
        String scaleNotesString = pyChordsRepository.getScale(note,scalename);
        scaleNotes.setValue(scaleNotesString);
    }
    public LiveData<String> getScaleNotes(){
        return scaleNotes;
    }
}
