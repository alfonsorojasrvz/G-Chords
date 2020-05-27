package rvz.gchords.data.repository;

import retrofit2.Call;
import retrofit2.http.GET;
import rvz.gchords.data.model.Scale;

public interface PyChordsAPI {
    @GET("api/notes/")
    Call<Scale> getScale();
}
