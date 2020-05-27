package rvz.gchords.data.repository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rvz.gchords.data.model.Scale;

public class PyChordsRepository {

    private PyChordsAPI pyChordsAPI;

    public PyChordsRepository() {
        pyChordsAPI = PyChordsService.getRetrofit().create(PyChordsAPI.class);
    }

    public Scale getScale(){

        pyChordsAPI.getScale().enqueue(new Callback<Scale>() {
            @Override
            public void onResponse(Call<Scale> call, Response<Scale> response) {

            }

            @Override
            public void onFailure(Call<Scale> call, Throwable t) {

            }
        });
        return null;
    }
}
