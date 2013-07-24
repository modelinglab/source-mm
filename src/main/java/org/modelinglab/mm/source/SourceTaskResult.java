/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.modelinglab.mm.source;

import java.util.Collection;

/**
 *
 * @author gortiz
 */
public class SourceTaskResult<S extends Source,O> {
    
    private Collection<SourceError<S>> errors;
    private O output;

    public Collection<SourceError<S>> getErrors() {
        return errors;
    }

    public void setErrors(Collection<SourceError<S>> errors) {
        this.errors = errors;
    }

    public O getOutput() {
        return output;
    }

    public void setOutput(O output) {
        this.output = output;
    }
    
    
    
    public boolean isCorrect() {
        return getErrors().isEmpty();
    }
    
}

