package kot.mvvm.myapplication.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import kot.mvvm.myapplication.data.VideoRepository;
import kot.mvvm.myapplication.data.Video_model;

public class VideoViewModel extends ViewModel {

    MutableLiveData<ArrayList<Video_model>> videodetails;
    VideoRepository videoRepository=  new VideoRepository();

    public MutableLiveData<ArrayList<Video_model>> getdata() {
        if (videodetails == null) {
            videodetails = new MutableLiveData<>();
            videodetails.postValue(videoRepository.getVideoDetails());
        }
        return videodetails;
    }

}
