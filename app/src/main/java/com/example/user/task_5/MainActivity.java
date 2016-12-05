package com.example.user.task_5;

import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView.LayoutManager layoutManager;
    static final int REQUEST_CODE = 1;

    String[] PERMISSIONS = {"android.permission.READ_EXTERNAL_STORAGE","android.permission.WRITE_EXTERNAL_STORAGE"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> pictureList = fillTheGallery();

        GalleryAdapter adapter = new GalleryAdapter(pictureList);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(PERMISSIONS, REQUEST_CODE);
        }


        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            layoutManager = new GridLayoutManager(this, 4, LinearLayoutManager.HORIZONTAL, false);
        } else {
            layoutManager = new GridLayoutManager(this, 2, LinearLayoutManager.HORIZONTAL, false);
        }
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.gallery_recycler_view);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private static List<String> fillTheGallery(){

        List<String> list = new ArrayList<>();

        list.add("http://www.demilked.com/magazine/wp-content/uploads/2015/11/new-hybrid-animals-photoshop-5.jpg");
        list.add("https://s-media-cache-ak0.pinimg.com/originals/8c/cb/4e/8ccb4ee085b136ddc7948c3c42ab294f.jpg");
        list.add("http://thumbs.wallwiz.com/preview/Animals_fun/c674758b0f5c17bba752aa232e78e567.jpg");
        list.add("http://www.weirdhut.com/wp-content/uploads/2011/04/funny-animals-smiling-horse.jpg");
        list.add("https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcRocmV-xz1Yj04OvcZ7ZsQiTTQFPjAFDCulol4P6O9ETr6ad77q");
        list.add("https://s-media-cache-ak0.pinimg.com/originals/a5/b3/5c/a5b35cdde45160ca4c4c34a945919403.jpg");
        list.add("https://s-media-cache-ak0.pinimg.com/564x/64/a0/70/64a0700f11897cf7c8ca62fcd3ec0a61.jpg");
        list.add("https://s-media-cache-ak0.pinimg.com/236x/b5/3a/2f/b53a2f5f036f4992d663c1c17f2e38fc.jpg");
        list.add("http://www.weirdhut.com/wp-content/uploads/2011/04/funny-animals-kitten-ducks-friends.jpg");
        list.add("http://www.funny-potato.com/images/animals/funny-animals.jpg");
        list.add("https://s-media-cache-ak0.pinimg.com/originals/54/11/d4/5411d4650f1b17b0af35c7da9d2f6c17.jpg");
        list.add("https://s-media-cache-ak0.pinimg.com/736x/46/26/25/462625c69e0cf4d2eb66c1c28a62dd46.jpg");
        list.add("http://thumbs.wallwiz.com/preview/Animals_fun/325285bbf8ef2acc7fdc94059e2d7123.jpg");
        list.add("https://s-media-cache-ak0.pinimg.com/originals/98/a2/aa/98a2aa8fbd5574eb9b4db5bb4c1eda60.jpg");
        list.add("https://s-media-cache-ak0.pinimg.com/originals/0f/4d/02/0f4d02f9adfe32e0bceb78f01b370201.jpg");
        list.add("https://s-media-cache-ak0.pinimg.com/564x/1c/23/e2/1c23e2768376d96e9cc45514333b5a3b.jpg");
        list.add("https://s-media-cache-ak0.pinimg.com/originals/60/ce/28/60ce28e45393cfdb3f282edda8396222.jpg");
        list.add("https://s-media-cache-ak0.pinimg.com/564x/b3/df/42/b3df42c8c022ef8cb365f0de746be2b2.jpg");
        list.add("http://3.bp.blogspot.com/-KTsGn36GuOw/UFyb6EK01BI/AAAAAAAAV2w/pFnHTa8l8DY/s640/funny-animal-pictures-of-the-week-022-001.jpg");
        list.add("http://blogs.friendlybeings.com/fun/wp-content/uploads/2011/12/pic4.jpg");
        list.add("https://i.ytimg.com/vi/x23ghPBSEzM/hqdefault.jpg");
        list.add("https://s-media-cache-ak0.pinimg.com/originals/65/7e/14/657e14e6eddcc8784511c95083dddeed.jpg");
        list.add("https://i.ytimg.com/vi/Kdsxho2Cnog/hqdefault.jpg");
        list.add("http://1funny.com/wp-content/uploads/2012/12/these_funny_animals_1099_640_01.jpg");
        list.add("https://i.ytimg.com/vi/m0_MNGa9RYI/hqdefault.jpg");
        list.add("https://s-media-cache-ak0.pinimg.com/736x/28/11/a2/2811a2b44c8bd9ad4864bbc0ab2ec34d.jpg");
        list.add("https://itfunnylife.files.wordpress.com/2008/06/fun-animals-img_4-hot-dogs.jpg");
        list.add("http://amolife.com/image/images/stories/Animals/Fun/funny_animals_to_make_your_day%20(29).jpg");
        list.add("https://s-media-cache-ak0.pinimg.com/originals/0e/ea/1a/0eea1a7f63e2d6ae6216f8a253d495e6.png");
        list.add("https://s-media-cache-ak0.pinimg.com/236x/4c/c6/bd/4cc6bd0a354229f0926f5d91fab0f05b.jpg");
        list.add("http://slappedham.com/wp-content/uploads/2014/06/funny-animals-making-funny-faces-007.jpg");
        list.add("https://i.ytimg.com/vi/3Ox0kk7D01I/hqdefault.jpg");
        list.add("http://amolife.com/image/images/stories/Animals/Fun/funny_animals_to_make_your_day%20(21).jpg");

        return list;
    }



    @Override

    public void onRequestPermissionsResult(int permsRequestCode, String[] permissions, int[] grantResults){

        switch(permsRequestCode){

            case 1:

                boolean readAccepted = grantResults[0]== PackageManager.PERMISSION_GRANTED;
                boolean writeAccepted = grantResults[1]== PackageManager.PERMISSION_GRANTED;

                break;
        }
    }
}
