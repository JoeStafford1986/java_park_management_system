import People.Visitor;

import java.util.ArrayList;

public class Area {
    private ArrayList<Paddock> paddocks;
    private ArrayList<Visitor> visitors;
    private ArrayList<Visitor> staffMembers;

    public Area() {
        this.paddocks = new ArrayList<>();
        this.visitors = new ArrayList<>();
        this.staffMembers = new ArrayList<>();
    }

    public int getPaddocksCount() {
        return this.paddocks.size();
    }

    public int getVisitorsCount() {
        return this.visitors.size();
    }

    public int getStaffMembersCount() {
        return this.staffMembers.size();
    }

    public void addPaddock(Paddock paddock) {
        this.paddocks.add(paddock);
    }
}
