package com.tonicartos.superslimexample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.tonicartos.superslim.GridSLM;

import java.util.ArrayList;

/**
 *
 */
public class CountryNamesAdapter extends RecyclerView.Adapter<CountryViewHolder> {

    public final ArrayList<Type> mItems = new ArrayList<Type>();

    private boolean mMarginsFixed;

    private final Context mContext;

    private void makeData() {

        int sectionFirstPosition = 0;
        // 헤더 추가
        mItems.add(new Type(Type.ViewType.vtHeader, sectionFirstPosition));
        // 배송 필드 추가
        for (int i = 0; i < 3; i++) {
            mItems.add(new Type(Type.ViewType.vtShip, sectionFirstPosition));
        }
        // 헤더 추가
        sectionFirstPosition = mItems.size();
        mItems.add(new Type(Type.ViewType.vtHeader, sectionFirstPosition));
        // 1뎊스 추가
        for (int i = 0; i < 20; i++) {
            mItems.add(new Type(Type.ViewType.vtOne, sectionFirstPosition));
        }
        // 헤더 추가
        sectionFirstPosition = mItems.size();
        mItems.add(new Type(Type.ViewType.vtHeader, sectionFirstPosition));
        // 2뎊스 추가
        for (int i = 0; i < 20; i++) {
            mItems.add(new Type(Type.ViewType.vtTwo, sectionFirstPosition));
        }
    }

    public CountryNamesAdapter(Context context, int headerMode) {
        mContext = context;

        final String[] countryNames = context.getResources().getStringArray(R.array.country_names);

        makeData();
    }

    public boolean isItemHeader(int position) {
        return Type.ViewType.vtHeader == mItems.get(position).getType();
    }

    @Override
    public CountryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == Type.ViewType.vtHeader.ordinal()) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.header_item, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.text_line_item, parent, false);
        }
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CountryViewHolder holder, int position) {
        final Type type = mItems.get(position);
        final View itemView = holder.itemView;

        final GridSLM.LayoutParams lp = GridSLM.LayoutParams.from(itemView.getLayoutParams());
        // Overrides xml attrs, could use different layouts too.
        if (Type.ViewType.vtHeader == type.getType()) {
            if (lp.isHeaderInline() || (mMarginsFixed && !lp.isHeaderOverlay())) {
                lp.width = ViewGroup.LayoutParams.MATCH_PARENT;
            } else {
                lp.width = ViewGroup.LayoutParams.WRAP_CONTENT;
            }

            lp.headerEndMarginIsAuto = !mMarginsFixed;
            lp.headerStartMarginIsAuto = !mMarginsFixed;

            holder.getmButton1().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext, "버튼 눌림", Toast.LENGTH_SHORT).show();
                    setExpand(type, false);
                }
            });
            holder.getmButton2().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext, "버튼 눌림", Toast.LENGTH_SHORT).show();
                    setExpand(type, true);
                }
            });
        }

        if (type.isVisible()) {
            Log.d("coolsharp", "visible");
            lp.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        }
        else {
            Log.d("coolsharp", "gone");
            lp.height = 0;
        }

        lp.setFirstPosition(type.getSectionFirstPosition());
        itemView.setLayoutParams(lp);
    }

    private void setExpand(Type type, boolean isExpand) {
        boolean isProcess = true;

        int i = type.getSectionFirstPosition();
        while (isProcess) {
            i++;
            if (i < mItems.size() && (Type.ViewType.vtHeader != mItems.get(i).getType())) {
                mItems.get(i).setVisible(isExpand);
            }
            else {
                isProcess = false;
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return mItems.get(position).getType().ordinal();
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    private void notifyHeaderChanges() {
        for (int i = 0; i < mItems.size(); i++) {
            Type item = mItems.get(i);
            if (Type.ViewType.vtHeader == item.getType()) {
                notifyItemChanged(i);
            }
        }
    }

}
