package org.xmlvm.tutorial.ios.sensor.camera;

import org.xmlvm.iphone.UIImage;
import org.xmlvm.iphone.UIImagePickerController;
import org.xmlvm.iphone.UIImagePickerControllerDelegate;
import org.xmlvm.iphone.UIImagePickerControllerSourceType;
import org.xmlvm.iphone.UIViewController;
import org.xmlvm.iphone.NSDictionary;
import org.xmlvm.iphone.NSError;
import org.xmlvm.iphone.UIImageWriteToPhotoAlbumHandler;

public class CameraHelper extends UIViewController {

    UIImage                 image;
    UIImagePickerController camera;


    public CameraHelper() {
        /*
         * Initialize the instance of UIImagePickerController. Set the delegate
         * for this instance which will handle the results of human interface
         * such as saving the image into the library. The source type can be set
         * to any of UIImagePickerControllerSourceType. In case of a simulator,
         * where the camera resource is not available, the type is set to
         * PhotoLibrary which will open the photo library to pick an image.
         */
        camera = new UIImagePickerController();
        camera.setDelegate(ui);
        camera.setSourceType(UIImagePickerControllerSourceType.Camera);

        /*
         * Hide the controls for picture editing
         */
        camera.setAllowsEditing(false);
    }

    @Override
    public void viewDidAppear(boolean animated) {
        /*
         * present the camera interface using presentModalViewController()
         */
        presentModalViewController(camera, true);
        super.viewWillAppear(animated);
    }


    /*
     * This serves as the delegate for UIImagePickerController which will handle
     * what needs to be done when user picks an image or cancels the picker. In
     * our case, the image is saved in the photo album when the user selects an
     * image.
     */
    UIImagePickerControllerDelegate ui = new UIImagePickerControllerDelegate() {
                                           /*
                                            * User picked an image
                                            */
                                           @Override
                                           public void didFinishPickingMediaWithInfo(
                                                   UIImagePickerController picker, NSDictionary info) {
                                               image = (UIImage) info
                                                       .objectForKey(UIImagePickerController.OriginalImage);

                                               /*
                                                * Save the image to photo album.
                                                * You can have some action
                                                * performed when the image is
                                                * finished storing in the album.
                                                * For this, you need to
                                                * implement the interface
                                                * UIImageWriteToPhotoAlbumHandler
                                                * and override the method
                                                * imageDidFinishWritingWithError
                                                * () which is a callback that is
                                                * called immediately after the
                                                * image is saved to the photo
                                                * album.
                                                */
                                               picker.UIImageWriteToSavedPhotosAlbum(image,
                                                       imageDelegate, null);
                                               super.didFinishPickingMediaWithInfo(picker, info);
                                           }


                                           /*
                                            * You can add the implementation
                                            * that has to be performed
                                            * immediately after storing the
                                            * image in the photo album in the
                                            * method
                                            * imageDidFinishWritingWithError()
                                            */
                                           UIImageWriteToPhotoAlbumHandler imageDelegate = new UIImageWriteToPhotoAlbumHandler() {
                                                                                             @Override
                                                                                             public void imageDidFinishWritingWithError(
                                                                                                     UIImage image,
                                                                                                     NSError error,
                                                                                                     Object context) {
                                                                                                 /*
                                                                                                  * left
                                                                                                  * empty
                                                                                                  */
                                                                                             }

                                                                                         };


                                           /*
                                            * User cancelled the operation
                                            */
                                           @Override
                                           public void imagePickerControllerDidCancel(
                                                   UIImagePickerController picker) {
                                               picker.dismissModalViewControllerAnimated(true);
                                               super.imagePickerControllerDidCancel(picker);
                                               picker.dealloc();

                                           }

                                       };
}
