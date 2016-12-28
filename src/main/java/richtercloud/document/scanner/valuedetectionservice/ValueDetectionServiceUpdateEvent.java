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
package richtercloud.document.scanner.valuedetectionservice;

import java.util.Collections;
import java.util.List;
import richtercloud.document.scanner.valuedetectionservice.ValueDetectionResult;

/**
 *
 * @author richter
 */
public class ValueDetectionServiceUpdateEvent<T> {
    private final List<ValueDetectionResult<T>> intermediateResult;
    /**
     * The number of words in the input, i.e. the max. number of tests which
     * need to be performed.
     */
    private final int wordCount;
    /**
     * The counter of processed words.
     */
    private final int wordNumber;

    public ValueDetectionServiceUpdateEvent(List<ValueDetectionResult<T>> intermediateResult, int wordCount, int wordNumber) {
        this.intermediateResult = intermediateResult;
        this.wordCount = wordCount;
        this.wordNumber = wordNumber;
    }

    public List<ValueDetectionResult<T>> getIntermediateResult() {
        return Collections.unmodifiableList(intermediateResult);
    }

    public int getWordCount() {
        return wordCount;
    }

    public int getWordNumber() {
        return wordNumber;
    }
}