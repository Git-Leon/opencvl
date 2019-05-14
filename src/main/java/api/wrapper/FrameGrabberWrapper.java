package api.wrapper;

import api.LoggerSingleton;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;

public class FrameGrabberWrapper {
    private final FrameGrabber grabber;
    private Boolean started = false;

    public FrameGrabberWrapper(FrameGrabber grabber) {
        this.grabber = grabber;
    }

    public void start() {
        try {
            if (!started) {
                grabber.start();
                LoggerSingleton.GLOBAL.info("FrameGrabber started");
                started = true;
            }
        } catch (Exception e) {
            throw new Error(e);
        }
    }


    public void stop() {
        try {
            grabber.stop();
            started = false;
        } catch (Exception e) {
            throw new Error(e);
        }
    }


    public Frame grab() {
        try {
            return grabber.grab();
        } catch (Exception e) {
            throw new Error(e);
        }
    }
}
