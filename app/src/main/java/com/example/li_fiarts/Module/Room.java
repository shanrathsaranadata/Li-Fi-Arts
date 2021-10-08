package com.example.li_fiarts.Module;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import com.example.li_fiarts.R;

import java.util.ArrayList;
import java.util.HashMap;

public class Room {
    private Activity activity;
    private Context context;
    private int row_count;
    private int column_count;
    private ConstraintLayout cl;
    private ConstraintSet set;

    private int image_height;
    private int image_width;

    private int[] column_markers;
    private int[] row_markers;

    int height =-1;
    int width =-1;


    int activated = -1;

    ArrayList<Integer> pictureIDs = new ArrayList<>();
    ArrayList<int[]> positions = new ArrayList<>();
    HashMap<Integer, Integer> image_ids = new HashMap<>();

    int manID = -1;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public Room(int row_count, int column_count,
                ConstraintLayout cl, Activity activity,
                Context context){

        this.activity = activity;
        this.context = context;

        this.cl = cl;
        set = new ConstraintSet();

        this.row_count = row_count;
        this.column_count = column_count;

        row_markers = new int[row_count+1];
        column_markers = new int[column_count+1];

        image_height = getHeight()/row_count;
        image_width = getWidth()/column_count;

        for (int i=0; i<=row_count; i++){
            TextView a = new TextView(context);
            a.setBackgroundColor(Color.LTGRAY);

            a.setTextSize(1);
            a.setText(" ");
            a.setHeight(convertDpToPixel(1));

            int t_id = View.generateViewId();
            row_markers[i] = t_id;
            a.setId(t_id);

            cl.addView(a);
            set.constrainHeight(a.getId(),convertDpToPixel(1));
            set.constrainWidth(a.getId(),ConstraintSet.MATCH_CONSTRAINT);

            set.connect(a.getId(),ConstraintSet.TOP,ConstraintSet.PARENT_ID,ConstraintSet.TOP,(i*image_height));
            set.connect(a.getId(),ConstraintSet.LEFT,ConstraintSet.PARENT_ID,ConstraintSet.LEFT);
            set.connect(a.getId(),ConstraintSet.RIGHT,ConstraintSet.PARENT_ID,ConstraintSet.RIGHT);
        }
        for (int i=0; i<=column_count; i++){
            TextView a = new TextView(context);
            a.setBackgroundColor(Color.LTGRAY);

            a.setTextSize(1);
            a.setText(" ");
            a.setHeight(convertDpToPixel(1));
            int t_id = View.generateViewId();
            column_markers[i] = t_id;
            a.setId(t_id);

            cl.addView(a);
            set.constrainWidth(a.getId(),convertDpToPixel(1));
            set.constrainHeight(a.getId(),ConstraintSet.MATCH_CONSTRAINT);

            set.connect(a.getId(),ConstraintSet.LEFT,ConstraintSet.PARENT_ID,ConstraintSet.LEFT,(i*image_width));
            set.connect(a.getId(),ConstraintSet.TOP,ConstraintSet.PARENT_ID,ConstraintSet.TOP);
            set.connect(a.getId(),ConstraintSet.BOTTOM,ConstraintSet.PARENT_ID,ConstraintSet.BOTTOM);
        }

        set.applyTo(cl);

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public Room(int row_count, int column_count,
                ConstraintLayout cl, Activity activity,
                Context context, int pixel_height, int pixel_width){

        this.activity = activity;
        this.context = context;

        this.width = pixel_width;
        this.height = pixel_height;


        this.cl = cl;
        set = new ConstraintSet();

        this.row_count = row_count;
        this.column_count = column_count;

        row_markers = new int[row_count+1];
        column_markers = new int[column_count+1];

        image_height = getHeight()/row_count;
        image_width = getWidth()/column_count;

        for (int i=0; i<=row_count; i++){
            TextView a = new TextView(context);
            a.setBackgroundColor(Color.LTGRAY);

            a.setTextSize(1);
            a.setText(" ");
            a.setHeight(convertDpToPixel(1));

            int t_id = View.generateViewId();
            row_markers[i] = t_id;
            a.setId(t_id);

            cl.addView(a);
            set.constrainHeight(a.getId(),convertDpToPixel(1));
            set.constrainWidth(a.getId(),ConstraintSet.MATCH_CONSTRAINT);

            set.connect(a.getId(),ConstraintSet.TOP,ConstraintSet.PARENT_ID,ConstraintSet.TOP,(i*image_height));
            set.connect(a.getId(),ConstraintSet.LEFT,ConstraintSet.PARENT_ID,ConstraintSet.LEFT);
            set.connect(a.getId(),ConstraintSet.RIGHT,ConstraintSet.PARENT_ID,ConstraintSet.RIGHT);
        }
        for (int i=0; i<=column_count; i++){
            TextView a = new TextView(context);
            a.setBackgroundColor(Color.LTGRAY);

            a.setTextSize(1);
            a.setText(" ");
            a.setHeight(convertDpToPixel(1));
            int t_id = View.generateViewId();
            column_markers[i] = t_id;
            a.setId(t_id);

            cl.addView(a);
            set.constrainWidth(a.getId(),convertDpToPixel(1));
            set.constrainHeight(a.getId(),ConstraintSet.MATCH_CONSTRAINT);

            set.connect(a.getId(),ConstraintSet.LEFT,ConstraintSet.PARENT_ID,ConstraintSet.LEFT,(i*image_width));
            set.connect(a.getId(),ConstraintSet.TOP,ConstraintSet.PARENT_ID,ConstraintSet.TOP);
            set.connect(a.getId(),ConstraintSet.BOTTOM,ConstraintSet.PARENT_ID,ConstraintSet.BOTTOM);
        }

        set.applyTo(cl);

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public Room(int row_count, int column_count,
                ConstraintLayout cl, Activity activity,
                Context context, float dp_height, float dp_width){

        this.activity = activity;
        this.context = context;

        this.width = convertDpToPixel(dp_width);
        this.height = convertDpToPixel(dp_height);


        this.cl = cl;
        set = new ConstraintSet();

        this.row_count = row_count;
        this.column_count = column_count;

        row_markers = new int[row_count+1];
        column_markers = new int[column_count+1];

        image_height = getHeight()/row_count;
        image_width = getWidth()/column_count;

        for (int i=0; i<=row_count; i++){
            TextView a = new TextView(context);
            a.setBackgroundColor(Color.LTGRAY);

            a.setTextSize(1);
            a.setText(" ");
            a.setHeight(convertDpToPixel(1));

            int t_id = View.generateViewId();
            row_markers[i] = t_id;
            a.setId(t_id);

            cl.addView(a);
            set.constrainHeight(a.getId(),convertDpToPixel(1));
            set.constrainWidth(a.getId(),ConstraintSet.MATCH_CONSTRAINT);

            set.connect(a.getId(),ConstraintSet.TOP,ConstraintSet.PARENT_ID,ConstraintSet.TOP,(i*image_height));
            set.connect(a.getId(),ConstraintSet.LEFT,ConstraintSet.PARENT_ID,ConstraintSet.LEFT);
            set.connect(a.getId(),ConstraintSet.RIGHT,ConstraintSet.PARENT_ID,ConstraintSet.RIGHT);
        }
        for (int i=0; i<=column_count; i++){
            TextView a = new TextView(context);
            a.setBackgroundColor(Color.LTGRAY);

            a.setTextSize(1);
            a.setText(" ");
            a.setHeight(convertDpToPixel(1));
            int t_id = View.generateViewId();
            column_markers[i] = t_id;
            a.setId(t_id);

            cl.addView(a);
            set.constrainWidth(a.getId(),convertDpToPixel(1));
            set.constrainHeight(a.getId(),ConstraintSet.MATCH_CONSTRAINT);

            set.connect(a.getId(),ConstraintSet.LEFT,ConstraintSet.PARENT_ID,ConstraintSet.LEFT,(i*image_width));
            set.connect(a.getId(),ConstraintSet.TOP,ConstraintSet.PARENT_ID,ConstraintSet.TOP);
            set.connect(a.getId(),ConstraintSet.BOTTOM,ConstraintSet.PARENT_ID,ConstraintSet.BOTTOM);
        }

        set.applyTo(cl);

    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    public void addPicture(int id, int cell_row, int cell_column, String label) {
        if (pictureIDs.contains(id)){
            throw new RuntimeException("Duplicate ID "+id+" found.");
        }
        int index = pictureIDs.size();
        pictureIDs.add(id);
        int[] position = {cell_row,cell_column};

        if (positions.contains(position)){
            throw new RuntimeException("Two pictures can not in the same location.");
        }

        if (cell_column>column_count || cell_row>row_count){
            throw new RuntimeException("Picture should be in the room.");
        }

        positions.add(position);
        drawPicture(index,cell_row,cell_column, label);
    }



    @RequiresApi(api = Build.VERSION_CODES.M)
    private void drawPicture(int id, int cell_row, int cell_column, String label){
        ImageView view = new ImageView(context);
        int view_id = View.generateViewId();
        view.setId(view_id);

        TextView tv = new TextView(context);
        tv.setText(label);
        tv.setTextSize(12);

        tv.setId(View.generateViewId());

        view.setImageIcon(Icon.createWithResource(context,R.drawable.off_bulb_foreground));

        image_ids.put(id, view_id);

        cl.addView(view);
        cl.addView(tv);

        set.connect(view.getId(), ConstraintSet.LEFT, column_markers[cell_column-1], ConstraintSet.RIGHT);
        set.connect(view.getId(), ConstraintSet.RIGHT, column_markers[cell_column], ConstraintSet.LEFT);

        set.connect(tv.getId(), ConstraintSet.LEFT, column_markers[cell_column-1], ConstraintSet.RIGHT);
        set.connect(tv.getId(), ConstraintSet.RIGHT, column_markers[cell_column], ConstraintSet.LEFT);

        set.connect(tv.getId(), ConstraintSet.TOP, row_markers[cell_row-1], ConstraintSet.BOTTOM, convertDpToPixel(8));
        set.connect(view.getId(), ConstraintSet.TOP, tv.getId(), ConstraintSet.BOTTOM);
        set.connect(view.getId(), ConstraintSet.BOTTOM, row_markers[cell_row], ConstraintSet.TOP);


        set.constrainWidth(view.getId(), ConstraintSet.MATCH_CONSTRAINT);
        set.constrainHeight(view.getId(), ConstraintSet.MATCH_CONSTRAINT);

        set.constrainWidth(tv.getId(), ConstraintSet.WRAP_CONTENT);
        set.constrainHeight(tv.getId(), ConstraintSet.WRAP_CONTENT);

        set.applyTo(cl);



    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    private void drawMan(int cell_row, int cell_column){

        ImageView view;
        int view_id;

        if (manID==-1){
            view = new ImageView(context);
            view_id = View.generateViewId();
            view.setId(view_id);
            view.setImageIcon(Icon.createWithResource(context,R.drawable.man_foreground));
            manID = view_id;

        }else {
            view = activity.findViewById(manID);
            view_id = manID;
        }


        cl.addView(view);

        set.connect(view.getId(), ConstraintSet.LEFT, column_markers[cell_column-1], ConstraintSet.RIGHT);
        set.connect(view.getId(), ConstraintSet.RIGHT, column_markers[cell_column], ConstraintSet.LEFT);
        set.connect(view.getId(), ConstraintSet.TOP, row_markers[cell_row-1], ConstraintSet.BOTTOM);
        set.connect(view.getId(), ConstraintSet.BOTTOM, row_markers[cell_row], ConstraintSet.TOP);


        set.constrainWidth(view.getId(), ConstraintSet.MATCH_CONSTRAINT);
        set.constrainHeight(view.getId(), ConstraintSet.MATCH_CONSTRAINT);

        set.applyTo(cl);

    }



    @RequiresApi(api = Build.VERSION_CODES.M)
    public void setActivatedPicture(int id){
        if (activated!=-1){
            ImageView imageView = activity.findViewById(activated);
            imageView.setImageIcon(Icon.createWithResource(context, R.drawable.off_bulb_foreground));
        }
        activated = id;

        int index = pictureIDs.indexOf(id);

        ImageView imageView = activity.findViewById(image_ids.get(index));
        imageView.setImageIcon(Icon.createWithResource(context,R.drawable.on_bulb_foreground));


        int[] p = positions.get(index);

        ArrayList<int[]> places = new ArrayList<>();

        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                int[] new_position = {((p[0]+i)-1), ((p[1]+j)-1)};
                    if (new_position!=p &&
                    !positions.contains(new_position) &&
                    new_position[0]>0 && new_position[1]>0){

                        places.add(new_position);

                        for (int f=0; f< positions.size(); f++){
                            int[] ac = positions.get(f);
                            if ((ac[0] == new_position[0] && ac[1]==new_position[1])){
                                try {
                                    places.remove(new_position);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }


                }


            }

        }

        if (places.size()==0){
            return;
        }

        if (places.size()==1){
            drawMan(places.get(0)[0],places.get(0)[1]);
        }else {

            int[] pre = new int[places.size()];


            for (int i=0; i< pre.length; i++) {
                int[] po = places.get(i);

                if (p[0] < (row_count / 2)) {
                    if (po[0]==p[0]){
                        pre[i]+=2;
                    }else if (po[0]<p[0]){
                        pre[i]++;
                    }else
                        {
                        pre[i]--;
                    }

                } else {
                    if (po[0]==p[0]){
                        pre[i]+=2;
                    }else if (po[0]>p[0]){
                        pre[i]++;
                    }else {
                        pre[i]--;
                    }
                }

                if (p[1] < (column_count / 2)) {
                    if (po[1]==p[1]){
                        pre[i]++;
                    }else  if (po[1]<p[1]){
                        pre[i]++;
                    }else {
                        pre[i]--;
                    }

                } else {
                    if (po[1]==p[1]){
                        pre[i]++;
                    }else  if (po[1]>p[1]){
                        pre[i]++;
                    }else {
                        pre[i]--;
                    }

                }
            }

            int max_id = -1;
            int max_value = -1;

            for (int i=0; i< pre.length; i++){
                if (pre[i]>max_value){
                    max_value = pre[i];
                    max_id=i;
                }
            }

            drawMan(places.get(max_id)[0],places.get(max_id)[1]);

        }
    }

    int getHeight(){
        if (height!=-1){
            return height;
        }


        DisplayMetrics metrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);

        return metrics.heightPixels;


    }

    int getWidth(){
        if (width!=-1){
            return width;
        }


        DisplayMetrics metrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);




        return metrics.widthPixels;
    }
    
    int convertDpToPixel(float dp) {
        return (int) (dp * ((float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT));
    }

}
