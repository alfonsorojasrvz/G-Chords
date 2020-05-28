package rvz.gchords.data.repository;

import android.util.Log;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rvz.gchords.data.model.Scale;

public class PyChordsRepository {
    private PyChordsAPI pyChordsAPI;
    ArrayList<String> strings = new ArrayList<>();

    public PyChordsRepository() {
        pyChordsAPI = PyChordsService.getRetrofit().create(PyChordsAPI.class);
    }

    public void requestScaleNotes(String note, String scalename, OnScaleResponse callback) {

        pyChordsAPI.getScale(note, scalename).enqueue(new Callback<Scale>() {

            @Override
            public void onResponse(Call<Scale> call, Response<Scale> response) {

                strings.addAll(response.body().getResponse());
                callback.setScaleNotes(strings);

            }

            @Override
            public void onFailure(Call<Scale> call, Throwable t) {

            }
        });


    }


}
