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
import org.apache.commons.collections4.OrderedMap;

/**
 *
 * @author richter
 * @param <C> the type of configuration this engine needs
 */
public interface OCREngine<C extends OCREngineConf> {

    /**
     * Recognizes the characters of {@code images}.
     * @param images the images to recognize. The list order determines how the
     * string result's parts are concatenated, so it matters.
     * @return the recognized characters or {@code null} if the recognition has
     * been canceled with {@link #cancelRecognizeImages() }
     * @throws richtercloud.document.scanner.ifaces.OCREngineRecognitionException
     * if an unexpected exception during the recognition occured
     */
    String recognizeImages(List<BufferedImage> images) throws OCREngineRecognitionException;

    /**
     * Recognizes the characters of images whose data is available in
     * {@code InputStream}s in {@code imageStreams} which provides references to
     * {@code ImageWrapper}s which allow identification of the image in order
     * to be able to return cached values.
     *
     * @param imageStreams the mapping between {@link ImageWrapper}s (used as
     * keys for potential caching) and their data in form of
     * {@link InputStream}s. The map entry order determines how the string
     * result's parts are concatenated, so it matters.
     * @return the recognized characters or {@code null} if the recognition has
     * been canceled with {@link #cancelRecognizeImages() }
     * @throws richtercloud.document.scanner.ifaces.OCREngineRecognitionException
     * if an unexpected exception during the recognition occured
     */
    /*
    internal implementation notes:
    - mapping with BufferedImage keys gets you in situations where a
    BufferedImage isn't available because its creation is avoided by
    ImageWrapper
    */
    String recognizeImageStreams(OrderedMap<ImageWrapper, InputStream> imageStreams) throws OCREngineRecognitionException;

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
