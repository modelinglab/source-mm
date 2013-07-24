/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.modelinglab.mm.source;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 *
 * @author gortiz
 */
public class SourceError<S extends Source> {

    @Nonnull
    private final String errorMsg;
    @Nullable
    private final SourceSection errorSection;
    @Nullable
    private final S source;
    @Nonnull
    private final ErrorKind errorKind;

    public SourceError(String errorMsg, SourceSection errorSection, S source, ErrorKind errorKind) {
        this.errorMsg = errorMsg;
        this.errorSection = errorSection;
        this.source = source;
        this.errorKind = errorKind;

        if (errorMsg == null) {
            throw new NullPointerException("Error message must be non null");
        }
        if (errorKind == null) {
            throw new NullPointerException("Error kind must be non null");
        }
    }

    @Nonnull
    public ErrorKind getErrorKind() {
        return errorKind;
    }

    @Nonnull
    public String getErrorMsg() {
        return errorMsg;
    }

    @Nullable
    public SourceSection getErrorSection() {
        return errorSection;
    }

    @Nullable
    public S getSource() {
        return source;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        @SuppressWarnings("unchecked")
        final SourceError<S> other = (SourceError<S>) obj;
        if ((this.errorMsg == null) ? (other.errorMsg != null) : !this.errorMsg.equals(other.errorMsg)) {
            return false;
        }
        if (this.errorSection != other.errorSection && (this.errorSection == null || !this.errorSection.equals(other.errorSection))) {
            return false;
        }
        if (this.source != other.source && (this.source == null || !this.source.equals(other.source))) {
            return false;
        }
        if (this.errorKind != other.errorKind) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + (this.errorMsg != null ? this.errorMsg.hashCode() : 0);
        hash = 17 * hash + (this.errorSection != null ? this.errorSection.hashCode() : 0);
        hash = 17 * hash + (this.errorKind != null ? this.errorKind.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(2 * errorMsg.length());
        
        sb.append(errorKind).append(" at ");
        if (source == null) {
            sb.append("undefined file");
        } else {
            sb.append(source.getResource());
            if (errorSection == null) {
                sb.append("[Undefined section] ");
            }
            else {
                sb.append("[");
                sb.append(errorSection.getStartPosition().getLine());
                sb.append(',');
                sb.append(errorSection.getStartPosition().getColumn());
                sb.append("]");
            }
        }
        sb.append(": ").append(errorMsg);
        
        return sb.toString();
    }

    public static enum ErrorKind {

        ERROR, WARNING, SUGGESTION;
    }
}
