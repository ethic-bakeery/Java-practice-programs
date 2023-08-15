import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

class Image {
    int width;
    int height;
    int[][] pixels;

    Image(int width, int height) {
        this.width = width;
        this.height = height;
        this.pixels = new int[height][width];
    }
}

public class ImageProcessingJava {
    static {
        // Load OpenCV native library
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    static Image createImage(int width, int height) {
        return new Image(width, height);
    }

    static Image resizeImage(Image originalImage, int newWidth, int newHeight) {
        Image resizedImage = createImage(newWidth, newHeight);

        for (int y = 0; y < newHeight; y++) {
            for (int x = 0; x < newWidth; x++) {
                int origX = x * originalImage.width / newWidth;
                int origY = y * originalImage.height / newHeight;
                resizedImage.pixels[y][x] = originalImage.pixels[origY][origX];
            }
        }

        return resizedImage;
    }

    static void manipulateImage(Image image) {
        for (int y = 0; y < image.height; y++) {
            for (int x = 0; x < image.width; x++) {
                image.pixels[y][x] = 255 - image.pixels[y][x];
            }
        }
    }

    public static void main(String[] args) {
        String filename = "your_image_file.jpg"; // Replace with the path to your image file

        Mat cvImage = Imgcodecs.imread(filename, Imgcodecs.IMREAD_GRAYSCALE);
        Image customImage = convertToCustomImage(cvImage);

        // Image processing operations on customImage
        Image resizedImage = resizeImage(customImage, 100, 100);
        manipulateImage(resizedImage);

        // Display processed image (OpenCV)
        Mat processedImage = new Mat(resizedImage.height, resizedImage.width, CvType.CV_8UC1);
        for (int y = 0; y < processedImage.rows(); y++) {
            for (int x = 0; x < processedImage.cols(); x++) {
                processedImage.put(y, x, resizedImage.pixels[y][x]);
            }
        }

        HighGui.imshow("Processed Image", processedImage);
        HighGui.waitKey(0);

        // No need to explicitly free memory in Java due to garbage collection
    }

    static Image convertToCustomImage(Mat cvImage) {
        int width = cvImage.cols();
        int height = cvImage.rows();

        Image customImage = createImage(width, height);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                customImage.pixels[y][x] = (int) cvImage.get(y, x)[0];
            }
        }

        return customImage;
    }
}
