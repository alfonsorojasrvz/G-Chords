package rvz.gchords.viewmodel;

import android.text.TextUtils;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import rvz.gchords.data.repository.OnScaleResponse;
import rvz.gchords.data.repository.PyChordsRepository;

public class MainViewModel extends ViewModel {
    private MutableLiveData<List<String>> scaleNotesList = new MutableLiveData<List<String>>();
    private MutableLiveData<String> stringScaleNotes = new MutableLiveData<>();
    private String note ;
    private String scaleType;


    public void requestScaleNotes() {
        PyChordsRepository pyChordsRepository = new PyChordsRepository();
        pyChordsRepository.requestScaleNotes(note, scaleType, new OnScaleResponse() {
            @Override
            public void setScaleNotes(List<String> scaleNotes) {
                scaleNotesList.setValue(scaleNotes);
                String str = TextUtils.join(",", scaleNotes);
                stringScaleNotes.setValue(str);
            }
        });
    }

    public LiveData<List<String>> getScaleNotes() {
        return scaleNotesList;
    }

    public LiveData<String> getStringScaleNotes() {
        return stringScaleNotes;
    }
    public void setParameters(String note,String scaleType){

        if(note!=null){this.note = note;}
        if(scaleType!=null){this.scaleType=scaleType;}
    }


}
