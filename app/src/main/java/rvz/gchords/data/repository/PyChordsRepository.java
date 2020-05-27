package rvz.gchords.data.repository;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rvz.gchords.data.model.Scale;

public class PyChordsRepository {
    List<String> scaleNotesList = null;

    private PyChordsAPI pyChordsAPI;

    public PyChordsRepository() {
        pyChordsAPI = PyChordsService.getRetrofit().create(PyChordsAPI.class);
    }

    public String getScale(){

        pyChordsAPI.getScale().enqueue(new Callback<Scale>() {
            @Override
            public void onResponse(Call<Scale> call, Response<Scale> response) {
                if(!response.isSuccessful()){

                }else{
                    if (response.body() != null) {
                        scaleNotesList = response.body().getResponse();
                    }

                }
            }

            @Override
            public void onFailure(Call<Scale> call, Throwable t) {

            }
        });
        return responseToString(scaleNotesList);
    }
    private String responseToString (List<String> scaleNotesList){
        String scale = TextUtils.join(",", scaleNotesList);
        return scale;
    }
}
