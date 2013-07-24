/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.modelinglab.mm.source;

import javax.annotation.concurrent.Immutable;

/**
 *
 * @author Gonzalo Ortiz Jaureguizar (gortiz at software.imdea.org)
 */
@Immutable
public abstract class SourceElement extends SourceSection {

    private final ElementIdDeclaration id;

    public SourceElement(ElementIdDeclaration id, SourcePosition start, SourcePosition end) {
        super(start, end);
        this.id = id;
    }

    public ElementIdDeclaration getIdDeclaration() {
        return id;
    }

    @Immutable
    public static class ElementIdDeclaration extends SourceSection {
        private static final long serialVersionUID = 1L;
        private final String id;

        public ElementIdDeclaration(String id, SourcePosition start, SourcePosition end) {
            super(start, end);
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }

    @Override
    public String toString() {
        return id.getId();
    }


}
