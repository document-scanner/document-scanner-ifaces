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

import javax.swing.JPanel;
import richtercloud.message.handler.MessageHandler;

/**
 *
 * @author richter
 */
public abstract class ValueDetectionServiceConfPanel<C extends ValueDetectionServiceConf> extends JPanel {
    private static final long serialVersionUID = 1L;

    /**
     * Allows initialization of necessary properties after creation by
     * reflection with parameterless constructor.
     * @param serviceConf the {@link ValueDetectionServiceConf} to copy and to
     * initialize from
     */
    public abstract void init(C serviceConf,
            MessageHandler messageHandler);

    /**
     * Initialize with empty/new {@link ValueDetectionServiceConf}.
     */
    /*
    internal implementation notes:
    - not really necessary, but clearifies the difference to
    init(ValueDetectionServiceConf)
    */
    public abstract void init(MessageHandler messageHandler);

    /**
     * Returns the created instance of {@code C}.
     * @return the created instance
     */
    /*
    internal implementation note:
    - Creation of model objects in a view class isn't too elegant, but avoids
    referencing a factory class through annotations which has to be created
    through reflection -> do this as soon as necessary.
    */
    public abstract C getServiceConf();

    /**
     * Stores value of the GUI components on the passed
     * {@link ValueDetectionServiceConf}. Validation should occur with
     * {@link ValueDetectionServiceConf#validate() }.
     */
    public abstract void save() throws ValueDetectionServiceConfValidationException;

    public abstract void cancel();
}
