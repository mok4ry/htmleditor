package edu.rit.se.antipattern.htmleditor.models;

/**
 * HTML Element that is an HTML tag with arbitrary contents.
 * 
 * @author Team ReichMafia
 */
public class TagElement implements Element {
    
    private String name = null;
    private Element[] contents = null;
    private java.util.HashMap<String,String> opts = null;
    
    /**
     * Initializes a TagElement with the given name and a string of contents,
     * which are parsed and stored as other elements.
     * 
     * @param name The name of this element (e.g. 'em', 'div', 'p', 'html')
     * @param contents The raw HTML between the opening and closing of this tag
     * @throws ParseException 
     */
    public TagElement( String name, java.util.HashMap<String,String> options,
            Element[] contents ) throws ParseException {
        this.name = name.toLowerCase();
        this.contents = contents;
        this.opts = options;
    }
    
    /**
     * Gets the name of this Tag.
     * 
     * @return The name of this Tag.
     */
    public String getName() {
        return name;
    }
    
    public Element[] getChildren() {
        return contents;
    }
    
    public java.util.ArrayList<String> getLinks() {
        java.util.ArrayList<String> links = new java.util.ArrayList<String>();
        if (name.equals("a") && opts.containsKey("href")) {
            links.add(opts.get("href"));
        }
        for ( Element e : contents ) links.addAll(e.getLinks());
        return links;
    }
    
    /**
     * Returns a string representation of this tag and its contents.
     * 
     * @return String representation of this tag and its contents.
     */
    @Override
    public String toString() {
        return name;
//        String result = String.format("<%s>", name );
//        for ( Element e : contents ) result += e.toString();
//        result += String.format("</%s>", name );
//        
//        return result;
    }
    
    @Override
    public boolean equals( Object o ) {
        try {
            Element e = (Element)o;
            if( !(e instanceof TagElement && e.getName().equals(name)) )
                return false;
            Element[] otherChildren = e.getChildren();
            for ( int i = 0; i < contents.length; i++ )
                if ( i >= otherChildren.length || !contents[i].equals(otherChildren[i]) )
                    return false;
        } catch ( ClassCastException e ) {
            return false;
        }
        return true;
    }
}
