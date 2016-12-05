package com.example.user.task_5;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import org.apache.commons.io.IOUtils;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by User on 12/5/2016.
 */

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.PictureViewHolder> {


    public static class PictureViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public PictureViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.picture);
        }
    }

    List<String> pictures;

    public GalleryAdapter(List<String> pictures) {
        this.pictures = pictures;
    }


    @Override
    public PictureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.i_image, parent, false);
        PictureViewHolder viewHolder = new PictureViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PictureViewHolder holder, final int position) {

        Picasso.with(holder.imageView.getContext())
                .load(pictures.get(position))
                .placeholder(R.drawable.ic_place)
                .into(holder.imageView);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Drawable imageDrawable = ((ImageView) view).getDrawable();
                if (imageDrawable != null) {
                    Bitmap imageBitmap = ((BitmapDrawable) imageDrawable).getBitmap();

                    File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "file.jpg");

                    saveImageToInternalStorage(imageBitmap, file);

                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.setDataAndType(Uri.fromFile(file), "image/*");
                    view.getContext().startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return pictures.size();
    }


    public void saveImageToInternalStorage(Bitmap image, File localFile) {

        if (localFile.exists()){
            Log.i("local file", "exists");
            localFile.delete();
        }
            FileOutputStream out;
            FileInputStream fis = null;
            try {
                out = new FileOutputStream(localFile);
                if (fis != null) {
                    IOUtils.copy(fis, out);
                    fis.close();
                }
                if (out != null) {

                    image.compress(Bitmap.CompressFormat.JPEG, 100, out);
                    out.flush();
                    out.close();
                }
            } catch (IOException e) {
                Log.e("error", e.getMessage());
            }

    }
}
