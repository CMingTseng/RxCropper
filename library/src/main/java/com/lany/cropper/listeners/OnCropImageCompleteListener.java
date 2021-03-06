package com.lany.cropper.listeners;

import com.lany.cropper.view.CropImageView;
import com.lany.cropper.entity.CropResult;

/**
 * Interface definition for a callback to be invoked when image async crop is complete.
 */
public interface OnCropImageCompleteListener {

    /**
     * Called when a crop image view has completed cropping image.<br>
     * Result object contains the cropped bitmap, saved cropped image uri, crop points data or the
     * error occured during cropping.
     *
     * @param view   The crop image view that cropping of image was complete.
     * @param result the crop image result data (with cropped image or error)
     */
    void onCropImageComplete(CropImageView view, CropResult result);
}