import java.util.ArrayList;

public class Area {
    private ArrayList<Paddock> paddocks;

    public Area() {
        this.paddocks = new ArrayList<>();
    }

    public int getPaddocksCount() {
        return this.paddocks.size();
    }
}
