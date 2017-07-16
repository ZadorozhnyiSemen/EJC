package task_02;

import task_02.model.*;

public class Main {
    public static void main(String[] args) {
        readWithNormalInterface();
        writeWithDefaultInterface();
    }

    /**
     * Creates NormalFormatReader and completes <code>write()</code>
     * method 3 times:
     * <li>First default call</li>
     * <li>Second call with cast to PdfReadable</li>
     * <li>Third call with cast to EpabReadable</li>
     */
    @SuppressWarnings("RedundantCast")
    private static void writeWithDefaultInterface() {
        NormalFormatReader reader = new NormalFormatReader();
        reader.read();

        ((PdfReadable) reader).read();
        ((EpabReadable) reader).read();
    }

    /**
     * Creates DefaultFormatWriter and completes <code>write()</code>
     * method 3 times:
     * <li>First default call</li>
     * <li>Second call with cast to PdfWritable</li>
     * <li>Third call with cast to EpabWritable</li>
     */
    @SuppressWarnings("RedundantCast")
    private static void readWithNormalInterface() {
        DefaultFormatWriter writer = new DefaultFormatWriter();
        writer.write();

        ((PdfWritable) writer).write();
        ((EpabWritable) writer).write();
    }
}
