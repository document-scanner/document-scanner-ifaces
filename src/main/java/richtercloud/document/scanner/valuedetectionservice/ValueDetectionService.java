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

import java.lang.reflect.Field;
import java.util.List;
import java.util.Locale;

/**
 * Abstraction for different implementations for auto-OCR-value-detection.
 *
 * @author richter
 * @param <T> the type of values to detect
 */
public interface ValueDetectionService<T> {
    public final static String LANGUAGE_CHINESE = Locale.CHINESE.getLanguage();
    public final static String LANGUAGE_ENGLISH = Locale.ENGLISH.getLanguage();
    public final static String LANGUAGE_FRENCH = Locale.FRENCH.getLanguage();
    public final static String LANGUAGE_GERMAN = Locale.GERMAN.getLanguage();
    public final static String LANGUAGE_SPANISH = Locale.forLanguageTag("es").getLanguage();

    public static String retrieveLanguageIdentifier(Locale locale) {
        return locale.getLanguage();
    }

    /**
     * Fetches results in the form of {@link ValueDetectionResult}s from
     * {@code input}.
     * @param input
     * @param languageIdentifier the language to fetch results for
     * @return the fetched results
     */
    /*
    internal implementation notes:
    - A list can contain the order in of the result in the input which increases
    intuition when they're selected by the user. Duplicate avoidance has to be
    handled by implementations.
    */
    List<ValueDetectionResult<T>> fetchResults(String input,
            String languageIdentifier) throws ResultFetchingException;

    /**
     * Cancels a previously started {@link #fetchResults(java.lang.String) }.
     */
    void cancelFetch();

    void addListener(ValueDetectionServiceListener<T> listener);

    void removeListener(ValueDetectionServiceListener<T> listener);

    boolean supportsLanguage(String languageIdentifier);

    /**
     * Allows to restrict the fields on which the detection results ought to be
     * set. Some types of values like dates are interesting for all date fields
     * of the set of entity classes whereas some values like the identifier of a
     * document based on guesses of identifiers of previous documents is most
     * likely only interesting for the identifier field of the document class.
     *
     * This implies that type-based implementations like a date value detection
     * service could return something like
     * {@code Date.class.isAssignableFrom(field.getType) }.
     *
     * @param field
     * @return {@code true} if {@code field} is supported, {@code false}
     * otherwise
     */
    boolean supportsField(Field field);
}