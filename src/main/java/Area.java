import Animals.AnimalAttraction;
import People.Staff;
import People.Visitor;

import java.util.ArrayList;

public class Area {
    private ArrayList<Paddock> paddocks;
    private ArrayList<Visitor> visitors;
    private ArrayList<Staff> staffMembers;

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

    public void addVisitor(Visitor visitor) {
        this.visitors.add(visitor);
    }

    public void addStaff(Staff staff) {
        this.staffMembers.add(staff);
    }

    public void removePaddock(Paddock paddock) {
        this.paddocks.remove(paddock);
    }

    public void removeVisitor(Visitor visitor) {
        this.visitors.remove(visitor);
    }

    public void removeStaff(Staff staff) {
        this.staffMembers.remove(staff);
    }

    public void transferAnimalAttractionBetweenPaddocks(AnimalAttraction animalToTransfer, Paddock originPaddock, Paddock destinationPaddock) {
        int currentDinosaurCount = destinationPaddock.getAnimalAttractionsCount();
        destinationPaddock.addAnimalAttraction(animalToTransfer);
        if (destinationPaddock.getAnimalAttractionsCount() == currentDinosaurCount + 1)
        {
            originPaddock.removeAnimalAttraction(animalToTransfer);
        }
    }
}
