package task_02.model;

public interface PdfWritable {
    default void write () {
        System.out.println("Pdf written");
    }
}
