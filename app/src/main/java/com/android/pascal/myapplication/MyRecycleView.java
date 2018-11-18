package com.android.pascal.myapplication;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;

public class MyRecycleView extends RecyclerView {
    private int mScrollPosition;

    public MyRecycleView(Context context) {
        super(context);
    }

    public MyRecycleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRecycleView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        LayoutManager layoutManager = getLayoutManager();
        if(layoutManager != null && layoutManager instanceof LinearLayoutManager){
            mScrollPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
        }
        SavedState newState = new SavedState(superState);
        newState.mScrollPosition = mScrollPosition;
        Log.i("ccc","onSaveInstanceState "+mScrollPosition);
        return newState;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        super.onRestoreInstanceState(state);
        if(state != null && state instanceof SavedState){
            mScrollPosition = ((SavedState) state).mScrollPosition;


            LayoutManager layoutManager = getLayoutManager();
            if(layoutManager != null){
                int count = this.getAdapter().getItemCount();
                if(mScrollPosition != RecyclerView.NO_POSITION && mScrollPosition < count){
                    layoutManager.scrollToPosition(mScrollPosition);
                    Log.i("ccc","onRestoreInstanceState "+mScrollPosition);
                }
            }
        }
    }

    static class SavedState extends android.view.View.BaseSavedState {
        public int mScrollPosition;
        SavedState(Parcel in) {
            super(in);
            mScrollPosition = in.readInt();
        }
        SavedState(Parcelable superState) {
            super(superState);
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeInt(mScrollPosition);
        }
        public static final Parcelable.Creator<SavedState> CREATOR
                = new Parcelable.Creator<SavedState>() {
            @Override
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            @Override
            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
    }
}
