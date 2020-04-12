package kot.mvvm.myapplication.data;

public class Video_model {

    private String video_id;
    private String video_name;
    private String video_url;

    private String video_desc;

    public Video_model(String vid,String v_name,String video_url,String v_desc){

        this.video_id=vid;
        this.video_name=v_name;
        this.video_desc=v_desc;
        this.video_url=video_url;
    }

    public String getVideo_desc() {
        return video_desc;
    }

    public String getVideo_id() {
        return video_id;
    }

    public String getVideo_name() {
        return video_name;
    }

    public void setVideo_id(String video_id) {
        this.video_id = video_id;
    }

    public void setVideo_name(String video_name) {
        this.video_name = video_name;
    }

    public void setVideo_desc(String video_desc) {
        this.video_desc = video_desc;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    public String getVideo_url() {
        return video_url;
    }
}
