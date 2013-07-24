/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.modelinglab.mm.source;

import java.net.URI;
import java.util.Objects;

/**
 *
 * @author gortiz
 */
public class Source {
    private URI resource;
    
    public Source(URI resource){
        this.resource = resource;
    }

    public URI getResource() {
        return resource;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Source other = (Source) obj;
        if (!Objects.equals(this.resource, other.resource)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.resource);
        return hash;
    }
    
    
}
