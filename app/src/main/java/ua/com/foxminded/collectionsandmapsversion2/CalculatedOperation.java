package ua.com.foxminded.collectionsandmapsversion2;

public class CalculatedOperation {

    private int durationOfOperation;
    private boolean progressBarVisibility;

    public CalculatedOperation(int durationOfOperation, boolean progressBarVisibility) {
        this.durationOfOperation = durationOfOperation;
        this.progressBarVisibility = progressBarVisibility;
    }

    public int getDurationOfOperation() {
        return durationOfOperation;
    }

    public boolean getProgressBarVisibility() {
        return progressBarVisibility;
    }
}
