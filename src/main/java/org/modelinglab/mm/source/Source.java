/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.modelinglab.mm.source;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Objects;

/**
 *
 * @author gortiz
 */
public class Source {
    /**
     * The URI where the source is stored.
     */
    private final URI resource;
    /**
     * The text that contains the source, if the source has not been saved.
     */
    private final String text;
    
    public Source(URI resource, String text){
        this.resource = resource;
        this.text = text;
    }

    public URI getResource() {
        return resource;
    }

    public Reader getReader() throws MalformedURLException, IOException {
        InputStream is;
        if(text != null) {
            is = new ByteArrayInputStream(text.getBytes());
        }
        else {
            URL url = resource.toURL();
            is = url.openStream();
        }
        Reader reader = new InputStreamReader(is);
        return reader;
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
