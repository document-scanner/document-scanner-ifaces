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

import javax.swing.JButton;

/**
 * A button which allows to track the process which has been started by pressing
 * it.
 *
 * @author richter
 */
public abstract class ProgressButton extends JButton {
    private static final long serialVersionUID = 1L;

    public ProgressButton() {
    }

    public ProgressButton(String text) {
        super(text);
    }

    public abstract float getProgress();

    public abstract void setProgress(float progress);
}
