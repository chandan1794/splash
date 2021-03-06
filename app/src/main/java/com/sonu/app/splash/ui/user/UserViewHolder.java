package com.sonu.app.splash.ui.user;

import android.support.annotation.LayoutRes;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.sonu.app.splash.R;
import com.sonu.app.splash.ui.list.ViewHolder;
import com.sonu.app.splash.util.LogUtils;

import butterknife.BindView;

/**
 * Created by amanshuraikwar on 20/12/17.
 */

public class UserViewHolder extends ViewHolder<UserListItem> {

    private static final String TAG = LogUtils.getLogTag(UserViewHolder.class);

    @LayoutRes
    public static final int LAYOUT = R.layout.item_user;

    @BindView(R.id.artistPicIv)
    ImageView artistPicIv;

    @BindView(R.id.parent)
    View parent;

    @BindView(R.id.artistNameTv)
    TextView artistNameTv;

    @BindView(R.id.artistUsernameTv)
    TextView artistUsernameTv;

    public UserViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bind(final UserListItem listItem, FragmentActivity parentActivity) {

        Log.i(TAG, "bind:userDescription="+listItem.getUser());

        Glide.with(parentActivity)
                .load(listItem.getUser().getProfileImage().getLarge())
                .transition(DrawableTransitionOptions.withCrossFade())
                .apply(new RequestOptions().centerCrop().circleCrop())
                .into(artistPicIv);

        artistNameTv.setText(listItem.getUser().getName());
        artistUsernameTv.setText(String.format("@%s", listItem.getUser().getUsername()));

        // unique transition name
        artistPicIv.setTransitionName(listItem.getUser().getId());

        parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listItem.getOnClickListener().onClick(listItem.getUser(), artistPicIv);
            }
        });
    }
}
