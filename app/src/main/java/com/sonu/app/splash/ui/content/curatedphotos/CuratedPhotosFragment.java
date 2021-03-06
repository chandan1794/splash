package com.sonu.app.splash.ui.content.curatedphotos;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.util.Log;
import android.util.Pair;
import android.view.View;

import com.sonu.app.splash.R;
import com.sonu.app.splash.ui.content.ContentFragment;
import com.sonu.app.splash.ui.list.ListItem;
import com.sonu.app.splash.model.unsplash.Photo;
import com.sonu.app.splash.ui.photo.PhotoLight;
import com.sonu.app.splash.ui.photo.PhotoListItem;
import com.sonu.app.splash.ui.photo.PhotoOnClickListener;
import com.sonu.app.splash.ui.photodescription.PhotoDescriptionActivity;
import com.sonu.app.splash.util.LogUtils;

import javax.inject.Inject;

/**
 * Created by amanshuraikwar on 28/01/18.
 */

public class CuratedPhotosFragment
        extends ContentFragment<CuratedPhotosContract.Presenter, Photo>
        implements CuratedPhotosContract.View {

    private static final String TAG = LogUtils.getLogTag(CuratedPhotosFragment.class);

    private PhotoOnClickListener photoOnClickListener =
            new PhotoOnClickListener() {
                @Override
                public void onDownloadBtnClick(Photo photo) {

                    Log.d(TAG, "onDownloadBtnClick:called");

                    getPresenter().downloadPhoto(photo);
                }

                @Override
                public void onClick(Photo photo, View itemView) {

                    Log.d(TAG, "onPhotoClick:called");

                    startPhotoDescriptionActivity(photo, itemView);
                }
            };

    @Inject
    Activity host;

    @Inject
    public CuratedPhotosFragment() {
        // empty constructor
    }

    @Override
    protected ListItem getListItem(Photo photo) {
        PhotoListItem listItem = new PhotoListItem(photo);
        listItem.setOnClickListener(photoOnClickListener);
        return listItem;
    }

    private void startPhotoDescriptionActivity(Photo photo, View transitionView) {

        Intent i = new Intent(host, PhotoDescriptionActivity.class);
        i.putExtra(PhotoDescriptionActivity.KEY_PHOTO, photo);

        ActivityOptions options =
                ActivityOptions.makeSceneTransitionAnimation(getActivity(),
                        Pair.create(transitionView,
                                host.getString(R.string.transition_photo)),
                        Pair.create(transitionView,
                                host.getString(R.string.transition_photo_description_background)));

        startActivity(i, options.toBundle());
    }
}
