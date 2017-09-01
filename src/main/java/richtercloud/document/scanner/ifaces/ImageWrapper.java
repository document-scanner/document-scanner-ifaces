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

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import javafx.scene.image.WritableImage;

/**
 * Wraps different previews of a {@link BufferedImage} and a reference to the
 * image data on disk as well as translation between JavaFX and Swing.
 *
 * Manages desired rotation internally because rotation is a per-image property
 * which can't be retrieved from settings after a dialog which allows rotation
 * has been closed.
 *
 * @author richter
 */
/*
internal implementation notes:
- Desired width for zoom adjustment can't be managed
internally because it might be necessary to retrieve different previews (e.g.
for displaying zoomed, for OCR, etc.).
- Managing rotation internally allows to get rotation out of ScanResultDialog
very easily.
*/
public interface ImageWrapper extends Serializable {
    public final static String FORMAT_DEFAULT = "png";

    /**
     * Binary data of the original image in form of an {@link InputStream}
     * @param formatName passed to
     * {@link ImageIO#write(java.awt.image.RenderedImage, java.lang.String, java.io.File) }
     * @return the stream containing binary data
     * @throws IOException if an exception occurs while reading from image
     * storage file
     */
    /*
    internal implementation notes:
    - no need to make InputStream more concrete since it allows using buffered
    streams, a key technique to speed up I/O in Java
    <ref>http://www.oracle.com/technetwork/articles/javase/perftuning-137844.html</ref>
    */
    InputStream getOriginalImageStream(String formatName) throws ImageWrapperException;

    /**
     * Binary data of the original image in form of an {@link InputStream} in
     * format {@link #FORMAT_DEFAULT}.
     * @return the stream containing binary data
     * @throws IOException if an exception occurs while reading from image
     * storage file
     */
    InputStream getOriginalImageStream() throws ImageWrapperException;

    BufferedImage getOriginalImage() throws ImageWrapperException;

    BufferedImage getImagePreview(int width) throws ImageWrapperException;

    WritableImage getImagePreviewFX(int width) throws ImageWrapperException;

    int getImageHeightScaled(int width);

    int getInitialWidth();

    int getInitialHeight();

    double getRotationDegrees();

    void setRotationDegrees(double rotationDegrees) throws ImageWrapperException;

    File getStorageFile();

    /**
     * Get the size based on the size of the storage file.
     * @return the size in bytes.
     */
    long getSize();
}
