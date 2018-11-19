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

import java.util.Locale;
import java.util.Random;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author richter
 */
public class ValueDetectionServiceTest {
    private final static Logger LOGGER = LoggerFactory.getLogger(ValueDetectionServiceTest.class);
    private final static Random RANDOM;
    static {
        long randomSeed = System.currentTimeMillis();
        LOGGER.debug(String.format("random seed: %d", randomSeed));
        RANDOM = new Random(randomSeed);
    }

    @Test
    public void testRetrieveLanguageIdentifier() {
        String expResult = ValueDetectionService.LANGUAGE_ENGLISH;
        String result = ValueDetectionService.retrieveLanguageIdentifier(Locale.ENGLISH);
        Assert.assertEquals(expResult, result);
        expResult = ValueDetectionService.LANGUAGE_CHINESE;
        result = ValueDetectionService.retrieveLanguageIdentifier(Locale.CHINESE);
        Assert.assertEquals(expResult, result);
        expResult = ValueDetectionService.LANGUAGE_FRENCH;
        result = ValueDetectionService.retrieveLanguageIdentifier(Locale.FRENCH);
        Assert.assertEquals(expResult, result);
        expResult = ValueDetectionService.LANGUAGE_GERMAN;
        result = ValueDetectionService.retrieveLanguageIdentifier(Locale.GERMAN);
        Assert.assertEquals(expResult, result);
        expResult = ValueDetectionService.LANGUAGE_SPANISH;
        result = ValueDetectionService.retrieveLanguageIdentifier(Locale.forLanguageTag("es"));
        Assert.assertEquals(expResult, result);
        Locale[] availableLocales = Locale.getAvailableLocales();
        Locale locale = availableLocales[RANDOM.nextInt(availableLocales.length)];
        expResult = locale.getLanguage();
        result = ValueDetectionService.retrieveLanguageIdentifier(locale);
        Assert.assertEquals(expResult, result);
    }
}
