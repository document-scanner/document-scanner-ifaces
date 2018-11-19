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

import java.io.Serializable;

/*
internal implementation notes:
- It doesn't make sense make subclasses/-interfaces return the path of the JAR
file from which external services have been loaded because they can't be
deserialized because they won't be on the classpath after restart of the
application.
*/
/**
 * Specificies methods which configurations of {@link ValueDectectionService}s
 * need to be able to execute.
 * @author richter
 */
public interface ValueDetectionServiceConf extends Serializable {

    void validate() throws ValueDetectionServiceConfValidationException;

    String getDescription();
}
