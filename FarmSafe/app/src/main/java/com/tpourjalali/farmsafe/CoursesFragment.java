package com.tpourjalali.farmsafe;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.ColorSpace;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ProfessorTaha on 1/14/2018.
 */

public class CoursesFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private ModelCourse mCourseModel;
    private final static String TAG = "CoursesFragment";

    public static CoursesFragment newInstance() {
        CoursesFragment fragment = new CoursesFragment();
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mCourseModel = ModelCourse.getInstance(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCourseModel = null;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View V = inflater.inflate(R.layout.fragment_courses, container, false);
        mRecyclerView = (RecyclerView) V;//.findViewById(R.id.courses_recycler_view);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mRecyclerView.setAdapter(new CourseAdapter());
        return V;
    }


    private class CourseHolder extends RecyclerView.ViewHolder{
        private TextView mCourseTitle;
        private ImageView mCourseImage;

        Course mCourse;
        public CourseHolder(View itemView) {
            super(itemView);
            mCourseImage = itemView.findViewById(R.id.course_item_image_view);
            mCourseTitle = itemView.findViewById(R.id.course_item_text_view);
        }
        public void bindCourse(Course course){
            mCourse = course;
            mCourseTitle.setText(course.getCourseName());
            int drawableId = mCourseModel.getCourseImageResourceId(course);
            Drawable thumbnail = null;
            try {
                thumbnail = getResources().getDrawable(drawableId);
            } catch (Resources.NotFoundException e){
                Log.e(TAG, "Drawable not found "+drawableId, e);
                thumbnail = getResources().getDrawable(R.drawable.ic_course_icon_100dp);
            }
            mCourseImage.setImageDrawable(thumbnail);
        }
    }
    private class CourseAdapter extends RecyclerView.Adapter<CourseHolder>{
        private List<Course> mCourses;
        public CourseAdapter(){
            //Note: should you supply a language below?
            mCourses = mCourseModel.getCourses();
        }
        @Override
        public CourseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater li = LayoutInflater.from(getActivity());
            View v = li.inflate(R.layout.course_view_item, parent, false);
            return new CourseHolder(v);
        }

        @Override
        public void onBindViewHolder(CourseHolder holder, int position) {
            holder.bindCourse(mCourses.get(position));
        }

        @Override
        public int getItemCount() {
            return mCourses.size();
        }
    }
    private class CourseOnClickListener implements View.OnClickListener{
        private int mCourseId;

        public int getCourseId() {
            return mCourseId;
        }

        public void setCourseId(int termId) {
            mCourseId = termId;
        }
        @Override
        public void onClick(View v) {
            //Intent i = new Intent(getActivity(), )
        }
    }
}
