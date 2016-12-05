/**
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package richtercloud.document.scanner.ifaces;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.WritableImage;
import javax.imageio.ImageIO;

/**
 * Wraps different previews of a {@link BufferedImage} and a reference to the
 * image data on disk as well as translation between JavaFX and Swing.
 *
 * @author richter
 */
public class ImageWrapper {
    private final File storageFile;
    private final int initialWidth;
    private final int initialHeight;

    public ImageWrapper(File storageDir,
            BufferedImage image) throws IOException {
        assert storageDir.exists();
        assert storageDir.isDirectory();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "png", byteArrayOutputStream);
        byte[] imageBytes = byteArrayOutputStream.toByteArray();
        byte[] md5Bytes;
        try {
            md5Bytes = MessageDigest.getInstance("MD5").digest(imageBytes);
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex);
        }
        String md5 = new BigInteger(1,md5Bytes).toString(16);
            //from http://stackoverflow.com/questions/7776116/java-calculate-md5-hash
        this.storageFile = new File(storageDir, md5);
        ImageIO.write(image, "png", this.storageFile);
        this.initialWidth = image.getWidth();
        this.initialHeight = image.getHeight();
    }

    public BufferedImage getOriginalImage() throws IOException {
        BufferedImage retValue = ImageIO.read(this.storageFile);
        return retValue;
    }

    public BufferedImage getImagePreview(int width) throws IOException {
        BufferedImage image = getOriginalImage();
        BufferedImage retValue = new BufferedImage(width,
                getImageHeightScaled(width),
                image.getType());
        Graphics2D bGr = retValue.createGraphics();
        bGr.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        boolean drawingCompleted = bGr.drawImage(image,
                0, //x
                0, //y
                width, //width (specifying width and height is as good as specifying the scale factory
                getImageHeightScaled(width), //height
                null //imageObserver
        );
        assert drawingCompleted;
        bGr.dispose();
        return retValue;
    }

    public WritableImage getImagePreviewFX(int width) throws IOException {
        BufferedImage image = getOriginalImage();
        WritableImage originalImage = SwingFXUtils.toFXImage(image,
                null //wimg (can be null)
        );
        WritableImage retValue = new WritableImage(originalImage.getPixelReader(),
                0, //x
                0, //
                width,
                getImageHeightScaled(width));
        return retValue;
    }

    public int getImageHeightScaled(int width) {
        int retValue = this.initialHeight*width/this.initialWidth;
        return retValue;
    }

    public int getInitialWidth() {
        return initialWidth;
    }

    public int getInitialHeight() {
        return initialHeight;
    }
}
