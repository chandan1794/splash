package com.sonu.app.splash.ui.allphotos;

import com.sonu.app.splash.data.DataManager;
import com.sonu.app.splash.data.cache.NewPhotosCache;
import com.sonu.app.splash.data.download.PhotoDownload;
import com.sonu.app.splash.ui.architecture.BasePresenter;
import com.sonu.app.splash.ui.architecture.BaseView;
import com.sonu.app.splash.ui.list.ListItem;
import com.sonu.app.splash.ui.photo.Photo;

import java.util.List;

/**
 * Created by amanshuraikwar on 19/12/17.
 */

public interface AllPhotosContract {

    interface View extends BaseView {

        boolean isListEmpty();
        void showLoading();
        void hideLoading();
        void downloadPhoto(PhotoDownload photoDownload);
        void startPhotoDescriptionActivity(Photo photo);
        void setupList(DataManager dataManager, NewPhotosCache photosCache);
        void getAllPhotos();
    }

    interface Presenter extends BasePresenter<View> {
        void onDownloadBtnClick(Photo photo);
        void onPhotoClick(Photo photo);
    }
}
