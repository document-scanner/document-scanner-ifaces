/**
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.richtercloud.document.scanner.valuedetectionservice;

import java.util.List;
import java.util.Map;

/**
 *
 * @author richter
 * @param <T> the type of value detection result types to be handled in events (see
 *     {@link ValueDetectionServiceExecutorListener} for details)
 */
public interface ValueDetectionServiceExecutor<T> {

    void cancelExecute();

    Map<ValueDetectionService<T>, List<ValueDetectionResult<T>>> execute(final String input,
            String languageIdentifier) throws ResultFetchingException;

    void removeListener(ValueDetectionServiceExecutorListener<T> listener);

    void addListener(ValueDetectionServiceExecutorListener<T> listener);
}
