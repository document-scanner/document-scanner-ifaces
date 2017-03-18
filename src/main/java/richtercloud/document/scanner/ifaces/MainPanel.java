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

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
import org.apache.commons.lang3.tuple.Pair;
import richtercloud.document.scanner.valuedetectionservice.ValueDetectionServiceCreationException;
import richtercloud.reflection.form.builder.jpa.storage.PersistenceStorage;

/**
 *
 * @author richter
 */
public abstract class MainPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    public final static int EXPORT_FORMAT_PDF = 1;

    public abstract OCRSelectComponent getoCRSelectComponent();

    public abstract void setoCRSelectComponent(OCRSelectComponent oCRSelectComponent);

    public abstract Map<OCRSelectComponent, Pair<OCRPanel, EntityPanel>> getDocumentSwitchingMap();

    @Override
    public GroupLayout getLayout() {
        return (GroupLayout) super.getLayout();
    }

    public abstract void addDocument(Object entityToEdit) throws DocumentAddException, IOException;

    public abstract void addDocument(List<ImageWrapper> images,
            File selectedFile) throws DocumentAddException, IOException;

    public abstract void removeActiveDocument();

    public abstract int getDocumentCount();

    public abstract void setStorage(PersistenceStorage storage);

    public abstract void setoCREngine(OCREngine oCREngine);

    public abstract void exportActiveDocument(OutputStream outputStream,
            int exportFormat) throws IOException;

    public void exportActiveDocument(File outputFile,
            int exportFormat) throws FileNotFoundException, IOException {
        try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(outputFile))) {
            exportActiveDocument(outputStream,
                    exportFormat);
            outputStream.flush();
        }
    }

    /**
     * Create new {@link ValueDetectionService}s on all {@link EntityPanel}s
     * after a change of available and selected {@link ValueDetectionService}s
     * in configuration.
     */
    public abstract void applyValueDetectionServiceSelection() throws ValueDetectionServiceCreationException;
}
