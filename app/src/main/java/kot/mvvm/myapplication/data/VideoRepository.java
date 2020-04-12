package kot.mvvm.myapplication.data;

import java.util.ArrayList;

import kot.mvvm.myapplication.R;


public class VideoRepository {

   private ArrayList<Video_model> itemList = new ArrayList<Video_model>();

    public ArrayList<Video_model> getVideoDetails(){

        String url1="android.resource://kot.mvvm.myapplication/" + R.raw.test1;
        String url2="android.resource://kot.mvvm.myapplication/" + R.raw.test2;;
        String url3="android.resource://kot.mvvm.myapplication/" + R.raw.test3;
        String url4="android.resource://kot.mvvm.myapplication/" + R.raw.test4;

        itemList.add(new Video_model("1", "Android Tutorial",url1, "Android software development is the process by which new applications are created for devices running the Android operating system. Google states that \"Android apps can be written using Kotlin, Java, and C++"));
        itemList.add(new Video_model("2", "PHP MYSQL",url2, "PHP is a popular general-purpose scripting language that is especially suited to web development. It was originally created by Rasmus Lerdorf in 1994"));
        itemList.add(new Video_model("3", "Flutter Tutorial",url3, "Flutter is an open-source UI software development kit created by Google. It is used to develop applications for Android, iOS, Windows, Mac, Linux, Google Fuchsia and the web"));
        itemList.add(new Video_model("4", "MVVM Tutorial",url4, "Model–view–viewmodel is a software architectural pattern that facilitates a separation of development of the graphical user interface – be it via a markup language or GUI code – from development of the business logic or back-end logic"));

        return itemList;

    }
}
