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

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
import org.apache.commons.lang3.tuple.Pair;

/**
 *
 * @author richter
 */
public abstract class MainPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    public abstract OCRSelectComponent getoCRSelectComponent();

    public abstract void setoCRSelectComponent(OCRSelectComponent oCRSelectComponent);

    public abstract Map<OCRSelectComponent, Pair<OCRPanel, EntityPanel>> getDocumentSwitchingMap();

    @Override
    public GroupLayout getLayout() {
        return (GroupLayout) super.getLayout();
    }

    public abstract void addDocument(Object entityToEdit) throws DocumentAddException;

    public abstract void addDocument(List<BufferedImage> images,
            File selectedFile) throws DocumentAddException;

    public abstract void removeActiveDocument();

    public abstract List<BufferedImage> retrieveImages(File selectedFile) throws DocumentAddException, InterruptedException, ExecutionException ;

    public abstract int getDocumentCount();
}
