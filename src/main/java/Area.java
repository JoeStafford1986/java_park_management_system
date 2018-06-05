import People.Visitor;

import java.util.ArrayList;

public class Area {
    private ArrayList<Paddock> paddocks;
    private ArrayList<Visitor> visitors;

    public Area() {
        this.paddocks = new ArrayList<>();
        this.visitors = new ArrayList<>();
    }

    public int getPaddocksCount() {
        return this.paddocks.size();
    }

    public int getVisitorsCount() {
        return this.visitors.size();
    }
}
