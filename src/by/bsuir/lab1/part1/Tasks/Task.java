package by.bsuir.lab1.part1.Tasks;

public abstract class Task {
    public void doTask() {
        getDescription();
        getArguments();
    }
    abstract void getArguments();
    abstract void getDescription();
}
