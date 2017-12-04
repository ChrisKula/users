package com.christiankula.users.details;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.christiankula.users.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserDetailSectionView extends ConstraintLayout {

    @BindView(R.id.iv_user_detail_section_icon)
    ImageView ivSectionIcon;

    @BindView(R.id.tv_user_detail_section_text)
    TextView tvSectionText;


    public UserDetailSectionView(Context context) {
        super(context);
        initView();
    }

    public UserDetailSectionView(Context context, AttributeSet attrs) {
        super(context, attrs);

        initView(context.obtainStyledAttributes(attrs, R.styleable.UserDetailSectionView));
    }

    public UserDetailSectionView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initView(context.obtainStyledAttributes(attrs, R.styleable.UserDetailSectionView, defStyleAttr, 0));
    }

    private void initView() {
        initView(null);
    }

    private void initView(TypedArray typedArray) {
        View rootView = inflate(getContext(), R.layout.user_detail_section, this);
        ButterKnife.bind(rootView);

        if (typedArray != null) {
            String text = typedArray.getString(R.styleable.UserDetailSectionView_text);

            int iconRes = typedArray.getResourceId(R.styleable.UserDetailSectionView_icon, R.drawable.ic_person_color_primary_24dp);

            tvSectionText.setText(text);
            ivSectionIcon.setImageResource(iconRes);

            typedArray.recycle();
        } else {
            tvSectionText.setText("Dummy text");
            ivSectionIcon.setImageResource(R.drawable.ic_person_color_primary_24dp);
        }

        ivSectionIcon.setColorFilter(Color.GRAY);
    }

    public void setText(String str) {
        tvSectionText.setText(str);
        invalidate();
    }
}
