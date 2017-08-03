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

import java.io.Serializable;
import richtercloud.message.handler.IssueHandler;

/**
 * Holds configuration values for an {@link OCREngine} usually created in an
 * {@link OCREngineFactory} using an instance of {@code OCREngineConf}.
 * @author richter
 */
public interface OCREngineConf extends Serializable {

    /**
     * Validates itself.
     *
     * @param issueHandler the issue handler to communicate any unexpected
     * issues which occured during validation
     * @throws OCREngineConfValidationException if this configuration isn't
     * valid
     */
    void validate(IssueHandler issueHandler) throws OCREngineConfValidationException;
}
