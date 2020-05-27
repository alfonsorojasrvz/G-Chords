package rvz.gchords.data.repository;

public class PyChordsRepository {

    private PyChordsAPI pyChordsAPI;

    public PyChordsRepository() {
        pyChordsAPI = PyChordsService.getRetrofit().create(PyChordsAPI.class);
    }
}
