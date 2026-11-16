abstract class Report {

    // Template method: the display sequence is fixed here, and subclasses
    // only supply the title, the data check, and the body.
    public final void displayReport() {

        if (!hasData()) {
            System.out.println("\n" + getEmptyMessage());
            return;
        }

        System.out.println("\n============= " + getTitle() + " =============");
        printBody();
    }

    protected abstract String getTitle();

    protected abstract void printBody();

    // Hooks with defaults, so subclasses override them only if needed
    protected boolean hasData() {
        return true;
    }

    protected String getEmptyMessage() {
        return "No data available for this report.";
    }
}
