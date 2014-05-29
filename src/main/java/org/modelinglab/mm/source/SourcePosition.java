/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.modelinglab.mm.source;

import java.io.Serializable;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;
import org.modelinglab.utils.doc.LineBasedDocTool;

/**
 *
 * @author Gonzalo Ortiz Jaureguizar (gortiz at software.imdea.org)
 */
/**
 * This class represents a position inside a text or document.
 */
@Immutable
public class SourcePosition implements Serializable, javax.swing.text.Position {
    private static final long serialVersionUID = 1L;
    /**
     * offset from start of the document or text, zero-based.
     */
    private final int offset;
    /**
     * pointed line in the document or text, one-based.
     */
    private final int line;
    /**
     * pointed column in the content or text, one-based.
     */
    private final int column;

    /**
     * 
     * @param translationTool
     * @param line one-based
     * @param column one-based
     */
    public SourcePosition(LineBasedDocTool translationTool, int line, int column) {
        this.line = line;
        this.column = column;
        this.offset = translationTool.getOffset(line, column);
    }
    
    /**
     * 
     * @param translationTool
     * @param offset zero-based
     */
    public SourcePosition(LineBasedDocTool translationTool, int offset) {
        this.offset = offset;
        Map<LineBasedDocTool.LineColumnEnum, Integer> lineCol = translationTool.getLineAndColumn(offset);
        this.line = lineCol.get(LineBasedDocTool.LineColumnEnum.LINE);
        this.column = lineCol.get(LineBasedDocTool.LineColumnEnum.COLUMN);
    }

    public SourcePosition(int line, int column, int offset) {
        this.line = line;
        this.column = column;
        this.offset = offset;
    }
    
    /**
     * @return pointed column in the content or text (one-based)
     */
    @Nonnull
    public int getColumn() {
        return column;
    }

    /**
     * @return pointed line in the document or text (one-based)
     */
    @Nonnull
    public int getLine() {
        return line;
    }

    /**
     * @return offset from start of the document or text (zero-based)
     */
    @Override
    @Nonnull
    public int getOffset() {
        return offset;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SourcePosition other = (SourcePosition) obj;
        if (this.offset != other.offset) {
            return false;
        }
        if (this.line != other.line) {
            return false;
        }
        if (this.column != other.column) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.offset;
        hash = 41 * hash + this.line;
        hash = 41 * hash + this.column;
        return hash;
    }

    @Override
    public String toString() {
        return "(" + offset + ", " + line + ", " + column + ')';
    }
}
