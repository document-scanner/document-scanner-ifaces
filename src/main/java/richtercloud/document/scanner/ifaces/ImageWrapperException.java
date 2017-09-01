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

/**
 * A wrapper for any exception which can occur inside {@link ImageWrapper}
 * methods.
 *
 * @author richter
 */
public class ImageWrapperException extends Exception {
    private static final long serialVersionUID = 1L;

    public ImageWrapperException(String message) {
        super(message);
    }

    public ImageWrapperException(String message, Throwable cause) {
        super(message, cause);
    }

    public ImageWrapperException(Throwable cause) {
        super(cause);
    }
}
