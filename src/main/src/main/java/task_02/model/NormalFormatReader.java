package task_02.model;

public class NormalFormatReader implements PdfReadable, EpabReadable {

    /**
     * Overridden <code>read()</code> method
     * needed with normal interfaces
     * compilation error otherwise
     */
    @Override
    public void read() {
        System.out.println("Reading file . . . ");
    }
}
