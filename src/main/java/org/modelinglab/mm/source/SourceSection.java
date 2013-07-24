/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.modelinglab.mm.source;

import java.io.Serializable;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

/**
 *
 * @author Gonzalo Ortiz Jaureguizar (gortiz at software.imdea.org)
 */
@Immutable
public class SourceSection implements Serializable {
    private static final long serialVersionUID = 1L;
    private final SourcePosition startPosition, endPosition;

    public SourceSection(SourcePosition start, SourcePosition end) {
        this.startPosition = start;
        this.endPosition = end;
    }

    @Nonnull
    public SourcePosition getEndPosition() {
        return endPosition;
    }

    @Nonnull
    public SourcePosition getStartPosition() {
        return startPosition;
    }

    public String getText(Document doc) throws BadLocationException {
        return doc.getText(startPosition.getOffset(), endPosition.getOffset());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SourceSection other = (SourceSection) obj;
        if (!Objects.equals(this.startPosition, other.startPosition)) {
            return false;
        }
        if (!Objects.equals(this.endPosition, other.endPosition)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.startPosition);
        hash = 19 * hash + Objects.hashCode(this.endPosition);
        return hash;
    }

    @Override
    public String toString() {
        return "[" + startPosition + ", " + endPosition + ']';
    }
}
