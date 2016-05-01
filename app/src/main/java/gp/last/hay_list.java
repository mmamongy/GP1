package gp.last;

/**
 * Created by Maryam on 4/30/2016.
 */
import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.PaintDrawable;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.TextView;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.app.Activity;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.PaintDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import adapter.MantkaAdapter;
import model.DividerItemDecoration;
import model.Mantka;


public class hay_list extends Fragment {


    static String baconTitle = "الحى";
    static String baconText = " دار السلام و مصر القديمه و مش عارفه ايه ";
    static String veggieTitle = "المعادى ";
    static String veggieText = "حدايق المعادى و مصر الججديه و اى بتنجان ";
    List<Mantka>mantkaList = new ArrayList<>();
    MantkaAdapter mantkaAdapter ;
    View v ;
    RecyclerView rv ;

    public hay_list() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         v =  inflater.inflate(R.layout.fragment_four, container, false);
        rv = (RecyclerView) v.findViewById(R.id.recyclerview);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        prepareMantkaData();
        mantkaAdapter = new MantkaAdapter(mantkaList);
        rv.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));

        rv.setAdapter(mantkaAdapter);

        Log.e("haaaaaaaaaaaay", String.valueOf(11111));
        rv.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), rv, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Mantka mantka = mantkaList.get(position);
                Toast.makeText(getActivity(), mantka.getName() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        return v ;
    }

    private void prepareMantkaData() {
        Mantka mantka = new Mantka("مصر الفيديمه ");
        mantkaList.add(mantka);
        mantka = new Mantka("مصر الفيديمه ");
        mantkaList.add(mantka);
        mantka = new Mantka("مصر الفيديمه ");
        mantkaList.add(mantka);
        mantka = new Mantka("مصر الفيديمه ");
        mantkaList.add(mantka);
        mantka = new Mantka("مصر الفيديمه ");
        mantkaList.add(mantka);
        mantka = new Mantka("مصر الفيديمه ");
        mantkaList.add(mantka);
        mantka = new Mantka("مصر الفيديمه ");
        mantkaList.add(mantka);
        mantka = new Mantka("مصر الفيديمه ");
        mantkaList.add(mantka);

    }

    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }

    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private hay_list.ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final hay_list.ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                        Log.e("Henaaaa","YAAAAAAAAAAAAARB") ;
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }


}