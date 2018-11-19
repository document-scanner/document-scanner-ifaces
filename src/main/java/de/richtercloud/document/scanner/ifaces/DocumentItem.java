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
package de.richtercloud.document.scanner.ifaces;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author richter
 */
public class DocumentItem {
    private Object entityToEdit;
    /**
     * The images of the document item.
     */
    /*
    internal implementation notes:
    - enforcing initialization with an empty list, e.g. if entityToEdit is
    specified in constructor doesn't work because images are most likely not yet
    retrieved
    */
    private List<ImageWrapper> images;
    private File selectedFile;

    public DocumentItem(Object entityToEdit,
            List<ImageWrapper> images,
            File selectedFile) {
        this.entityToEdit = entityToEdit;
        this.images = images;
        this.selectedFile = selectedFile;
    }

    public DocumentItem(Object entityToEdit) {
        this(entityToEdit,
                null, //images
                null //selectedFile
        );
    }

    public DocumentItem(List<ImageWrapper> images) {
        this(null, //entityToEdit
                images,
                null //selectedFile
        );
    }

    public DocumentItem() {
        this(null, //entityToEdit
                new LinkedList<>(), //images
                null //selectedFile
        );
    }

    public Object getEntityToEdit() {
        return entityToEdit;
    }

    public void setEntityToEdit(Object entityToEdit) {
        this.entityToEdit = entityToEdit;
    }

    public List<ImageWrapper> getImages() {
        return images;
    }

    public void setImages(List<ImageWrapper> images) {
        this.images = images;
    }

    public File getSelectedFile() {
        return selectedFile;
    }

    public void setSelectedFile(File selectedFile) {
        this.selectedFile = selectedFile;
    }
}
