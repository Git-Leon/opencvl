package com.github.gitleon.opencvdemo.utils;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.opencv_objdetect;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author leon
 * A Haar Cascade is a classifier which is used to
 * start the object for which it has been trained for, from the source.
 * The Haar Cascade is trained by superimposing the positive
 * image over a set of negative images.
 */
public enum CascadeClassifierFactory {
    EYE,
    EYE_TREE_EYEGLASSES,
    FRONTALCATFACE,
    FRONTALCATFACE_EXTENDED,
    FRONTALFACE_ALT,
    FRONTALFACE_ALT2,
    FRONTALFACE_ALT_TREE,
    FULLBODY,
    LEFTEYE_2SPLITS,
    LICENCE_PLATE_RUS_16STAGES,
    LOWERBODY,
    PROFILEFACE,
    RIGHTEYE_2SPLITS,
    RUSSIAN_PLATE_NUMBER,
    SMILE,
    UPPERBODY;

    static {
        new PresetLoader(LoggerSingleton.GLOBAL).load(opencv_objdetect.class);
    }

    private final URL urlOfTrainedClassifier;


    CascadeClassifierFactory() {
        String addressPrefix = "https://raw.github.com/opencv/opencv/master/data/haarcascades/haarcascade_%s.xml";
        String classifierName = name().toLowerCase();
        try {
            this.urlOfTrainedClassifier = new URL(String.format(addressPrefix, classifierName));
        } catch (MalformedURLException e) {
            throw new Error(e);
        }
    }

    public String getFullPath() {
        try {
            return Loader.cacheResource(urlOfTrainedClassifier).getAbsolutePath();
        } catch (IOException e) {
            throw new Error(e);
        }
    }

    public CascadeClassifierWrapper createClassifier() {
        return new CascadeClassifierWrapper(getFullPath());
    }
}
