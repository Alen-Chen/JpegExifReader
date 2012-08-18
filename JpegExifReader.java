/**
 *  JpegExifReader.java
 *  JpegExifReader PhoneGap plugin (Android)
 *
 *  Created by Alen Chen on 08/07/2012.
 *  Copyright 2012 Alen Chen. All rights reserved.
 *  MIT Licensed
 *
 */
package com.angrystone;


import org.json.JSONArray;
import org.json.JSONException;
import android.media.ExifInterface;

import org.apache.cordova.api.Plugin;
import org.apache.cordova.api.PluginResult;

import java.io.IOException;

public class JpegExifReader extends Plugin {

    @Override
    public PluginResult execute(String action, JSONArray args, String callbackId) {
        PluginResult.Status status = PluginResult.Status.OK;
        Integer result = 0;

        if (action.equals("getWidth")) {
            String file = null;
            try {
                file = args.getString(0);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                ExifInterface exif = new ExifInterface(file);
                result = exif.getAttributeInt(ExifInterface.TAG_IMAGE_WIDTH, 0);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else if (action.equals("getLength")) {
            String file = null;
            try {
                file = args.getString(0);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                ExifInterface exif = new ExifInterface(file);
                result = exif.getAttributeInt(ExifInterface.TAG_IMAGE_LENGTH, 0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            status = PluginResult.Status.INVALID_ACTION;
        }
        return new PluginResult(status, result);
    }
}
