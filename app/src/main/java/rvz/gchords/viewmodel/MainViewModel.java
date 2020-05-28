package rvz.gchords.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import rvz.gchords.data.repository.OnScaleResponse;
import rvz.gchords.data.repository.PyChordsRepository;

public class MainViewModel extends ViewModel {
    private static MutableLiveData<List<String>> scaleNotesList = new MutableLiveData<List<String>>();
    private String note = "c";
    private String scalename = "escala_mayor_natural";


    public void requestScaleNotes() {
        PyChordsRepository pyChordsRepository = new PyChordsRepository();
        pyChordsRepository.requestScaleNotes(note, scalename, new OnScaleResponse() {
            @Override
            public void setScaleNotes(List<String> scaleNotes) {
                scaleNotesList.setValue(scaleNotes);
            }
        });
    }

    public LiveData<List<String>> getScaleNotes() {
        return scaleNotesList;

    }

}
