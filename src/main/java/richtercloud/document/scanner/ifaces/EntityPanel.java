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

import java.util.List;
import javax.swing.JPanel;
import richtercloud.document.scanner.valuedetectionservice.ValueDetectionResult;
import richtercloud.document.scanner.valuedetectionservice.ValueDetectionService;

/**
 * A component holding the {@link ReflectionFormPanel} most likely in a
 * containing component.
 *
 * Manages auto-OCR-value-detection and the result values since they're
 * associated with entity data.
 *
 * @author richter
 */
public abstract class EntityPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    /**
     * Runs the process of value detection (including a call to
     * {@link #valueDetectionGUI() }).
     *
     * @param oCRSelectPanelPanelFetcher
     * @param forceRenewal allows to force detection of values no matter which
     * values already have been recognized
     */
    public abstract void valueDetection(OCRSelectPanelPanelFetcher oCRSelectPanelPanelFetcher,
            boolean forceRenewal);

    /**
     * Clears all component model representing auto-OCR-value-detection results
     * and fills them with already retrieved data. This is useful if more
     * {@link ReflectionFormPanel}s  are added which weren't considered before
     * in which case it's unnecessary to run the complete detection again.
     */
    public abstract void valueDetectionGUI();

    public abstract List<ValueDetectionResult<?>> getDetectionResults();

    /**
     * Create new {@link ValueDetectionService}s after a change of available and
     * selected {@link ValueDetectionService}s in configuration.
     */
    public abstract void applyValueDetectionServiceSelection();

    /**
     * Returns the {@link ValueDetectionService} created at the last call to
     * {@link #applyValueDetectionServiceSelection() }.
     *
     * @return the value detection service
     */
    public abstract ValueDetectionService<?> getValueDetectionService();
}
