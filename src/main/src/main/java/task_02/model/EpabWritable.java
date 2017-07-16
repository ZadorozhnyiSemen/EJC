package task_02.model;

public interface EpabWritable {
    default void write() {
        System.out.println("Epab written");
    }
}
