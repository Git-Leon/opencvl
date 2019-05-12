package api.wrapper;

import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.Frame;

public class CanvasFrameWrapper {
    private final CanvasFrame frame;

    public CanvasFrameWrapper(CanvasFrame frame) {
        this.frame = frame;
    }

    public CanvasFrameWrapper(String title, FrameGrabberWrapper grabber) {
        System.out.println("FrameGrabber started");
        grabber.start();
        this.frame = new CanvasFrame(title, CanvasFrame.getDefaultGamma() / grabber.getGamma());
        System.out.println("CanvasFrame created");
    }

    public boolean isVisible() {
        return frame.isVisible();
    }

    public void showImage(Frame rotatedFrame) {
        frame.showImage(rotatedFrame);
    }

    public void dispose() {
        frame.dispose();
    }
}
