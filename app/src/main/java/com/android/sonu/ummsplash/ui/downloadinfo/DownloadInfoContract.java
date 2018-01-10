package com.android.sonu.ummsplash.ui.downloadinfo;

import com.android.sonu.ummsplash.ui.architecture.BasePresenter;
import com.android.sonu.ummsplash.ui.architecture.BaseView;

/**
 * Created by amanshuraikwar on 24/12/17.
 */

public interface DownloadInfoContract {

    interface View extends BaseView {

        void updateUi(String curFileName,
                      int curDownloadProgress,
                      int downloadQueueLength,
                      String curPhotoId);

        void showError(String curFileName,
                       int curDownloadProgress,
                       int downloadQueueLength,
                       String curPhotoId,
                       String error);

        void showProgress(long progress, long total);
    }

    interface Presenter extends BasePresenter<View> {
        void onCancelClick(String photoId);
        void onRetryClick(String photoId);
    }
}
