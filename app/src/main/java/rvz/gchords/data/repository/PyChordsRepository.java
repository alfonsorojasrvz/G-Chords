package rvz.gchords.data.repository;

import android.text.TextUtils;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rvz.gchords.data.model.Scale;

public class PyChordsRepository {
    private static final String TAG = PyChordsRepository.class.getSimpleName();
    private List<String> scaleNotesList;
    private PyChordsAPI pyChordsAPI;

    public PyChordsRepository() {
        pyChordsAPI = PyChordsService.getRetrofit().create(PyChordsAPI.class);
    }

    public String getScale(String note,String scalename) {

        pyChordsAPI.getScale(note, scalename).enqueue(new Callback<Scale>() {
            @Override
            public void onResponse(Call<Scale> call, Response<Scale> response) {
                if (!response.isSuccessful()) {
                    String unSuccessfulResponse = response.message();
                    Log.d(TAG, unSuccessfulResponse);
                    //TODO Handle unsuccessful response.

                } else {
                    if (response.body() != null) {
                        scaleNotesList = response.body().getResponse();
                        Log.d(TAG, "onResponse: Got Scale");
                    }

                }
            }

            @Override
            public void onFailure(Call<Scale> call, Throwable t) {
                String onFailiureMessage = t.getMessage();
                Log.d(TAG, onFailiureMessage);
                //TODO handle error.

            }
        });
        return responseToString(scaleNotesList);
    }

    private String responseToString(List<String> scaleNotesList) {
        return TextUtils.join(",", scaleNotesList);
    }
}
