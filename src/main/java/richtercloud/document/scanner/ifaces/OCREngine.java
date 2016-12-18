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
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 *
 * @author richter
 */
public interface OCREngine<C extends OCREngineConf> {

    /**
     * recognizes the characters of {@code image}
     * @param image
     * @return the recognized characters
     */
    String recognizeImages(List<BufferedImage> images);

    /**
     * recognizes the characters of images whose data is available in
     * {@code InputStream}s in {@code imageStreams} which provides references to
     * {@code BufferedImage}s which allow identification of the image in order+
     * to be able to return cached values.
     *
     * @param image
     * @return the recognized characters
     */
    /*
    internal implementation notes:
    - mapping with BufferedImage keys gets you in situations where a
    BufferedImage isn't available because its creation is avoided by
    ImageWrapper
    */
    String recognizeImageStreams(Map<ImageWrapper, InputStream> imageStreams);

    /**
     * Allows cancelation of a (potentially time taking) {@link #recognizeImage(java.awt.image.BufferedImage) } from
     * another thread.
     */
    /*
    internal implementation notes:
    - canceling from the same thread doesn't make sense because recognizeImage must
    return first and it return when it's completed only
    */
    void cancelRecognizeImages();

    void addProgressListener(OCREngineProgressListener progressListener);

    void removeProgressListener(OCREngineProgressListener progressListener);

    C getoCREngineConf();
}
