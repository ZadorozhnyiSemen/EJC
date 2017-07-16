package task_02.model;

public class DefaultFormatWriter implements PdfWritable, EpabWritable {

    /**
     * Overridden <code>write()</code> method
     * needed even with usage of default interfaces
     * compilation error otherwise
     */
    @Override
    public void write() {
        System.out.println("Writing file . . .");
    }
}
