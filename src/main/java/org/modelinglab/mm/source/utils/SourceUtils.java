/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.modelinglab.mm.source.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import org.modelinglab.mm.source.Source;
import org.modelinglab.mm.source.SourcePosition;

/**
 *
 * @author Miguel Angel Garcia de Dios <miguelangel.garcia at imdea.org>
 */
public class SourceUtils {
    private SourceUtils() {}
    
    public static Reader createReaderFromSource(Source source) throws MalformedURLException, IOException{
        URI resource = source.getResource();
        URL url = resource.toURL();
        InputStream inputStream = url.openStream();
        Reader reader = new InputStreamReader(inputStream);
        return reader;
    }
}
