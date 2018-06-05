import Animals.AnimalAttraction;
import People.Staff;
import People.Visitor;

import java.util.ArrayList;

public class Park {
    private ArrayList<Area> areas;
    private ArrayList<Visitor> visitors;
    private ArrayList<Staff> staffMembers;
    private ArrayList<AnimalAttraction> animalAttractions;

    public Park() {
        areas = new ArrayList<>();
        visitors = new ArrayList<>();
        staffMembers = new ArrayList<>();
        animalAttractions = new ArrayList<>();
    }

    public int getAreasCount() {
        return this.areas.size();
    }

    public int getVisitorsCount() {
        return this.visitors.size();
    }

    public int getStaffMembersCount() {
        return this.staffMembers.size();
    }

    public int getAnimalAttractionsCount() {
        return this.animalAttractions.size();
    }

    public void addArea(Area area) {
        this.areas.add(area);
    }

    public void addVisitor(Visitor visitor) {
        this.visitors.add(visitor);
    }

    public void addStaffMember(Staff staff) {
        this.staffMembers.add(staff);
    }

    public void addAnimalAttraction(AnimalAttraction animalAttraction) {
        this.animalAttractions.add(animalAttraction);
    }

    public void removeVisitor(Visitor visitor) {
        this.visitors.remove(visitor);
    }

    public void removeStaffMember(Staff staff) {
        this.staffMembers.remove(staff);
    }

    public void removeAnimalAttraction(AnimalAttraction animalAttraction) {
        this.animalAttractions.remove(animalAttraction);
    }

    public void transferVisitorBetweenAreas(Visitor visitor, Area originArea, Area destinationArea) {
        originArea.removeVisitor(visitor);
        destinationArea.addVisitor(visitor);
    }

    public void transferStaffBetweenAreas(Staff staff, Area originArea, Area destinationArea) {
        originArea.removeStaff(staff);
        destinationArea.addStaff(staff);
    }
}
